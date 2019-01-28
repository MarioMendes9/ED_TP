/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T> {

    public LinkedUnorderedList() {
        super();
    }    
    
    @Override
    public void addToFront(T element) {
        Node<T> n=new Node<T>(element);
        n.setNext(head);
        head=n;
        if(count==0){tail=n;}
        count++;
        modcount++;
    }

    @Override
    public void addToRear(T element) {       
        Node<T> n=new Node<T>(element);
        if(tail!=null){
        tail.setNext(n);
        }
        tail=n;
        if(count==0){head=n;}
        count++;
        modcount++;
    }

    @Override
    public void addAfter(T prev, T neew) {
        Node<T> n=new Node<T>(neew);
        Node<T> a=head;
        for(int i=0;i<count;i++){
            if(a.getElement()==prev){
                n.setNext(a.getNext());
                a.setNext(n);
                count++;
                modcount++;
                return;
            }
            a=a.getNext();
        }        
        try {
            throw new Exception("not found");
        } catch (Exception ex) {
            Logger.getLogger(LinkedUnorderedList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
