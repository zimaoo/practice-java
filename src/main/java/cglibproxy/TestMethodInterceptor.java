package cglibproxy;

import com.alibaba.fastjson.JSON;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangxinpeng
 * @date 2019-12-19
 */
public class TestMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println(o.getClass().getName());
//        System.out.println(method);
//        System.out.println(JSON.toJSONString(objects));
//
//        methodProxy.invokeSuper(o, objects);
//        method.invoke(o, objects);

//        System.out.println(methodProxy);
        System.out.println(getClass().getName());
        System.out.println(getClass().getSimpleName());
        System.out.println(getClass().getCanonicalName());
        System.out.println(getClass().getTypeName());
        return null;
    }
}
