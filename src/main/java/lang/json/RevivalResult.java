package lang.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 复活结果
 * @author zhangxinpeng
 * @date 2020/11/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevivalResult {
    /**
     * 剩余复活次数
     */
    private int remainedRevivalTimes;

    /**
     * 是否赠送了尺子
     */
    private boolean givenRuler = false;

    /**
     * 目前尺子数量
     */
    private int rulerNum;

    /**
     * 下次复活货币类型
     */
    private int nextRevivalCurrencyType;

    /**
     * 下次复活费用
     */
    private int nextRevivalCost;
}
