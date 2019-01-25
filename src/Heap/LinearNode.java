package Heap;

import java.util.Objects;

/**
 * Implementaçao de um LinearNode
 */
public class LinearNode<T> {

    private T value;
    private LinearNode<T> NoSeguinte;
    private LinearNode<T> NoAnterior;

    /**
     * Construtor para o linearNode
     *
     * @param value valor do no
     */
    public LinearNode(T value) {
        this.value = value;
        this.NoSeguinte = null;
        this.NoAnterior = null;
    }

    /**
     * Construtor para o linearNode sem valor
     */
    public LinearNode() {
        this.value = null;
        this.NoSeguinte = null;
        this.NoAnterior = null;
    }

    /**
     * Método responsavel por retornar o valor do nó
     *
     * @return valor do nó
     */
    public T getValue() {
        return value;
    }

    /**
     * Método responsavel por retornar o nó seguinte
     *
     * @return nó seguinte
     */
    public LinearNode<T> getNoSeguinte() {
        return NoSeguinte;
    }

    /**
     * Método responsavel por retornar o nó anterior
     *
     * @return nó anterior
     */
    public LinearNode<T> getNoAnterior() {
        return NoAnterior;
    }

    /**
     * Método responsavel por atribuir um valor ao nó
     *
     * @param value do nó
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Método responsavel por atribui o no seguinte
     *
     * @param NoSeguinte , proximo nó
     */
    public void setNoSeguinte(LinearNode<T> NoSeguinte) {
        this.NoSeguinte = NoSeguinte;
    }

    /**
     * Método responsavel por atribui o no anterior
     *
     * @param NoAnterior , nó anterior
     */
    public void setNoAnterior(LinearNode<T> NoAnterior) {
        this.NoAnterior = NoAnterior;
    }

    /**
     * Método responsavel por retornar uma string do nó
     *
     * @return string que reprenta o nó
     */
    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LinearNode<?> other = (LinearNode<?>) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

}
