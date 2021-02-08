package lang.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zhangxinpeng
 * @date 2019-08-13
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println("First");
        }
    });

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 我已到达屏障，此线程被阻塞。
                    cyclicBarrier.await();
                } catch (InterruptedException e) {

                } catch (BrokenBarrierException e) {

                }
                System.out.println(1);
            }
        }).start();
        try {
            cyclicBarrier.await();
        } catch (Exception e) {

        }
        System.out.println(2);
    }
}
