package Heap;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que representa uma LinkedUnorderedList
 *
 * @param <T> tipo generico de dados
 */
public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T> {

    /**
     * Construtor para esta classe
     */
    public LinkedUnorderedList() {
        super();
    }

    /**
     * Método responsavel por adicionar na cabeça da lista
     *
     * @param element a adicionar
     */
    @Override
    public void addToFront(T element) {
        Node<T> n = new Node<T>(element);
        n.setNext(head);
        head = n;
        if (count == 0) {
            tail = n;
        }
        count++;
        modcount++;
    }

    /**
     * Método responsavel por adicionar no fim da lista
     *
     * @param element a adicionar
     */
    @Override
    public void addToRear(T element) {
        Node<T> n = new Node<T>(element);
        if (tail != null) {
            tail.setNext(n);
        }
        tail = n;
        if (count == 0) {
            head = n;
        }
        count++;
        modcount++;
    }

    /**
     * Método responsavel por adicionar depois de um determinado elemento
     *
     * @param prev adicionar depois deste elemento 
     * @param neew novo no a adicionar
     */
    @Override
    public void addAfter(T prev, T neew) {
        Node<T> n = new Node<T>(neew);
        Node<T> a = head;
        for (int i = 0; i < count; i++) {
            if (a.getElement() == prev) {
                n.setNext(a.getNext());
                a.setNext(n);
                count++;
                modcount++;
                return;
            }
            a = a.getNext();
        }
        try {
            throw new Exception("not found");
        } catch (Exception ex) {
            Logger.getLogger(LinkedUnorderedList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
