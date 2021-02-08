package lang.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author zhangxinpeng
 * @date 2020/2/29
 */
public class ReferenceTest {
    public static void main(String[] args) {
        /* 软引用测试 */
        // 强引用
        String str1 = new String("abc");
        // 软引用
        SoftReference<String> softReference = new SoftReference<>(str1);
        // 去除强引用
        str1 = null;
        System.gc();
        System.out.println(softReference.get());

        /* 弱引用测试 */
        // 强引用
        String str2 = new String("123");
        // 弱引用
        WeakReference<String> weakReference = new WeakReference<>(str2);
        // 去除强引用
        str2 = null;
        System.gc();
        System.out.println(weakReference.get());
    }
}
