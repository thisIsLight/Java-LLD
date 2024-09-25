package PubSub;

public class ConsumerWorker implements Runnable {

    private IConsumer currentConsumer;
    public Topics currentTopic;
    private int offSet = 1;
    private boolean keepAlive = true;


    

    public ConsumerWorker(IConsumer consumer, Topics topic) {
        super();
        currentConsumer = consumer;
        currentTopic = topic;
    }

    @Override
    public void run() {
        synchronized(currentTopic){
            while(keepAlive){
                while(currentTopic.getQueue().size() <= offSet){
                    try{
                        currentTopic.wait();
                    }
                    catch(Exception e){

                    }
                }

                var messageToConsume = currentTopic.getQueue().get(offSet);
                currentConsumer.consume(messageToConsume);
                offSet++;
            }
        }
    }
    
}
