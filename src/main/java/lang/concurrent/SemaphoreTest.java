package lang.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zhangxinpeng
 * @date 2019-08-13
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i ++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("Save data : " + String.valueOf(semaphore.availablePermits()));
                        semaphore.release();
                    } catch (Exception e) {}
                }
            });
        }
        threadPool.shutdown();
    }
}
