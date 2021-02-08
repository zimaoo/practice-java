package lang;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
//        Map<String, String> ss = new HashMap<>();
//        ss.put("1", "1");
//        ss.put("2", "2");
//
//        for (Map.Entry entry : ss.entrySet()) {
//            System.out.println(entry.getKey().getClass().getSimpleName() + ":" + entry.getValue().getClass().getSimpleName());
//        }
//
//        Map<String, Integer> si = ss.entrySet().parallelStream().collect(Collectors.toMap(Map.Entry::getKey, entry -> Integer.valueOf(entry.getValue())));
//        for (Map.Entry entry : si.entrySet()) {
//            System.out.println(entry.getKey().getClass().getSimpleName() + ":" + entry.getValue().getClass().getSimpleName());
//        }
        Object a = 23;
        System.out.println((int)a);

    }
}
