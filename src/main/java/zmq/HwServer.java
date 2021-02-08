package zmq;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

/**
 * @author zhangxinpeng
 * @date 2020/11/11
 */
public class HwServer {
    public static void main(String[] args) throws Exception {
        try(ZContext context = new ZContext()) {
            ZMQ.Socket socket = context.createSocket(SocketType.REP);
            socket.bind("tcp://*:5555");
            while (!Thread.currentThread().isInterrupted()) {
                byte[] reply = socket.recv(0);
                System.out.println(
                        "Received " + ": [" + new String(reply, ZMQ.CHARSET) + "]"
                );
                String response = "world";
                socket.send(response.getBytes(ZMQ.CHARSET), 0);
                Thread.sleep(100);
            }
        }
    }
}
