package pubsub;

/**
 * @author zhangxinpeng
 * @date 2019-11-12
 */
public interface Subscriber {
    void process(String topicName, Msg msg);
}
