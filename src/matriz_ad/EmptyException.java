package matriz_ad;

/**
 * Exceçao no caso de encontrar uma coleçao vazia
 *
 */
public class EmptyException extends Exception {

    public EmptyException() {
        super("Coleçao em questao esta vazia");
    }
}