package lang.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 校验结果
 * @author zhangxinpeng
 * @date 2020/11/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckResult {
    /**
     * 是否成功通关
     */
    private boolean succeed;

    /**
     * 回合积分
     */
    private int roundPoints;

    /**
     * 总积分
     */
    private long totalPoints;
}
