package PubSub;

public class ConsumerNotFoundException extends Exception{
    public ConsumerNotFoundException(String message) {
        super(message);
    }
}
