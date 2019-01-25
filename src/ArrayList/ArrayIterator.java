package ArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterador para os elementos de um array
 *
 */
public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int count;
    private int interate;

    /**
     * Instancia o iterator
     *
     * @param array que irá percorrer
     * @param count numero de elementos
     */
    public ArrayIterator(T[] array, int count) {
        this.array = array;
        this.count = count;
        interate = 0;

    }

    /**
     * Verifica se tem proximo
     *
     * @return True caso existam, false caso nao existam
     */
    @Override
    public boolean hasNext() {
        return (interate < count);
    }

    /**
     * Retorna o proximo ele na iteraçao.
     *
     * @return proxima elemento na iteraçao
     */
    @Override
    public T next() {

        if (count == 0) {
            throw new NoSuchElementException("Sem elementos");
        }
        if (hasNext()) {
            interate++;
            return this.array[interate - 1];
        }
        return null;

    }

}
