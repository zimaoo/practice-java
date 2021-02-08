package jdkproxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2019-12-19
 */
public class Test {
    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//        DaoHandler daoHandler = new DaoHandler(userDao);
//        Dao dao = (Dao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), daoHandler);
//        dao.delete();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
    }
}
