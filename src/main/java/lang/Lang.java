package lang;

/**
 * @author zhangxinpeng
 * @date 2021/2/2
 */
public class Lang {
    public static void main(String[] args) {
        // System.out.println(Integer.MAX_VALUE + 1);
        // m();
        m("Hello", "world");
    }

    public static void m(String str, String... misc) {
        System.out.println(str);
        if (misc.length != 0) {
            System.out.println(misc[0]);
        }
    }

}
