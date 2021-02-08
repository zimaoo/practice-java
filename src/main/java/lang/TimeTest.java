package lang;

import java.util.Calendar;

/**
 * @author zhangxinpeng
 * @date 2020/4/6
 */
public class TimeTest {
    public static void main(String[] args) {
        System.out.println((getYesterdayLastMillisecond() - 1585843199999L)/ (1000 * 3600 * 24));
    }
    public static long getYesterdayLastMillisecond() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTimeInMillis();
    }
}
