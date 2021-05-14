package lang.annotation;

/**
 * @author zhangxinpeng
 * @date 2021/4/15
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Test.class.getAnnotation(Annotation.class));
        System.out.println(Test.class.isAnnotationPresent(Annotation.class));
    }
}
