package SocialGraph;

/**
 * Excepçao caso o elemento nao exista
 * 
 */
public class ElementNotFoundException extends Exception {

    public ElementNotFoundException() {
        super("Utilizador nao existe");
    }
    
}
