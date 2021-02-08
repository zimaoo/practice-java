package lang.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangxinpeng
 * @date 2019-08-13
 */
public class ExchangerTest {

    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String a = "银行流水A";
                    exchanger.exchange(a);
                } catch (Exception e) {}
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String b = "银行流水B";
                    String a = exchanger.exchange("b");
                    System.out.println("是否一致: " + a.equals(b));
                    System.out.println("a: " + a);
                    System.out.println("b: "+ b);
                } catch (InterruptedException e) {}
            }
        });
        threadPool.shutdown();
    }
}
