package lang.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zhangxinpeng
 * @date 2019-08-13
 */
public class CyclicBarrierTest0 {
    private static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {}
            }
        });
        thread.start();
//        thread.interrupt();
        try {
            System.out.println(c.getNumberWaiting());
            c.await();
            System.out.println(c.getNumberWaiting());
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
    }
}
