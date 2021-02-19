package reactor.v3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author zhangxinpeng
 * @date 2021/2/7
 */
public class Handler implements Runnable {
    private SocketChannel clientSocketChannel;
    private SelectionKey clientSelectionKey;
    ByteBuffer inputByteBuffer = ByteBuffer.allocate(1024);
    ByteBuffer outputByteBuffer = ByteBuffer.allocate(1024);

    private static final int READING = 0, SENDING = 1;
    private int state = READING;

    public Handler(SocketChannel client) {
        this.clientSocketChannel = client;
    }

    public SocketChannel getClientSocketChannel() {
        return clientSocketChannel;
    }

    public void setClientSocketChannel(SocketChannel clientSocketChannel) {
        this.clientSocketChannel = clientSocketChannel;
    }

    public SelectionKey getClientSelectionKey() {
        return clientSelectionKey;
    }

    public void setClientSelectionKey(SelectionKey clientSelectionKey) {
        this.clientSelectionKey = clientSelectionKey;
    }

    @Override
    public void run() {
        try {
            if (state == READING) {
                read();
            } else if (state == SENDING) {
                send();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read() throws IOException {
        clientSocketChannel.read(inputByteBuffer);
        if (isInputComplete()) {
            process();
            state = SENDING;
            clientSelectionKey.interestOps(SelectionKey.OP_WRITE);
        }
    }

    private void send() throws IOException {
        clientSocketChannel.write(outputByteBuffer);
        if (isOutputComplete()) {
            // selectionKey.cancel();
            state = READING;
            clientSelectionKey.interestOps(SelectionKey.OP_READ);
            outputByteBuffer.clear();
        }
    }

    private boolean isInputComplete() {
        return true;
    }

    private boolean isOutputComplete() {
        return true;
    }

    private void process() {
        String s = new String(inputByteBuffer.array()).trim();
        inputByteBuffer.clear();
        System.out.println("process: " + s);
        s = s + " from s\n";
        outputByteBuffer = ByteBuffer.wrap(s.getBytes());
    }
}
