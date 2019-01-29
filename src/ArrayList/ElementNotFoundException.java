package ArrayList;

/**
 * Excepçao caso o elemento nao exista
 * 
 */
public class ElementNotFoundException extends Exception {

    /**
     * Constutor para esta exceçao 
     */
    public ElementNotFoundException() {
        super("Elemento nao existe");
    }
    
}
