package reactor.v3;

import java.io.IOException;

/**
 * @author zhangxinpeng
 * @date 2021/2/8
 */
public class Test {
    public static void main(String[] args) throws IOException {
        SlaveReactor slaveReactor = new SlaveReactor();
        MasterReactor masterReactor = new MasterReactor(8089, slaveReactor);
        new Thread(masterReactor).start();
        new Thread(slaveReactor).start();
        System.out.println("Test is running, " + Thread.currentThread().getName());
    }
}
