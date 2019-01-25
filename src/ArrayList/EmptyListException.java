package ArrayList;

/**
 * Exceçao caso a coleçao esteja vazia
 * 
 */
public class EmptyListException extends Exception {

    public EmptyListException() {
        super("Coleçao vazia");
    }
    
}
