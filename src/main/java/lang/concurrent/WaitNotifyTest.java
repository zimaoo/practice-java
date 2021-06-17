package lang.concurrent;

/**
 * @author zhangxinpeng
 * @date 2021/6/17
 */
public class WaitNotifyTest {
    public synchronized void testWait() throws InterruptedException {
        System.out.println("==> " + Thread.currentThread().getName() + " start");
        wait(100000);
        System.out.println("==> " + Thread.currentThread().getName() + " stop");
    }

    public static void main(String[] args) throws Exception {
        WaitNotifyTest test = new WaitNotifyTest();
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    test.testWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        synchronized (test) {
            test.notify();
        }

        Thread.sleep(60000);
        System.out.println("======");
        synchronized (test) {
            test.notifyAll();
        }
        Thread.sleep(60000);
    }
}
