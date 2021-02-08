package spring;

/**
 * @author zhangxinpeng
 * @date 2021/1/6
 */
public class TestBean {
    private String desc = "TestBean Hello World";

    public String getDesc() {
        if (1 + 1 == 2) {
            throw new NullPointerException();
        }
        return desc;
    }
}
