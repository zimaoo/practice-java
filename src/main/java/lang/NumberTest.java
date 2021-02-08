package lang;

/**
 * @author zhangxinpeng
 * @date 2020/3/17
 */
public class NumberTest {
    public static void main(String[] args) {
        int amount = 2592000;
        // 如果1000后无L会产生int越界。
        long delta =  amount * 1000L;
        System.out.println(delta);
        System.out.println(System.currentTimeMillis() + delta);
    }
}
