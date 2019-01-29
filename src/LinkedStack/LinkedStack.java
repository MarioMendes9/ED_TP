package LinkedStack;

import LinkedQueue.*;

/**
 * Classe que representa uma stack
 *
 * @param <T> tipo generico de dados
 */
public class LinkedStack<T> implements StackADT<T> {

    private LinearNode<T> first;
    private int size;

    /**
     * Construtor da stack
     */
    public LinkedStack() {
        this.first = null;
        this.size = 0;
    }

    /**
     * Método responsavel por adicionar um elemento a coleçao
     *
     * @param element a adicionar
     */
    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (first == null) {
            first = newNode;
            size++;
        } else {
            newNode.setNext(first);
            first = newNode;
            size++;
        }

    }

    /**
     * Método responsavel por remover um elemento da coleçao
     *
     * @return retornar o primeiro elemento 
     */
    @Override
    public T pop() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T element = first.getElement();
        first = first.getNext();
        size--;

        return element;
    }

    /**
     * Método que permite ver primeiro elemento da coleçao sem remover
     *
     * @return o primeiro elemento da coleçao
     */
    @Override
    public T peek() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return first.getElement();
    }

    /**
     * Método responsavel por verificar se a coleçao esta vazia ou nao
     *
     * @return True coleçao vazia, False se nao estiver vazia
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Método responsavel por retornar o tamanho da coleçao
     *
     * @return tamanho da coleçao
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Método responsavel por representar a coleçao em uma string
     *
     * @return string que representa a coleçao
     */
    @Override
    public String toString() {
        String str = "[";
        LinearNode<T> c = first;
        for (int i = 0; i < size; i++) {
            str = str + c.getElement() + " ";
            c = c.getNext();
        }

        return str + "]";

    }

}
