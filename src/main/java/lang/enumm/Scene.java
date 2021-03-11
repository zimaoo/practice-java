package lang.enumm;

import lombok.Data;

/**
 * @author zhangxinpeng
 * @date 2021/3/10
 */
@Data
public class Scene {
    private String name;

    private SceneType sceneType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SceneType getSceneType() {
        return sceneType;
    }

    public void setSceneType(SceneType sceneType) {
        this.sceneType = sceneType;
    }
}
