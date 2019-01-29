package SocialGraph;

/**
 * Excepçao caso o elemento nao exista
 * 
 */
public class ElementNotFoundException extends Exception {

    /**
     * Construtor para esta exceçao 
     */
    public ElementNotFoundException() {
        super("Utilizador nao existe");
    }
    
}
