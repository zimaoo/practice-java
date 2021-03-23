package lang.operator;

/**
 * @author zhangxinpeng
 * @date 2021/3/15
 */
public class BitOperator {
    public static void main(String[] args) {
        System.out.println(-1 << 29);
        System.out.println(0 << 29);
        System.out.println(1 << 29);
        System.out.println((1 << 29) - 1);
        System.out.println(2 << 3);
        System.out.println(1 << 3);
        // 0001 -> 1000
    }
}
