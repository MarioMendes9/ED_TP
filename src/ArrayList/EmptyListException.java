package ArrayList;

/**
 * Exceçao caso a coleçao esteja vazia
 * 
 */
public class EmptyListException extends Exception {

    /**
     * Construtor para esta execeçao 
     */
    public EmptyListException() {
        super("Coleçao vazia");
    }
    
}
