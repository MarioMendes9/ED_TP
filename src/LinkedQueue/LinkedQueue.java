package LinkedQueue;

/**
 *
 * Queue com listas ligadas
 *
 * @param <T> tipo generico
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> front;
    private int size;
    private LinearNode<T> rear;

    /**
     * Construtor para a Queue
     */
    public LinkedQueue() {
        this.front = null;
        this.size = 0;
        this.rear = null;
    }

    /**
     * Adiciona um elemento a coleçao
     *
     * @param element a adicionar
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> NewNode = new LinearNode<>(element);
        if (isEmpty()) {
            this.front = NewNode;
            this.rear = NewNode;

        } else {
            this.rear.setNext(NewNode);
            this.rear = NewNode;

        }
        size++;
    }

    /**
     * Remove um elemento da coleçao
     *
     * @return elemento removido
     * @throws LinkedQueue.EmptyCollectionException caso a coleçao esteja vazia
     */
    @Override
    public T dequeue() throws EmptyQueueException {
        T valor;
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            valor = this.front.getElement();
            this.front = this.front.getNext();
            size--;
        }
        if (isEmpty()) {
            rear = null;
        }

        return valor;
    }

    /**
     * Método responsavel por retornar o primeiro elemento
     *
     * @return primeiro elemento
     * @throws LinkedQueue.EmptyCollectionException se a coleçao estiver vazia
     */
    @Override
    public T first() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return this.front.getElement();
    }

    /**
     * Método responsavel por retornar o primeiro elemento
     *
     * @return True se estiver vazia, False caso nao esteja
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
        return this.size;
    }

    /**
     * Método que cria uma string a representar a queue
     *
     * @return representaçao da queue em string
     */
    @Override
    public String toString() {
        String s = "Queue:";
        LinearNode<T> c = this.front;
        for (int i = 0; i < size; i++) {
            s += c.getElement();
            c = c.getNext();

        }

        return s;
    }

}
