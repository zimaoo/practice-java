package lang.enumm;

import lombok.Data;

/**
 * @author zhangxinpeng
 * @date 2021/3/2
 */
@Data
public class Test {
    public static void main(String[] args) {
        // System.out.println(SceneType.getById((byte) 0));
        // System.out.println(SceneType.getById((byte) 0));
//        Scene scene = new Scene();
//        scene.setName("abc");
//        scene.setSceneType(SceneType.NORMAL_ROOM);
//        System.out.println(JSON.toJSONString(scene));
        System.out.println(Test.class.getAnnotation(Data.class));
    }
}
