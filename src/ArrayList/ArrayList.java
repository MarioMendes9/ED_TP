package ArrayList;



import java.util.Iterator;


/**
 *
 * Lista implementada com um array
 * @param <T> tipo generico
 */
public class ArrayList<T> implements ListADT<T> {

    protected T[] array;
    protected int rear;
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Construtor do ArrayList 
     * @param tam tamanho da coleçao 
     */
    public ArrayList(int tam) {
        this.array = (T[]) (new Object[tam]);
        this.rear = 0;

    }
    /**
     * Construtor que usa um capacidade default para criar a coleçao
     */

    public ArrayList() {
        this.array = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.rear = 0;

    }

    /**
     * Remove o primeiro elemento do array
     * @return o primeiro elemento do array
     */
    
    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T temp = this.array[0];
        this.rear--;
        for (int i = 0; i < this.rear; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.rear] = null;
       
        return temp;
    }
    /**
     * Méotodo para remover o ultimo elemento da coleçao
     * @return O ultimo elemento da coleçao 
     * @throws EmptyListException se a coleçao estiver vazia
     */

    @Override
    public T removeLast() throws EmptyListException{
        if (isEmpty())
         throw new EmptyListException ();
        
        
        T result = this.last();
        this.array[rear - 1] = null;
        this.rear--;
        return result;
    }

    /**
     * Remove um elemento especifico
     * @param element para remover
     * @return elemento removido
     */
    
    @Override
    public T remove(T element) throws ElementNotFoundException{
        if (!this.contains(element)) {
            throw new ElementNotFoundException();    
        }
        int i;
        for (i = 0; i < this.rear; i++) {
            if (element.equals(this.array[i])) {
                break;
            }
        }
        T temp = this.array[i];

        for (; i < this.rear; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[i] = null;
        rear--;
        return temp;
    }

    /**
     * Método responsavel por retornar o primeiro elemento da coleçao
     * @return o primeiro elemento da coleçao
     */
    @Override
    public T first() throws EmptyListException{
         if (isEmpty()){
             
         throw new EmptyListException (); 
         }
        
        return this.array[0];
    }

    /**
     * Método responsavel por retornar o ultimo elemento da coleçao
     * @return ultimo elemento da coleçao 
     */
    @Override
    public T last() throws EmptyListException {
         if (isEmpty())
         throw new EmptyListException (); 

        return this.array[rear - 1];
    }
    
    /**
     * Método responsavel por saber se existe ou nao determinado elemento na coleçao
     * @param target elemento que se pretende saber se esta na coleçao
     * @return TRUE se o elemento exister na coleçao, False caso nao esteja
     */

    @Override
    public boolean contains(T target) {
        for (T indice : this.array) {
            if (target.equals(indice)) {
                return true;
            }
        }
        return false;
    }
/**
 * Método responsavel por retornar se a coleçao esta ou nao vazia
 * @return TRUE=Coleçao vazia, False= Coleçao nao vazia
 */
    @Override
    public boolean isEmpty() {
        return (this.rear == 0);
    }
    
    /**
     * Méotodo responsavel por retornar o numero de elementos na coleçao
     * @return numero de elementos na coleçao 
     */

    @Override
    public int size() {
        return this.rear;
    }

    /**
     * iterator para a coleçao 
     * @return um iterador para a coleçao
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(this.array, this.rear);
    }   

    @Override
    public String toString() {
       String s="";
       for(int i=0;i<this.rear;i++){
           s+=this.array[i].toString()+" ";
       }
       return s;
    }
    
    
}
