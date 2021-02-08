package lang.math;

/**
 * @author zhangxinpeng
 * @date 2021/1/5
 */
public class HelloNative {
    static{
        System.loadLibrary("HelloNative");
    }

    public static native void sayHello();

    public static void main(String[]args){
        sayHello();
    }
}
