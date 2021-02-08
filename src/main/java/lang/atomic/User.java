package lang.atomic;

/**
 * @author zhangxinpeng
 * @date 2019-08-13
 */
public class User {
    private String name;
    public volatile int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
