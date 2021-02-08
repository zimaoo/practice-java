package actor;

/**
 * 测试类
 * @author zhangxinpeng
 * @date 2021/1/29
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Actor.init(StandardStudent.class);
        Actor.init(SimpleCalculator.class);
        Actor.getActor(Student.class).figure(23, 23);
        Actor.getActor(Student.class).figure(23, 24);
        Actor.getActor(Student.class).figure(23, 25);
    }
}
