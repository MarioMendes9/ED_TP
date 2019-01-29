package Heap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Classe que representa uma linkedList
 *
 * @param <T> tipo generido de dados
 */
public class LinkedList<T> implements ListADT<T> {

    /**
     * Nó da cabeça
     */
    protected Node<T> head,
            /**
             * Nó da cauda
             */
            tail;

    /**
     * Numero de nos
     */
    protected int count,
            /**
             * Numero de operaçoes
             */
            modcount;

    /**
     * Construtor da classe
     */
    public LinkedList() {
        tail = head = null;
        count = modcount = 0;
    }

    /**
     * Método responsavel por remover o primeiro nó da coleçao
     *
     * @return primeiro elemento
     * @throws EmptyCollectionException caso a coleçao esteja vazia
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        T a;
        if (isEmpty()) {
            throw new EmptyCollectionException("vazia");
        } else {
            a = head.getElement();
            head = head.getNext();
        }
        count--;
        modcount++;
        return a;
    }

    /**
     * Método responsavel por remover o ultimo nó da coleçao
     *
     * @return ultimo no da coleçao
     * @throws EmptyCollectionException caso a coleçao esteja vazia
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        T a = tail.getElement();
        Node<T> b = head;
        if (isEmpty()) {
            throw new EmptyCollectionException("vazia");
        } else {
            for (int i = 2; i < count; i++) {
                b = b.getNext();
            }
            tail = b;
            b.setNext(null);
            count--;
            modcount++;
            return a;
        }
    }

    /**
     * Método responsavel por remover determinado elemento
     *
     * @param element a remover
     * @return elemento removido
     * @throws EmptyCollectionException caso a coleçao esteja vazia
     */
    @Override
    public T remove(T element) throws EmptyCollectionException {
        T a = null;
        Node<T> b = head;
        if (isEmpty()) {
            throw new EmptyCollectionException("vazia");
        } else if (head.getElement().equals(element)) {
            a = removeFirst();
        } else if (tail.getElement().equals(element)) {
            a = removeLast();
        } else {
            if (count == 1) {
                a = b.getElement();
                b = null;
                count--;
            } else {
                for (int i = 0; i < count - 1; i++) {
                    if (b.getNext().getElement().equals(element)) {
                        a = b.getNext().getElement();
                        b.setNext(b.getNext().getNext());
                        count--;
                        modcount++;
                    }
                    b = b.getNext();
                }
            }
        }
        return a;
    }

    /**
     * Método responsavel por retornar o primeiro elemento
     *
     * @return primeiro elemento da coleçao
     * @throws EmptyCollectionException caso a coleçao esteja vazia
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("vazia");
        }
        return head.getElement();
    }

    /**
     * Método responsavel por retornar o ultimo elemento da coleçao
     *
     * @return ultimo elemento da coleçao
     * @throws EmptyCollectionException caso a coleçao esteja vazia
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("vazia");
        }
        return tail.getElement();
    }

    /**
     * Método responsavel por determinar se x elemento existe na coleçao
     *
     * @param object que se procura
     * @return True se existir, false caso contrario
     * @throws EmptyCollectionException caso a coleçao esteja vazia
     */
    @Override
    public boolean contains(T object) throws EmptyCollectionException {
        Node<T> a = head;
        for (int i = 0; i < count; i++) {
            if (a.getElement() == object) {
                return true;
            } else {
                a = a.getNext();
            }
        }
        return false;
    }

    /**
     * Método responsavel por saber se a coleçao esta ou nao vazia
     *
     * @return true caso esteja vazia, false caso contrario
     */
    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método responsavel por retonar o tamanho da coleçao
     *
     * @return tamanho da coleçao
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Método responsavel por retornar a cabeça
     *
     * @return cabeça
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Método responsavel por retornar a cauda
     *
     * @return cauda
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Iterator para esta coleçao
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<T>(head, count, modcount);
    }

    /**
     * Representaçao da coleçao numa string
     *
     * @return string
     */
    @Override
    public String toString() {
        String s = "";
        Node<T> n = head;
        for (int i = 0; i < count; i++) {
            s += n.getElement().toString() + "\n";
            n = n.getNext();
        }
        return s;
    }

    /**
     * Iner classe para o iterator
     *
     * @param <T> tipo generico de dados
     */
    private class LinkedIterator<T> implements Iterator<T> {

        private Node<T> current;
        int count, expectedmodcount;

        /**
         * Construtor para a classe
         *
         * @param n no inicial
         * @param count numero de nos
         * @param modcount numero de operaçoes
         */
        public LinkedIterator(Node<T> n, int count, int modcount) {
            current = n;
            this.count = count;
            this.expectedmodcount = modcount;
        }

        /**
         * Método responsavel por dizer se existe proximo
         *
         * @return true caso existe, false caso contrario
         */

        @Override
        public boolean hasNext() {
            if (expectedmodcount != modcount) {
                throw new ConcurrentModificationException("Lista modificada!");
            }
            return (current != null);
        }

        /**
         * Método responsavel por retornar o proximo nó
         *
         * @return proximo nó
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Não há próximo");
            }
            if (expectedmodcount != modcount) {
                throw new ConcurrentModificationException("Lista modificada!");
            }
            T a = current.getElement();
            current = current.getNext();
            return a;
        }
    }
}
