package pubsub;

/**
 * @author zhangxinpeng
 * @date 2019-11-12
 */
public class BSub implements Subscriber {
    private String name = "BSub";

    @Override
    public void process(String topicName, Msg msg) {
        System.out.println(String.format("%s process %s %s", name, topicName, msg.getContent()));
    }
}
