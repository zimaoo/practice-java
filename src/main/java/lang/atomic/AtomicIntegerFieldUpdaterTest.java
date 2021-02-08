package lang.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author zhangxinpeng
 * @date 2019-08-13
 */
public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args) {
        User conan = new User("conan", 10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }
}
