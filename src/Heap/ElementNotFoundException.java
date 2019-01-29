package Heap;

/**
 * Execption caso o elemento nao exista na coleçao
 */
public class ElementNotFoundException extends Exception {

    /**
     * Construtor para esta execeçao 
     * @param message que é atribuida 
     */
    public ElementNotFoundException(String message) {
        super(message);
    }

}
