package actor;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhangxinpeng
 * @date 2021/1/29
 */
public class SimpleCalculator extends Actor implements Calculator {
    private SimpleCalculator() {
        setName("计算器");
    }

    @Override
    public CompletableFuture<Integer> add(int a, int b) {
        System.out.println(String.format("%s: %d + %d", currentThread().getName(), a, b));
        return CompletableFuture.completedFuture(a + b);
    }
}
