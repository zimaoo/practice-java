package lang.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhangxinpeng
 * @date 2019-08-13
 */
public class AtomicReferenceTest {
    private static AtomicReference<User> userAtomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("Tad", 23);
        userAtomicReference.set(user);
        User updatedUser = new User("XXX", 43);
        userAtomicReference.compareAndSet(user, updatedUser);
        System.out.println(userAtomicReference.get().getName());
        System.out.println(userAtomicReference.get().getAge());
    }
}
