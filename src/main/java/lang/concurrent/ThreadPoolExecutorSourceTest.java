package lang.concurrent;

/**
 * @author zhangxinpeng
 * @date 2021/3/26
 */
public class ThreadPoolExecutorSourceTest {
    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(COUNT_BITS));

        System.out.println(Integer.toBinaryString((1 << COUNT_BITS)));
        System.out.println(Integer.toBinaryString((1 << COUNT_BITS) - 1));
        System.out.println(Integer.toBinaryString(-4));
    }
}
