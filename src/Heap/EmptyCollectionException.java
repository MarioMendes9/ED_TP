
package Heap;

/**
 * Exceçao caso a coleçao esteja vazia
 * 
 */
public class EmptyCollectionException extends Exception {

    /**
     * Construtor para esta execeçao 
     * @param message que é atribuida 
     */
    public EmptyCollectionException(String message) {
        super(message);
    }
    
}
