package iomodel;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2020/11/17
 */
public class NioTest {
    public static void main(String[] args) throws Exception {
        List<SocketChannel> clientList = new ArrayList<>();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 监听 8080 端口进来的 TCP 链接
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        // 非阻塞
        serverSocketChannel.configureBlocking(false);
        while (true) {
            SocketChannel client = serverSocketChannel.accept();
            if (client != null) {
                client.configureBlocking(false);
                clientList.add(client);
            }

            for (SocketChannel socketChannel : clientList) {
                // 处理
            }
        }
    }
}
