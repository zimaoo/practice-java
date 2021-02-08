package lang.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 使用尺子结果
 * @author zhangxinpeng
 * @date 2020/11/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseRulerResult {
    /**
     * 尺子数量
     */
    private int rulerNum;

    /**
     * 一次尺子持续时长，单位为秒
     */
    private int duration;
}
