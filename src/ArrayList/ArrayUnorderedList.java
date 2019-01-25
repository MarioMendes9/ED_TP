package ArrayList;

/**
 * Lista desordenada implmentada com um array
 *
 * @param <T> Tipo generico
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    /**
     * Construtor com um determinado tamanho
     *
     * @param tam
     */
    public ArrayUnorderedList(int tam) {
        super(tam);
    }

    /**
     * Construtor para o default tamanho
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     * Método responsavel por adicionar um elemento a cabeça da coleçao
     *
     * @param element a adicionar
     */
    @Override
    public void addToFront(T element) {
        if (isEmpty()) {
            this.array[0] = element;
        } else {

            if (this.rear == this.array.length) {
                this.creatArray();
            }
            for (int i = rear; i > 0; i--) {
                this.array[i] = this.array[i - 1];
            }
        }
        this.array[0] = element;
        this.rear++;
    }

    /**
     * Método responsavel por adicionar um elemento a cauda da coleçao
     *
     * @param element a adicionar
     */
    @Override
    public void addToRear(T element) {
        if (isEmpty()) {
            this.array[0] = element;
        } else {

            if (this.rear == this.array.length) {
                this.creatArray();

            }
        }
        this.array[this.rear] = element;
        this.rear++;

    }

    /**
     * Método responsavel por adicionar um elemento depois de outro
     *
     * @param element a adicionar
     * @param target a adicionar depois deste
     */
    @Override
    public void addAfter(T element, T target) {
        if (this.contains(target)) {
            int i = 0;
            while (!this.array[i].equals(target)) {
                i++;
            }
            for (int j = rear; j > i + 1; j--) {
                this.array[j] = this.array[j - 1];
            }

            this.array[i + 1] = element;
            this.rear++;
        }

    }

    /**
     * Método responsavel por duplicar o tamanho do array
     */
    private void creatArray() {
        T[] array2 = (T[]) (new Object[this.array.length * 2]);

        for (int i = 0; i < this.rear; i++) {
            array2[i] = this.array[i];
        }
        this.array = array2;
    }

}
