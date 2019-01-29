package Graphs;

/**
 * Execeçao para o caso de nao existir um caminho entre dois elementos
 * 
 */
public class NonAvailablePath extends Exception{

    /**
     * Construtor para esta execeçao 
     */
    public NonAvailablePath() {
        super("Nao existe um caminho entre estes dois elementos");
    }
    
}
