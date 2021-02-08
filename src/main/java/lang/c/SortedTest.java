package lang.c;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxinpeng
 * @date 2019-12-23
 */
public class SortedTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING    = -1 << COUNT_BITS;

    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<Integer>(){{
//            add(1);
//            add(3);
//            add(2);
//        }};
//        System.out.println(JSON.toJSONString(l));
//
//        List<Integer> a = l.stream().sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        }).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(a));
//        System.out.println(TestEnum.TEST1.name());
//        System.out.println(isExpired(158073170703L, System.currentTimeMillis()));
//        Object j = null;
//        String a = (String)j;
//        System.out.println(a);
//        System.out.println(SortedTest.class.getPackage().getName());
//        System.out.println(RUNNING);
//        System.out.println(Integer.toBinaryString(-14));
//        String str = "000";
//        System.out.println(new StringBuilder(str).replace(0, 1, "1"));
//        System.out.println("a".equals(String.valueOf('a')));
//        String dayOfMonth = "23";
//        System.out.println();
//        for (Method method : SortedTest.class.getDeclaredMethods()) {
//            System.out.println(method.getParameters()[0].getParameterizedType() == long.class);
//        }
//        Map<Integer, Integer> map1 = new HashMap<>();
//        map1.put(1, 2);
//        map1.put(2, 3);
//
//        Map<Integer, Integer> map2 = new HashMap<>();
//        map2.put(1, 2);
//        map2.put(2, 3);
//
//        map2.forEach((k, v) -> map1.merge(k, v, Integer::sum));
//
//        map1.entrySet().forEach(e -> {
//            System.out.println(e.getKey() + " : " + e.getValue());
//        });

//        System.out.println(String.format("i %d", Long.MAX_VALUE));
        int a = 23;
        if (new Integer(a) instanceof Integer) {

        }
//        for (int i = 0; i < 5; i++) {
//            executor.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " : ABC");
//            });
//        }
//        System.out.println(Thread.currentThread().getName());
//        executor.shutdown();
    }

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1,
            1L, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(1), new ThreadPoolExecutor.CallerRunsPolicy());

    private static boolean isExpired(long item, long currentTimeMillis) {
        long expireAt = item;

        if (expireAt < 0 || expireAt >= currentTimeMillis) {
            return false;
        }

        return true;
    }
}

enum TestEnum {
    TEST1;
}
