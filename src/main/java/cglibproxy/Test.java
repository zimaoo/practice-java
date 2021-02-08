package cglibproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhangxinpeng
 * @date 2019-12-19
 */
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Test.class);
        enhancer.setCallback(new TestMethodInterceptor());
        Test t = (Test)enhancer.create();
        t.sayHello("Tad");
    }

    public void sayHello(String name) {
        System.out.println("Hola, " + name);
    }
}
