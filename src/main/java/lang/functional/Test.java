package lang.functional;

/**
 * @author zhangxinpeng
 * @date 2021/1/15
 */
public class Test {
    public static void main(String[] args) {
        t(() -> { return "你好，谷成毅！"; });
    }

    public static void t(Hello h) {
        System.out.println(h.sayHi());
    }
}
