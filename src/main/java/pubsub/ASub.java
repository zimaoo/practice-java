package pubsub;

/**
 * @author zhangxinpeng
 * @date 2019-11-12
 */
public class ASub implements Subscriber{
    private String name = "ASub";

    @Override
    public void process(String topicName, Msg msg) {
        System.out.println(String.format("%s process %s %s", name, topicName, msg.getContent()));
    }
}
