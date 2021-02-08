package lang;

import com.alibaba.fastjson.JSON;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2020/5/11
 */
public class ComparatorTest {
    public static void main(String[] args) {
//        List<Masterpiece> l = new ArrayList<>();
//        Masterpiece m3 = new Masterpiece();
//        m3.a = 2;
//        m3.b = 2;
//        l.add(m3);
//        Masterpiece m2 = new Masterpiece();
//        m2.a = 1;
//        m2.b = 3;
//        l.add(m2);
//        Masterpiece m1 = new Masterpiece();
//        m1.a = 1;
//        m1.b = 2;
//        l.add(m1);
//        l.stream().sorted((o1, o2) -> {
//            return (o1.a - o2.a) * 100 + (o1.b - o2.b);
//        }).forEach(e -> {
//            System.out.println(JSON.toJSONString(e));
//        });

        int freeVoteRedPoint = 0;
        if (true) {
            freeVoteRedPoint = 1;
        }
        System.out.println(freeVoteRedPoint);
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        l.add(3);
//        l.add(2);
//        System.out.println(l);
//        l.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).forEach(e -> {
//            System.out.println(e);
//        });
//        System.out.println(getDecoCompExpireAt(15));
//        Boolean a = Boolean.TRUE;
////        System.out.println(a);
////        a(a);
////        System.out.println(a);

    }

    public static void a(Boolean a) {
        a = Boolean.FALSE;
    }

    public static int getDecoCompExpireAt(int criticalHour) {
        DateTime dateTime = DateTime.now();
        int hourOfDay = dateTime.getHourOfDay();
        if (hourOfDay >= criticalHour) {
            return Integer.parseInt(dateTime.plusDays(1).toString("yyyyMMdd")) * 100 + criticalHour;
        } else {
            return Integer.parseInt(dateTime.toString("yyyyMMdd")) * 100 + criticalHour;
        }
    }
}


class Masterpiece {
    public int a;
    public int b;
}
