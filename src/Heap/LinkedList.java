/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class LinkedList<T> implements ListADT<T> {

    protected Node<T> head, tail;
    protected int count, modcount;

    public LinkedList() {
        tail = head = null;
        count = modcount = 0;
    }

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
            if(count==1){
                a=b.getElement();
                b=null;
                count--;
            }else
            for (int i = 0; i < count-1; i++) {
                if (b.getNext().getElement().equals(element)) {
                    a = b.getNext().getElement();
                    b.setNext(b.getNext().getNext());
                    count--;
                    modcount++;
                }
                b=b.getNext();
            }
        }
        return a;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("vazia");
        }
        return head.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("vazia");
        }
        return tail.getElement();
    }

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

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return count;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<T>(head, count, modcount);
    }

    private class LinkedIterator<T> implements Iterator<T> {

        private Node<T> current;
        int count, expectedmodcount;

        public LinkedIterator(Node<T> n, int count, int modcount) {
            current = n;
            this.count = count;
            this.expectedmodcount = modcount;
        }

        @Override
        public boolean hasNext() {
            if (expectedmodcount != modcount) {
                throw new ConcurrentModificationException("Lista modificada!");
            }
            return (current != null);
        }

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
