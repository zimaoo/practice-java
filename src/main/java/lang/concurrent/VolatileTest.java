package lang.concurrent;

/**
 * @author zhangxinpeng
 * @date 2020/3/1
 */
public class VolatileTest {
    public static volatile int cnt = 0;
    public static void add() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cnt++;
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    add();
                }
            }).start();
        }
        System.out.println("Result is " + cnt);
    }
}
