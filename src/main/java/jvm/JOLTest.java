package jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhangxinpeng
 * @date 2021/3/25
 */
public class JOLTest {
    public static void main(String[] args) {
        Clazz clazz = new Clazz();
        System.out.println(ClassLayout.parseInstance(clazz).toPrintable());
        System.out.println("===");
        // System.out.println(Integer.toHexString(clazz.hashCode()));
        System.gc();
        System.out.println("===");
        System.out.println(ClassLayout.parseInstance(clazz).toPrintable());
    }
}

class Clazz {
//    int a = 23;
}
