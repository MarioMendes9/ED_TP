package matriz_ad;

import LinkedStack.LinkedStack;
import LinkedQueue.LinkedQueue;
import ArrayList.ArrayUnorderedList;
import LinkedQueue.EmptyQueueException;
import java.util.Iterator;

/**
 * Graph represents an adjacency matrix implementation of a graph.
 *
 * @param <T>
 */
public class Graph<T> implements GraphADT<T> {

    /**
     * Capacidade default
     */
    protected final int DEFAULT_CAPACITY = 5;

    /**
     * Numero de vertices do grafo
     */
    protected int numVertices; // number of vertices in the graph

    /**
     * Matriz de adjacencia
     */
    protected boolean[][] adjMatrix; // adjacency matrix

    /**
     * Conjunto de vertices
     */
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

    /**
     * Método responsavel por retornar o index de um nó
     *
     * @param vertex que se procura
     * @return indice do vertice
     */
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

    /**
     * Método responsavel por remover um vertice da coleçao
     *
     * @param vertex a remover
     */
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

    /**
     * Método responsavel por remover uma arestas
     *
     * @param index1 primeiro vertice
     * @param index2 segundo vertice
     */
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

    /**
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given index.
     *
     * @param startVertex the start vertex
     * @return an iterator that performs a breadth first traversal
     */
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

    /**
     * Returns an iterator that performs a depth first search traversal starting
     * at the given index.
     *
     * @param startVertex vertice inicial
     * @return an iterator that performs a depth first traversal
     */
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
        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
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
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws NonAvailablePath {
        return iteratorShortestPath(getIndex(startVertex), getIndex(targetVertex));
    }

    /**
     * Método responsavel por retornar o caminho mais curto entre dois vertices
     *
     * @param startVertex vertice inicial
     * @param targetVertex vertice final
     * @return iterator que contem o caminho mais curto
     * @throws NonAvailablePath senao existir caminho
     */
    public Iterator iteratorShortestPath(int startVertex, int targetVertex) throws NonAvailablePath {
        Integer x = 0;
        ArrayUnorderedList<T> resultShortList = new ArrayUnorderedList<>();
        //Inicializa o vetor de visitados
        Boolean[] visited = new Boolean[this.numVertices];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;

        }
        int[] cost = new int[this.numVertices];
        //Inicia o vetor de custo 
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.MAX_VALUE;

        }
        //Inicializa o vetor do ultimo vertice
        int lastVertice[] = new int[this.numVertices];

        for (int i = 0; i < lastVertice.length; i++) {
            lastVertice[i] = -1;

        }

        if (!indexIsValid(startVertex)) {
            return resultShortList.iterator();
        }

        //visited[startIndex] = true;
        cost[startVertex] = 0;
        int flag = 0;

        while (flag != numVertices) {
            int costTemp = Integer.MAX_VALUE;
            for (int i = 0; i < cost.length; i++) {
                if (costTemp > cost[i] && visited[i] != true) {
                    x = i;
                    costTemp = cost[i];

                }
            }
            flag++;
            visited[x] = true;

            for (int i = 0; i < numVertices; i++) {
                if ((adjMatrix[x.intValue()][i] == true) && !visited[i]) {
                    if (cost[i] > costTemp + +1) {
                        lastVertice[i] = x;
                        cost[i] = costTemp + +1;
                    }

                }

            }

        }
        int vertex = targetVertex;

        if (lastVertice[vertex] == -1) {
            throw new NonAvailablePath();
        }

        while (vertex != startVertex) {
            resultShortList.addToFront(this.vertices[vertex]);
            vertex = lastVertice[vertex];
        }
        resultShortList.addToFront(this.vertices[startVertex]);
//        System.out.println("Vertice || Visited || Cost || Last");
//        for (int i = 0; i < lastVertice.length; i++) {
//            System.out.println(vertices[i] + "||" + visited[i] + "||" + cost[i] + "||" + lastVertice[i]);
//
//        }
        return resultShortList.iterator();
    }

    /**
     * Método responsavel por retornar se a coleçao esta ou nao vazia
     *
     * @return True caso sim, false caso contrario
     */
    @Override
    public boolean isEmpty() {
        return (numVertices == 0);
    }

    /**
     * Método responsavel por retornar se o grafo é ou nao conexo
     *
     * @return
     */
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

    /**
     * Método responsavel por retornar o numero de vertices
     *
     * @return numero de vertices
     */
    @Override
    public int size() {
        return this.numVertices;
    }

    /**
     * Método para aumentar a capacidade da coleçao
     */
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

    /**
     * Método responsavel por verificar se um index é valido
     *
     * @param index para verificar
     * @return true caso sim, falso caso contrario
     */
    public boolean indexIsValid(int index) {
        return (index < this.vertices.length && index >= 0);
    }

    /**
     * Método responsavel por retornar o conjunto de vertices
     *
     * @return conjunto de vertices do grafo
     */
    public T[] getVertices() {
        return vertices;
    }

    /**
     * chouriço
     */
    public void printmatriz() {
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }

    }
}
