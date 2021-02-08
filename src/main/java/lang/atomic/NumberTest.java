package lang.atomic;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangxinpeng
 * @date 2019-04-23
 */
public class NumberTest {
    public static void main(String[] args) {
//        System.out.printf("%.3f", (float)3 / 10);
//        int winRoundCount = 3;
//        int roundCount = 10;
//        System.out.println(String.format("%.3f", (float)winRoundCount / roundCount));
//        System.out.println(JSON.toJSONString(new MatchBalance()));
//        System.out.println(String.format("%.1f", (float) 1 / 3 * 100).concat("%"));
//        Object obj = 1;
//        print (23, "AB");
//        int offset = Calendar.getInstance().getTimeZone().getRawOffset();
//        String TOTAL_MONEY_DAILY_KEY_PREFIX = "total:score:daily:";
//        String MONEY_DAILY_KEY_PREFIX = "score:daily:";
//        long timestamp = System.currentTimeMillis();
//        long today = (timestamp + offset) / 24 / 60 / 60 / 1000;
        long timestamp = System.currentTimeMillis();
        String uid = "40023897"; // "67531111";
        int offset = Calendar.getInstance().getTimeZone().getRawOffset();
        long today = (timestamp+ offset) / 24 / 60 / 60 / 1000;
//        System.out.println(String.format("app:%s%s:%s", TOTAL_MONEY_DAILY_KEY_PREFIX, today, uid));
//        System.out.println(String.format("app:%s%s:%s:%s", MONEY_DAILY_KEY_PREFIX, today, "1160", uid));
        System.out.println(String.format("app:%s%s:%s","score:daily:", today, uid));
        AtomicInteger atomicInteger = new AtomicInteger();
    }
    public static void print(int a, String b, String... chineseName) {
        String name = "";
        if (chineseName.length != 0) {
            name = chineseName[0];
        }
        System.out.print(a + b + name);
    }
}
