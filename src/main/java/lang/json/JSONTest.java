package lang.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxinpeng
 * @date 2020/11/24
 */
public class JSONTest {
    public static void main(String[] args) {
        String str = "{\"603990053\":\"[\\\"9_7\\\"]\"}";
        Map<String, String[]> map = JSON.parseObject(str, new TypeReference<Map<String, String[]>>(){});
        System.out.println(transformFloorParamIntoFormat2(map));
    }

    private static Map<String, int[][]> transformFloorParamIntoFormat2(Map<String, String[]> floorParam) {
        Map<String, int[][]> valueArray = new HashMap<>();
        for (Map.Entry<String, String[]> entry : floorParam.entrySet()) {
            int[][] arr = new int[entry.getValue().length][2];
            for (int i = 0; i < entry.getValue().length; i++) {
                String[] xy = entry.getValue()[i].split("_");
                arr[i][0] = Integer.parseInt(xy[0]);
                arr[i][1] = Integer.parseInt(xy[1]);
            }
            valueArray.put(entry.getKey(), arr);
        }
        return valueArray;
    }
}
