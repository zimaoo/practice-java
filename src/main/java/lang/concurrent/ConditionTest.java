package lang.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangxinpeng
 * @date 2021/6/18
 */
public class ConditionTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println(String.format("条件满足，线程%s运行！", Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String args[]) throws InterruptedException {
        ConditionTest conditionTest = new ConditionTest();
        Thread thread1 = new Thread(conditionTest);
        thread1.setName("T1");
        thread1.start();
        Thread.sleep(2000);
        System.out.println("通知T1条件满足");
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
