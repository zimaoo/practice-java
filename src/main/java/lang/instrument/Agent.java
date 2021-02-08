package lang.instrument;

import java.lang.instrument.Instrumentation;

/**
 * @author zhangxinpeng
 * @date 2021/1/4
 */
public class Agent {
    public static void agentmain(String args, Instrumentation instrumentation) {
        System.out.println("Args: " + args);
    }

    public static void premain(String args, Instrumentation instrumentation) {
        Class[] clazzList = instrumentation.getAllLoadedClasses();
        for (Class clazz : clazzList) {
            System.out.println(clazz.getName());
        }
    }
}
