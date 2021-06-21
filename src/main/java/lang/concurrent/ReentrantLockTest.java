package lang.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangxinpeng
 * @date 2021/6/18
 */
public class ReentrantLockTest implements Runnable {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTest lc = new ReentrantLockTest();
        new Thread(lc, "a").start();
        new Thread(lc, "b").start();
    }

    @Override
    public void run() {
        try {
            lock.lock();
            for(int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        } finally {
            lock.unlock();
        }
    }
}
