package lang.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统信息
 * @author zhangxinpeng
 * @date 2020/11/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemInfo {
    /**
     * 按压时长与棍子长度的系数
     */
    private int k;

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
}
