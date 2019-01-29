package Graphs;

/**
 * Exceçao no caso de encontrar uma coleçao vazia
 *
 */
public class EmptyException extends Exception {

    /**
     * Construtor para esta execeçao 
     */
    public EmptyException() {
        super("Coleçao em questao esta vazia");
    }
}
