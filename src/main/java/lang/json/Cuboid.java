package lang.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangxinpeng
 * @date 2020/11/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuboid {
    /**
     * 长方体宽
     */
    private int width;

    /**
     * 与上一长方体右边的距离
     */
    private int distance;

    /**
     * 移动范围，相对distance而言。
     */
    private int movingRange = 0;

    /**
     * 移动速度
     */
    private int speed = 0;

    public Cuboid(int width, int distance) {
        this.width = width;
        this.distance = distance;
    }
}
