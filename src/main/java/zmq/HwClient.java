package zmq;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

/**
 * @author zhangxinpeng
 * @date 2020/11/11
 */
public class HwClient {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {
            System.out.println("Connecting to hello world server");
            ZMQ.Socket socket = context.createSocket(SocketType.REQ);
            socket.connect("tcp://localhost:5555");
            for (int i = 0; i <= 10; i++) {
                String request = "Hello";
                socket.send(request.getBytes(ZMQ.CHARSET), 0);
                byte[] reply = socket.recv();
                System.out.println("Received " + new String(reply, ZMQ.CHARSET) + " " + i);
            }
        }
    }
}
