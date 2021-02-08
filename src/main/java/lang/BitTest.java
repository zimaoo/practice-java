package lang;

import java.nio.channels.SelectionKey;

/**
 * @author zhangxinpeng
 * @date 2021/2/8
 */
public class BitTest {
    public static void main(String[] args) {
        System.out.println(SelectionKey.OP_READ);
        System.out.println(SelectionKey.OP_WRITE);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_ACCEPT);
    }
}
