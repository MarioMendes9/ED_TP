/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_ad;

import LinkedStack.LinkedStack;
import LinkedQueue.LinkedQueue;
import ArrayList.ArrayUnorderedList;
import LinkedQueue.EmptyQueueException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
/**
 * Graph represents an adjacency matrix implementation of a graph.
 *
 * @param <T>
 */
public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 5;
    protected int numVertices; // number of vertices in the graph
    protected boolean[][] adjMatrix; // adjacency matrix
    protected T[] vertices; // values of vertices

    /**
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    private void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    public int getIndex(T vertex) {
        int n = -1;
        for (int i = 0; i < vertices.length; i++) {
            if (this.vertices[i] == (vertex)) {
                n = i;
            }
        }
        return n;

    }

    /**
     * Adds a vertex to the graph, expanding the capacity of the graph if
     * necessary. It also associates an object with the vertex.
     *
     * @param vertex the vertex to add to the graph
     */
    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;

    }

    @Override
    public void removeVertex(T vertex) {
        int k = this.getIndex(vertex);

        this.vertices[k] = null;
        for (int i = k; i < this.numVertices - 1; i++) {
            this.vertices[i] = this.vertices[i + 1];
        }
        /**
         * Remove o vertice da matriz
         */

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = k; j < this.numVertices - 1; j++) {
                this.adjMatrix[i][j] = this.adjMatrix[i][j + 1];

            }
        }

        for (int j = 0; j < this.numVertices; j++) {
            for (int i = k; i < this.numVertices - 1; i++) {
                this.adjMatrix[i][j] = this.adjMatrix[i + 1][j];

            }
        }
        /**
         * Actualiza as ultimas posiçoes
         */

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = k; j < this.numVertices; j++) {
                this.adjMatrix[i][j] = false;
            }
        }

        for (int i = k; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.adjMatrix[i][j] = false;
            }
        }

        this.numVertices--;

    }

    public void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    public Iterator<T> iteratorBFS(T startVertex) {
        return iteratorBFS(getIndex(startVertex));
    }

    /**
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given index.
     *
     * @param startIndex the index to begin the search from
     * @return an iterator that performs a breadth first traversal
     */
    @Override
    public Iterator<T> iteratorBFS(int startIndex) {
        Integer x = null;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;
        while (!traversalQueue.isEmpty()) {
            try {
                x = traversalQueue.dequeue();
            } catch (EmptyQueueException ex) {
                System.out.println(ex.getMessage());
            }
            resultList.addToRear(vertices[x.intValue()]);
            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    public Iterator<T> iteratorDFS(T startVertex) {
        return iteratorDFS(getIndex(startVertex));
    }

    /**
     * Returns an iterator that performs a depth first search traversal starting
     * at the given index.
     *
     * @param startIndex the index to begin the search traversal from
     * @return an iterator that performs a depth first traversal
     */
    @Override
    public Iterator<T> iteratorDFS(int startIndex) {
        Integer x = null;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;
        while (!traversalStack.isEmpty()) {
            try {
                x = traversalStack.peek();
            } catch (EmptyQueueException ex) {
                System.out.println(ex.getMessage());
            }
            found = false;
            /**
             * Find a vertex adjacent to x that has not been visited and push it
             * on the stack
             */
            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                try {
                    traversalStack.pop();
                } catch (EmptyQueueException ex) {
                    System.out.println(ex.getMessage());
                       
                }
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public boolean isEmpty() {
        return (numVertices == 0);
    }

    @Override
    public boolean isConnected() {
        if (isEmpty()) {
            return false;
        }

        Iterator<T> it = iteratorBFS(0);
        int count = 0;

        while (it.hasNext()) {
            it.next();
            count++;
        }
        return (count == numVertices);
    }

    @Override
    public int size() {
        return this.numVertices;
    }

    protected void expandCapacity() {
        boolean[][] adjMatrix2 = new boolean[this.numVertices * 2][this.numVertices * 2];

        T[] vertices2 = (T[]) (new Object[this.numVertices * 2]);
        /**
         * Copia os vertices no vetor de vertices
         */
        for (int i = 0; i < this.numVertices; i++) {
            vertices2[i] = this.vertices[i];
        }
        this.vertices = vertices2;

        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                adjMatrix2[i][j] = adjMatrix[i][j];
            }
        }

    }

    public boolean indexIsValid(int index) {
        return (index < this.vertices.length && index >= 0);
    }

    public void printmatriz() {
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }

    }

}