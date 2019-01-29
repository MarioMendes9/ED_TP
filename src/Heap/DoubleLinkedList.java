package Heap;

import java.util.Iterator;

/**
 * Classe que representa uma double linked list com dois nos sentinela
 *
 * @param <T> valor generico de dados
 */
public class DoubleLinkedList<T> implements ListADT<T> {

    /**
     * No inicial
     */
    protected LinearNode<T> head;

    /**
     * No final
     */
    protected LinearNode<T> tail;

    /**
     * Numero de nos
     */
    protected int count;

    /**
     * Numero de operaçoes 
     */
    protected int n_oper;

    /**
     * Construtor para a doubleLinkedList
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
        this.n_oper = 0;
    }

    /**
     * Método que remove o primeiro elemento da coleçao
     *
     * @return primeiro elemento da coleçao
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Double linked list vazia");
        }
        T first = head.getValue();
        head = head.getNoSeguinte();
        head.setNoAnterior(null);
        count--;
        n_oper++;
        return first;
    }

    /**
     * Método que remove o ultimo elemento da coleçao
     *
     * @return ultimo elemento da coleçao
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Double linked list vazia");
        }

        T last = tail.getValue();
        tail = tail.getNoAnterior();
        tail.setNoSeguinte(null);
        count--;
        n_oper++;
        return last;
    }

    /**
     * Método para remove um determinado elemento da coleçao
     *
     * @param element a remover
     * @return o elemento removido
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Double linked list vazia");
        }

        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current != null && !found) {
            if (element.equals(current.getValue())) {
                found = true;
            } else {
                previous = current;
                current = current.getNoSeguinte();
            }
        }

        if (!found) {
            throw new ElementNotFoundException("Elemento na encontrado");
        }

        if (size() == 1) {
            head = tail = null;
        } else if (current.equals(head)) {
            head = current.getNoSeguinte();
        } else if (current.equals(tail)) {
            tail = previous;
            tail.setNoSeguinte(null);
        } else {
            previous.setNoSeguinte(current.getNoSeguinte());
        }

        count--;
        n_oper++;
        return current.getValue();

    }

    /**
     * Método que remove o primeiro elemento da coleçao
     *
     * @return primeiro elemento da coleçao
     */
    @Override
    public T first() {
        return this.head.getValue();
    }

    /**
     * Método que remove o ultimo elemento da coleçao
     *
     * @return ultimo elemento da coleçao
     */
    @Override
    public T last() {
        return this.tail.getValue();
    }

    /**
     * Método que verifica se determinado elemento existe na coleçao
     *
     * @param target elemento que se procura
     * @return True caso exista, false caso nao exista
     * @throws Heap.EmptyCollectionException caso a coleçao esteja vazia
     */
    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Double linked list vazia");
        }

        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current != null && !found) {
            if (target.equals(current.getValue())) {
                return true;
            } else {
                previous = current;
                current = current.getNoSeguinte();
            }
        }

        return false;

    }

    /**
     * Método responsavel por verificar se a coleçao esta vazia ou nao
     *
     * @return True caso esteja, false caso contrario
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Método responsavel por retornar o tamanho da coleçao
     *
     * @return tamanho da coleçao
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Método que retorna um iterador para a coleçao
     *
     * @return iterador para a coleçao
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedIterator<>(this.n_oper);
    }

    private class DoubleLinkedIterator<T> implements Iterator<T> {

        private LinearNode<T> actual;
        private int expected;
        private boolean can;

        /**
         * Construtor da classe
         *
         * @param expected numero de elementos
         */
        public DoubleLinkedIterator(int expected) {
            this.actual = (LinearNode<T>) head;
            this.expected = expected;
            can = false;
        }

        /**
         * Método que procura se existe proximo
         *
         * @return True caso exista, False caso contrario
         */
        @Override
        public boolean hasNext() {

            return (actual != null);
        }

        /**
         * Método que retornar o proximo elemento na coleçao
         *
         * @return proximo elemento na coleçao
         */
        @Override
        public T next() {
            if (expected == n_oper) {
                can = true;
            }
            if (can == true) {
                LinearNode<T> temp = actual;
                this.actual = this.actual.getNoSeguinte();
                return temp.getValue();
            }
            return null;
        }

    }
}
