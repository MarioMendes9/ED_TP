package Heap;

/**
 * Classe que representa um double linked unordered list
 *
 * @param <T> tipo generido de dados
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    /**
     * Construtor para a classe
     */
    public DoubleLinkedUnorderedList() {
        super();
    }

    /**
     * Método responsavel por adicionar o elemento no inicio do coleçao
     *
     * @param element a adicionar
     */
    @Override
    public void addToFront(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (head == null) {
            head = newNode;
            tail = head;
            head.setNoAnterior(null);
            head.setNoSeguinte(null);
            this.count++;
        } else {
            newNode.setNoSeguinte(head);
            head.setNoAnterior(newNode);
            head = newNode;
            this.count++;
        }
    }

    /**
     * Método responsavel por adicionar o elemento no fim do coleçao
     *
     * @param element a adicionar
     */
    @Override
    public void addToRear(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (head == null) {
            head = newNode;
            tail = head;
            head.setNoAnterior(null);
            head.setNoSeguinte(null);
            this.count++;
        } else {

            tail.setNoSeguinte(newNode);
            newNode.setNoAnterior(tail);
            tail = newNode;
            this.count++;
        }
    }

    /**
     * Método responsavel por adicionar um elemento num lugar especifico da
     * coleçao
     *
     * @param element a adicionar
     * @param target a adicionar depois deste elemento
     */

    @Override
    public void addAfter(T element, T target) {
        if (element instanceof Comparable) {
            LinearNode<T> curr = head;
            Comparable<T> targett = (Comparable<T>) target;

            LinearNode<T> newNode = new LinearNode<>(element);

            try {
                if (!contains(target)) {
                    return;
                }
            } catch (EmptyCollectionException ex) {
                System.out.println(ex.getMessage());
            }

            //maior que o ultimo
            if (targett.compareTo(tail.getValue()) == 0) {
                tail.setNoSeguinte(newNode);
                newNode.setNoAnterior(tail);
                tail = newNode;
                this.count++;
                return;
            }

            //meter no meio
            while (curr.getNoSeguinte() != null && targett.compareTo(curr.getValue()) != 0) {
                curr = curr.getNoSeguinte();
            }

            newNode.setNoAnterior(curr);
            newNode.setNoSeguinte(curr.getNoSeguinte());
            curr.getNoSeguinte().setNoAnterior(newNode);
            curr.setNoSeguinte(newNode);

            this.count++;

        }
    }
}
