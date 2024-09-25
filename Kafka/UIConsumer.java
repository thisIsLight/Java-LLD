package PubSub;

public class UIConsumer implements IConsumer {

    private String name;

    public UIConsumer(String name) {
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
