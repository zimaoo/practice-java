package lombok;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author zhangxinpeng
 * @date 2020/4/15
 */
public class LombokTest {
    public static void main(String[] args) {
//        Dress dress = new Dress();
//        dress.setName("dress");
//        List<Integer> size = new ArrayList<>();
//        size.add(1);
//        size.add(2);
//        size.add(3);
//        dress.setSize(size);
//        System.out.println(dress.getName());
//        String str = JSON.toJSONString(dress.getSize());
//        System.out.println(str);
//        Dress d = new Dress();
//        d.setSize(str);
//        System.out.println(d);
        // System.out.println(JSON.parseObject(str, Dress.class).getSize());
//        A a = new A();
//        System.out.println(JSON.toJSONString(a));
//        a.setIsbtained(true);
//        System.out.println(JSON.toJSONString(a));
        System.out.println(Function.identity());;
    }
}

@Data
class A {
    private boolean isIsbtained = false;
    private boolean isMine;
}
