package iomodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangxinpeng
 * @date 2020/11/17
 */
public class BioTest {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("=== 服务启动 ===");
        while (true) {
            Socket client = serverSocket.accept();
            System.out.println(String.format("=== 接收到请求：IP：%s, Port %d", client.getInetAddress().getHostAddress(), client.getPort()));
            new Thread(() -> {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    while (true) {
                        System.out.println(bufferedReader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
