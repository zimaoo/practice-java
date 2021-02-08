package actor;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhangxinpeng
 * @date 2021/1/29
 */
public interface Calculator {
    /**
     *
     * @param a
     * @param b
     * @return
     */
    CompletableFuture<Integer> add(int a, int b);
}
