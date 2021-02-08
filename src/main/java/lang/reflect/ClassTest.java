package lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.concurrent.CompletableFuture;

/**
 * @author zhangxinpeng
 * @date 2019-10-28
 */
public class ClassTest implements Runnable {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        long timeStamp = System.currentTimeMillis();
//        for (int i = 0; i <= 100000000; i ++) {
//            ClassTest.class.getSimpleName();
//        }
//        System.out.println(System.currentTimeMillis() - timeStamp);
//        long x = 43200 * 1180 * 60 * 1000l;
//        Integer.MAX_VALUE
//        System

//        boolean isFree = false;
//
//        if (true && !(isFree)) {
//            System.out.println("In");
//        }
//
//        System.out.println(isFree);
//
//        Runtime.getRuntime().availableProcessors();
//        System.out.println(System.getProperty("user.dir"));
//        String t = "'abc'";
//        String t1 = t.replace("'", "\\\"");
//        System.out.println(t1);
//        long expireMillis = 1592450810799L;
//        System.out.println(expireMillis > 0 ? (int) ((expireMillis - System.currentTimeMillis())/ 1000) : 1);
//        System.out.println(getTodayZeroMillis());
//        List<String> a = new ArrayList<>();
//        a.add("a");
//        a.add("b");
//        System.out.printf(JSON.toJSONString(a.subList(a.size() - 1, a.size())));
        ClassTest classTest = new ClassTest();
        for (Method method : ClassTest.class.getMethods()) {
            if (method.getName() == "a") {
                Object obj = method.invoke(classTest, "hhh");
                System.out.println(obj instanceof CompletableFuture);
            }
        }

    }

    public static long getTodayZeroMillis() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public void a(String a) {
        System.out.println("#### " + a);
    }

    @Override
    public void run() {

    }
}
