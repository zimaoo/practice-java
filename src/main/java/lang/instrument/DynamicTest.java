package lang.instrument;

/**
 * @author zhangxinpeng
 * @date 2021/1/7
 */
public class DynamicTest {
    public static void main(String[] args) throws Exception {
        int result = 0;
        while (true) {
            result++;
            System.out.println(result);
            Thread.sleep(5000);
        }
    }
}
