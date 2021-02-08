package pubsub;

/**
 * @author zhangxinpeng
 * @date 2019-11-12
 */
public class Test {
    public static void main(String[] args) {
        Broker broker = new Broker();

        broker.registerSubscriber("1", new ASub());
        broker.registerSubscriber("1", new BSub());
        broker.registerSubscriber("2", new ASub());
        broker.registerSubscriber("3", new BSub());

        Msg msg = new Msg();
        msg.setContent("Hello world");

        broker.publish("1", msg);
        broker.publish("2", msg);
        broker.publish("3", msg);
    }
}
