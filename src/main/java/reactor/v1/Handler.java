package reactor.v1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author zhangxinpeng
 * @date 2021/2/7
 */
public class Handler implements Runnable {
    private SocketChannel socket;
    private SelectionKey selectionKey;
    ByteBuffer inputByteBuffer = ByteBuffer.allocate(1024);
    ByteBuffer outputByteBuffer = ByteBuffer.allocate(1024);

    private static final int READING = 0, SENDING = 1;
    private int state = READING;

    public Handler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socket = socketChannel;
        socketChannel.configureBlocking(false);
        selectionKey = socket.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
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
        socket.read(inputByteBuffer);
        if (isInputComplete()) {
            process();
            state = SENDING;
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        }
    }

    private void send() throws IOException {
        socket.write(outputByteBuffer);
        if (isOutputComplete()) {
            // selectionKey.cancel();
            state = READING;
            selectionKey.interestOps(SelectionKey.OP_READ);
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
