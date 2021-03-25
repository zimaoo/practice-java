package jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhangxinpeng
 * @date 2021/3/25
 */
public class JOLTest {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(JOLTest.class).toPrintable());
    }
}
