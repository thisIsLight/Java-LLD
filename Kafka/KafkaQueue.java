package PubSub;

import java.util.Hashtable;

public class KafkaQueue {
    private Hashtable<String, Topics> topics = new Hashtable<String, Topics>();

    public KafkaQueue() {
    }

    public void CreateTopic(String topicName){
        this.topics.put(topicName, new Topics());
    }

    public void Subscribe(String topicName, IConsumer consumer){
        if(topics.containsKey(topicName)){
            topics.get(topicName).Subscribe(consumer);
        }
    }

    public void UnSubscribe(String topicName, IConsumer consumer){
        if(topics.containsKey(topicName)){
            topics.get(topicName).UnSubscribe(consumer);
        }
    }

    public void Publish(String topicName, String message){
        if(topics.containsKey(topicName)){
            topics.get(topicName).Publish(message);
        }
    }
}
