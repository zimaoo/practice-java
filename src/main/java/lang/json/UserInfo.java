package lang.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 * @author zhangxinpeng
 * @date 2020/11/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
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
