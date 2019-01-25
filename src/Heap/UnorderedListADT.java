package Heap;

/**
 * Interface para uma lista nao ordenada
 *
 * @param <T> tipo generico de dados
 */
public interface UnorderedListADT<T> extends ListADT<T> {

    /**
     * Método responsavel por adicionar um elemento na cabeça da lista
     *
     * @param element a adicionar
     */
    public void addToFront(T element);

    /**
     * Método responsavel por adicionar um elemento no fim da lista
     *
     * @param element a adicionar
     */
    public void addToRear(T element);

    /**
     * Método responsavel por adicionar um elemento depois de um elemento
     *
     * @param element a adicionar
     * @param target a adicionar depois deste elemento
     */
    public void addAfter(T element, T target);

}
