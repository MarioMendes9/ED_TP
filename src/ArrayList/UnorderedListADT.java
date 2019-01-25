package ArrayList;

/**
 *
 * Interface para implementar uma lista desordenada
 *
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListADT<T> {

    /**
     * Metodo responsavel por adicionar um elemento no inicio da coleçao
     *
     * @param element a adicionar
     */
    public void addToFront(T element);

    /**
     * Metodo responsavel por adicionar um elemento no fim da coleçao
     *
     * @param element a adicionar
     */
    public void addToRear(T element);

    /**
     *
     * Metodo responsavel por adicionar um elemento no inicio da coleçao
     *
     * @param element a adicionar
     * @param target adicionar depois deste elemento
     */
    public void addAfter(T element, T target);

}
