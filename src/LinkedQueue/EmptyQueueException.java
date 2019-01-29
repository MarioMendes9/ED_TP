package LinkedQueue;

/**
 * Exceçao se a coleçao estiver vazia
 */
public class EmptyQueueException extends Exception {

    /**
     * Construtor para esta execeçao 
     */
    public EmptyQueueException() {
        super("Coleçao vazia");
    }

}
