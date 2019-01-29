
package Heap;

/**
 *  Classe que representa um nó
 * 
 * @param <T> tipo generico de dados
 */
public class Node<T> {
    private Node<T> next;
    private T element;
/**
 * Construtor para o nó
 * 
 * @param element valor do nó
 */
    public Node(T element) {
        this.element = element;
        this.next=null;
    } 
    /**
     * Método para retornar o proximo elemento
     * @return o proximo elemento
     */

    public Node<T> getNext() {
        return next;
    }

    /**
     * Método para definir o proximo elemento
     * @param next proximo elemento
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Método para retornar o valor do elemento
     * @return valor do elemento 
     */
    public T getElement() {
        return element;
    }

    /**
     * Método para definir o valor do elemento
     * @param element novo valor do elemento 
     */
    public void setElement(T element) {
        this.element = element;
    }
    
    
}
