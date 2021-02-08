package lang.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangxinpeng
 * @date 2019-08-13
 */
public class CountDownLatchTest {

    private static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws Exception {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Parser1 finished.");
                c.countDown();
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Parser2 finished.");
                c.countDown();
            }
        });
        parser1.start();
        parser2.start();
        // parser2.join();
        c.await();
        System.out.println("All parser finished.");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//                c.countDown();
//                System.out.println(2);
//                c.countDown();
//            }
//        }).start();
        // System.out.println(3);
    }
}
