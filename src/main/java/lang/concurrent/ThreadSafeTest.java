package lang.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2020/3/1
 */
public class ThreadSafeTest {
    public static void main(String[] args) {
        List unsafeList = new ArrayList();
        List safeList = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 3; i++) {
            unsafeList.clear();
            safeList.clear();
            int unsafeSize = addByThread(unsafeList, "unsafe");
            int safeSize = addByThread(safeList, "safe");
            System.out.println("unsafe / safe: " + unsafeSize + "/" + safeSize);
        }
    }
    public static int addByThread(List list, String type) {
        ThreadGroup threadGroup = new ThreadGroup(type);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("23");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 10000; i++) {
            new Thread(threadGroup, runnable).start();
        }

        while(threadGroup.activeCount() > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return list.size();
    }
}
