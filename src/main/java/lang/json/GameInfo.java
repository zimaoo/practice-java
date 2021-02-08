package lang.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangxinpeng
 * @date 2020/11/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameInfo {
    /**
     * 系统信息
     */
    private SystemInfo systemInfo;

    /**
     * 用户信息
     */
    private UserInfo userInfo;

    /**
     * 高台信息
     */
    private List<Cuboid> cuboidInfo;

    /**
     * 系统信息
     * @author zhangxinpeng
     * @date 2020/11/13
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SystemInfo {
        /**
         * 按压时长与棍子长度的系数
         */
        private float k;

        /**
         * 基础分数
         */
        private int basicScore;

        /**
         * 完美分数
         */
        private int perfectScore;

        /**
         * 失败分数系数
         */
        private int failScoreCoefficient;

        /**
         * 尺子持续时长
         */
        private int rulerDuration;
    }

    /**
     * 用户信息
     * @author zhangxinpeng
     * @date 2020/11/13
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserInfo {
        /**
         * 剩余可复活次
         */
        private int remainedRevivalTimes;

        /**
         * 下次复活所需货币类型
         */
        private int nextRevivalCurrencyType;

        /**
         * 下次复活价格
         */
        private int nextRevivalCost;

        /**
         * 本游戏积分
         */
        private int points;

        /**
         * 尺子数量
         */
        private int rulerNum;
    }

    /**
     * @author zhangxinpeng
     * @date 2020/11/13
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Cuboid {
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
}
