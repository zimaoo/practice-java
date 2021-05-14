package lang.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2021/5/8
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= 30; i++) {
            l.add(i);
        }
        System.out.println(l.stream().skip(2).findFirst().get());
    }
}
