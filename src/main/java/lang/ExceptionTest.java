package lang;

/**
 * @author zhangxinpeng
 * @date 2020/3/24
 */
public class ExceptionTest {
    public static void main(String[] args) {
//        try {
//            a();
//            System.out.println("main1");
//        } catch (Exception e) {
//            System.out.println("main2" + e.getClass());
//        } finally {
//            System.out.println("main3");
//        }
        System.out.println(b());
    }

    public static void a() {
        try {
            int b = 1 / 0;
        } finally {
            System.out.println("Finally");
        }
    }

    public static int b() {
        try {
            return 23;
        } finally {
            System.out.println("xxxx");
        }
    }
}
