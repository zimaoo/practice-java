package lang.enumm;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangxinpeng
 * @date 2021/3/2
 */
public class Test {
    public static void main(String[] args) {
        // System.out.println(SceneType.getById((byte) 0));
        // System.out.println(SceneType.getById((byte) 0));
        Scene scene = new Scene();
        scene.setName("abc");
        scene.setSceneType(SceneType.NORMAL_ROOM);
        System.out.println(JSON.toJSONString(scene));
    }
}
