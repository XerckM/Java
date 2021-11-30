public class QueueOverflowException extends QueueException {
    public QueueOverflowException() {
        super("Queue is full");
    }
    public QueueOverflowException(String msg) {
        super(msg);
    }
}
