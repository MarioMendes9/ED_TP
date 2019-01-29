package Heap;

import LinkedQueue.*;
import java.util.Iterator;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 *
 * @param <T> tipo generico de dados
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    /**
     * Numero de nós
     */
    protected int count;

    /**
     * No inicial
     */
    protected BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() {
        count = 0;
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the new binary
     * tree
     */
    public LinkedBinaryTree(T element) {
        count = 1;
        root = new BinaryTreeNode<>(element);

    }

    /**
     * Método responsavel por retorn o root da arvore
     *
     * @return root da arvore
     */
    @Override
    public T getRoot() {
        return this.root.element;
    }

    /**
     * Método responsavel para dizer se a arvore esta vazia ou nao
     *
     * @return True caso arvore esteja vazia, False caso contrario
     */
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Método responsavel por retornar o numero de nos na arvore
     *
     * @return numero de nos na arvore
     */
    @Override
    public int size() {
        return numberNode(root);
    }

    /**
     * Método que faz o calculo do numero de nos na arvore
     *
     * @param b no em determinado momento
     * @return numero de nos
     */
    private int numberNode(BinaryTreeNode<T> b) {
        if (b == null) {
            return 0;
        }
        return 1 + numberNode(b.left) + numberNode(b.right);
    }

    /**
     * Método responsavel por determinar se um elemento existe na arvore
     *
     * @param targetElement elemento a procurar
     * @return True caso existe, falso caso contrario
     */
    @Override
    public boolean contains(T targetElement) {
        try {
            this.find(targetElement);
            return true;

        } catch (ElementNotFoundException e) {
            return false;
        }
    }

    /**
     * Método responsavel por procurar um determinado elemento
     *
     * @param targetElement que se procura
     * @return no que se procura
     * @throws ElementNotFoundException caso nao encontre o no
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);

        if (current == null) {
            throw new ElementNotFoundException("binary tree");
        }

        return (current.element);
    }

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findAgain(T targetElement,
            BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }

        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> a = new DoubleLinkedUnorderedList<>();
        inorder(root, a);

        return a.iterator();
    }

    /**
     * Método responsavel por percorrer a arvore inorder
     *
     * @param node inicial
     * @param a lista nao ordenada
     */
    protected void inorder(BinaryTreeNode<T> node, UnorderedListADT<T> a) {
        if (node != null) {
            inorder(node.left, a);
            a.addToRear(node.element);
            inorder(node.right, a);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> a = new DoubleLinkedUnorderedList<>();
        preOrder(root, a);

        return a.iterator();
    }

    /**
     * Método responsavel por percorrer a arvore preOrder
     *
     * @param node inicial
     * @param a lista nao ordenada
     */
    protected void preOrder(BinaryTreeNode<T> node, UnorderedListADT<T> a) {
        if (node != null) {
            a.addToRear(node.element);
            preOrder(node.left, a);
            preOrder(node.right, a);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> a = new DoubleLinkedUnorderedList<>();
        postOrder(root, a);

        return a.iterator();
    }

    /**
     * Método responsavel por percorrer a arvore postOrder
     *
     * @param node inicial
     * @param a lista nao ordenada
     */
    protected void postOrder(BinaryTreeNode<T> node, UnorderedListADT<T> a) {
        if (node != null) {
            postOrder(node.left, a);
            postOrder(node.right, a);
            a.addToRear(node.element);
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {

        UnorderedListADT<T> a = new DoubleLinkedUnorderedList<>();
        QueueADT<BinaryTreeNode<T>> q = new LinkedQueue<>();
        levelOrder(root, a, q);

        return a.iterator();
    }

    /**
     * Método responsavel por percorrer a arvore levelOrder
     *
     * @param node inicial
     * @param a lista nao ordenada
     * @param q queue auxiliar
     */
    protected void levelOrder(BinaryTreeNode<T> node, UnorderedListADT<T> a, QueueADT<BinaryTreeNode<T>> q) {

        q.enqueue(node);
        while (!q.isEmpty()) {

            BinaryTreeNode<T> temp = null;
            try {
                temp = q.dequeue();
            } catch (EmptyQueueException ex) {
                System.out.println(ex.getMessage());
            }
            if (temp != null) {
                a.addToRear(temp.element);
                if (node.left != null) {
                    q.enqueue(temp.left);
                }
                if (node.right != null) {
                    q.enqueue(temp.right);
                }

            }
        }
    }

}
