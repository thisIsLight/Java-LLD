/*
 * 
 * Initialize a queue
 * Create topics in the queue
 * 
 * Create Consumers
 * Map consumers to the queue
 * 
 * Publisher can publish messages to the topics using a publish API
 * The consumers can consume the Data as and when it appears.
 * The consumers should work independent of one another and should work in threaded manner
 * Make the system as losely coupled
 * 
 * APIs Needed : 
 * 
 * Create Queue => No params
 * Create Topics => Topic name as params
 * Publish to the queue => Topic name and message (Make this generic)
 * Subscribe to the Topic => Consumer as input
 * UnSUbscribe to the Topic => Consumer as input
 * 
 * 
*/


package PubSub;

public class Kafka{
    public static void main(String args[]) throws InterruptedException{
        
        var queue = new KafkaQueue();

        //Create Topics
        queue.CreateTopic("t1");
        queue.CreateTopic("t2");

        //Create Consumers
        UIConsumer uiCOnsumer = new UIConsumer("UI-CONSUMER");
        LogConsumer loggingConsumer = new LogConsumer("LOG-CONSUMER");

        //Subscribe consumers to topic
        queue.Subscribe("t1", uiCOnsumer);
        queue.Subscribe("t1", loggingConsumer);


        //Produce messages to the queue
        for(var i=0;i<10;i++){
            queue.Publish("t1", "Message from T1 : " + i);
            queue.Publish("t2", "Message from T2 : " + i);
        }  

        for(var i=10;i<15;i++){
            queue.Publish("t1", "Message from T1 : " + i);
            queue.Publish("t2", "Message from T2 : " + i);
        } 
    }
}

