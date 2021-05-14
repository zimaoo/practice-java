package netty.demo.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息
 * @author zhangxinpeng
 * @date 2019-10-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    /**
     * 序列号
     */
    private int id;

    /**
     * 内容
     */
    private String content;
}
