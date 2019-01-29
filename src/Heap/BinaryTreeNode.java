package Heap;

/**
 * Classe que representa um de uma arvore
 *
 * @param <T> tipo generico de dados
 */
public class BinaryTreeNode<T> {

    /**
     * Valor do nó
     */
    protected T element;

    /**
     * Proximo elemento left
     */
    protected BinaryTreeNode<T> left,

    /**
     * proximo elemento right
     */
    right;

    /**
     * Creates a new tree node with the specified data.
     *
     * @param obj the element that will become a part of the new tree node
     */
    public BinaryTreeNode(T obj) {
        element = obj;
        left = null;
        right = null;
    }

    /**
     * Método responsavel por defenir o left do no
     *
     * @param left no left
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Método responsavel por defenir o right do no
     *
     * @param right no right
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     * Returns the number of non-null children of this node. This method may be
     * able to be written more efficiently.
     *
     * @return the integer number of non-null children of this node
     */
    public int numChildren() {
        int children = 0;
        if (left != null) {
            children = 1 + left.numChildren();
        }
        if (right != null) {
            children = children + 1 + right.numChildren();
        }
        return children;
    }
}
