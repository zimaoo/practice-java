package lang.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author zhangxinpeng
 * @date 2019-08-12
 */
public class AtomicIntegerTest {

    // private static AtomicInteger v = new AtomicInteger(1);
    // private static int v = 1;
    // private static ExecutorService executorService = new ThreadPoolExecutor(10, 20, 2000, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private static int[] value = new int[] {1, 2, 3};
    private static AtomicIntegerArray ai = new AtomicIntegerArray(value);
    public static void main(String[] args) {
        ai.getAndSet(0, 23);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
//        for (int i = 0; i < 2; i++) {
//            // v = v + 1;
//            executorService.execute(() -> {
//                v.incrementAndGet();
//                v.getAndIncrement();
//            });
//        }
//        System.out.println(v);
//        executorService.shutdown();
    }
}
