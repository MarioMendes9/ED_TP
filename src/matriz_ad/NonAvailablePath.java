
package matriz_ad;

/**
 *~Execeçao para o caso de nao existir um caminho entre dois elementos
 * 
 */
public class NonAvailablePath extends Exception{

    public NonAvailablePath() {
        super("Nao existe um caminho entre estes dois elementos");
    }
    
}
