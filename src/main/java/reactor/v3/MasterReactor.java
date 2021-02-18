package reactor.v3;

import reactor.v3.Handler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangxinpeng
 * @date 2021/2/8
 */
public class MasterReactor implements Runnable {
    private Selector selector;
    private ServerSocketChannel serverSocket;
    private SlaveReactor slaveReactor;

    public MasterReactor(int port, SlaveReactor slaveReactor) throws IOException {
        System.out.println("master reactor init");
        this.slaveReactor = slaveReactor;
        selector = Selector.open();
        System.out.println(selector.toString());
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Master reactor running, " + Thread.currentThread().getName());
                selector.select();
                Set<SelectionKey> selected = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selected.iterator();
                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                }
                selected.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatch(SelectionKey selectionKey) {
        Runnable r = (Runnable) selectionKey.attachment();
        if (r != null) {
            r.run();
        }
    }

    private class Acceptor implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("accepting...");
                SocketChannel c = serverSocket.accept();
                if (c != null) {
                    new Handler(slaveReactor, c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
