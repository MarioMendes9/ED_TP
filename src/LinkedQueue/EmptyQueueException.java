package LinkedQueue;

/**
 * Exceçao se a coleçao estiver vazia
 */
public class EmptyQueueException extends Exception {

    public EmptyQueueException() {
        super("Coleçao vazia");
    }

}
