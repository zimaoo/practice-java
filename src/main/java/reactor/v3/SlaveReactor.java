package reactor.v3;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhangxinpeng
 * @date 2021/2/8
 */
public class SlaveReactor implements Runnable {
    private ConcurrentLinkedQueue<Handler> events = new ConcurrentLinkedQueue<>();

    private Selector selector;

    public SlaveReactor() {
        try {
            System.out.println("slave reactor init");
            // this.selector = Selector.open();
            this.selector = Selector.open();
            System.out.println(selector.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Handler handler;
                while ((handler = events.poll()) != null) {
                    SocketChannel clientSocketChannel = handler.getClientSocketChannel();
                    clientSocketChannel.configureBlocking(false);
                    SelectionKey selectionKey = clientSocketChannel.register(selector, SelectionKey.OP_READ);
                    selectionKey.attach(handler);
                    handler.setClientSelectionKey(selectionKey);
                    System.out.println(Thread.currentThread().getName() + " register a client");
                }

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

    public void registerHandler(Handler handler) {
        events.add(handler);
        selector.wakeup();
    }
}
