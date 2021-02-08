package pubsub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxinpeng
 * @date 2019-11-12
 */
public class Broker {
    private Map<String, List<Subscriber>> topicSubscriberMapping = new HashMap<>();

    public void registerSubscriber(String topicName, Subscriber subscriber) {
        List<Subscriber> subscriberList = topicSubscriberMapping.getOrDefault(topicName, new ArrayList<>());
        subscriberList.add(subscriber);
        topicSubscriberMapping.put(topicName, subscriberList);
    }

    public void publish(String topicName, Msg msg) {
        for (Subscriber subscriber : topicSubscriberMapping.get(topicName)) {
            subscriber.process(topicName, msg);
        }
    }
}
