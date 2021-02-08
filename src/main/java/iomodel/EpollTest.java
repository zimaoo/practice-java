package iomodel;

import sun.nio.ch.PollSelectorProvider;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangxinpeng
 * @date 2020/11/17
 */
public class EpollTest {
    public static void main(String[] args) throws Exception {
        Selector selector = PollSelectorProvider.provider().openSelector();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(1111));

        serverSocketChannel.configureBlocking(false);

        int ops = serverSocketChannel.validOps();
        serverSocketChannel.register(selector, ops, null);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();

            while (selectionKeyIterator.hasNext()) {
                SelectionKey selectionkey = selectionKeyIterator.next();
                if (selectionkey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("建立连接：" + socketChannel.getLocalAddress() + "\n");
                } else if (selectionkey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionkey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                    socketChannel.read(byteBuffer);
                    String result = new String(byteBuffer.array()).trim();
                    System.out.println("收到信息：" + result);

                    if (result.equals("232323")) {
                        socketChannel.close();
                        System.out.println("收到暗号，关闭连接！");
                    }
                }
                selectionKeyIterator.remove();
            }
        }
    }

}
