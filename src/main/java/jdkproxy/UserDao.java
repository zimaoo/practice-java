package jdkproxy;

/**
 * @author zhangxinpeng
 * @date 2019-12-19
 */
public class UserDao implements Dao {
    @Override
    public void delete() {
        System.out.println("UserDao delete");
    }
}
