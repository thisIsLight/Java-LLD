package PubSub;

public class LogConsumer implements IConsumer {
    private String name;

    public LogConsumer(String name) {
        super();
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void consume(String data) {
        System.out.println("Consumer " + name + "consumed the message : " + data);
        // try{
        //     Thread.sleep(10);
        // }
        // catch(InterruptedException e){

        // }
        
    }
}
