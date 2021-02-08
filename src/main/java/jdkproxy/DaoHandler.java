package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhangxinpeng
 * @date 2019-12-19
 */
public class DaoHandler implements InvocationHandler {

    private Object target;

    public DaoHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Start");

        method.invoke(target, args);

        System.out.println("Stop");

        return null;
    }
}
