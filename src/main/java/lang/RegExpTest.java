package lang;

import java.util.regex.Pattern;

/**
 * @author zhangxinpeng
 * @date 2020/6/8
 */
public class RegExpTest {
    public static void main(String[] args) {
        String v = "20200608165324xxx";
        System.out.println(v.length());
        String bigNumberPattern = "^\\d{10,}$";
        boolean isMatched = Pattern.matches(bigNumberPattern, v);
        if (isMatched) {
            v = "$".concat(v);
        }
        System.out.println(v);
    }
}
