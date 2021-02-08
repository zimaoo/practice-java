package lang.instrument;

import java.lang.management.ManagementFactory;

/**
 * @author zhangxinpeng
 * @date 2021/1/5
 */
public class RuntimeMX {
    public static void main(String[] args) {
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(jvmName);
    }
}
