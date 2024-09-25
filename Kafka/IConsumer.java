package PubSub;

public interface IConsumer {
    String getName();
    void consume(String data);
}
