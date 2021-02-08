package lombok;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2020/4/15
 */
@Data
public class Dress {
    private String name;
    private List<Integer> size;

    public void setSize(List<Integer> size) {
        this.size = size;
    }

    public void setSize(String str) {
        this.size = JSON.parseObject(str, new TypeReference<List<Integer>>(){});
    }
}
