package matriz_ad;

import Heap.Heap;
import LinkedStack.*;
import LinkedQueue.*;
import ArrayList.*;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mario
 * @param <T>
 */
public class Network<T> extends Graph<T> implements NetworkADT<T> {

    //private final int DEFAULT_WEIGHT = 0;
    private double[][] adjMatrix;    // adjacency matrix=Matriz com os pesos das arestas

    /**
     * Construtor para a network
     */
    public Network() {
        numVertices = 0;
        this.adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Adiciona um vertice
     *
     * @param vertex a adicionar
     */
    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = 0.0;
            adjMatrix[i][numVertices] = 0.0;
        }
        numVertices++;
    }

    /**
     * Método responsavel por remover um vertice
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
            for (int j = this.numVertices - 1; j < this.numVertices; j++) {
                this.adjMatrix[i][j] = 0.0;
            }
        }

        for (int i = this.numVertices - 1; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.adjMatrix[i][j] = 0.0;
            }
        }

        this.numVertices--;
    }

    /**
     * Adiciona um ligaçao entre dois vertices
     *
     * @param vertex1 primeiro vertice
     * @param vertex2 segundo vertice
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2), 0);
    }

    /**
     *
     * @param index1
     * @param index2
     * @param weight
     */
    public void addEdge(int index1, int index2, double weight) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = weight;

        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        addEdge(getIndex(vertex1), getIndex(vertex2), weight);
    }

    @Override
    public void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = 0.0;
            adjMatrix[index2][index1] = 0.0;
        }
    }

    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) throws NonAvailablePath{
        
            return iteratorShortestPath(getIndex(startVertex),
                    getIndex(targetVertex));  
    }

    public Iterator iteratorShortestPath(int startIndex, int targetIndex) throws NonAvailablePath{
        Integer x = 0;
        ArrayUnorderedList<T> resultShortList = new ArrayUnorderedList<T>();
        //Inicializa o vetor de visitados
        Boolean[] visited = new Boolean[this.numVertices];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;

        }
        double[] cost = new double[this.numVertices];
        //Inicia o vetor de custo 
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Double.MAX_VALUE;

        }
        //Inicializa o vetor do ultimo vertice
        int lastVertice[] = new int[this.numVertices];

        for (int i = 0; i < lastVertice.length; i++) {
            lastVertice[i] = -1;

        }

        if (!indexIsValid(startIndex)) {
            return resultShortList.iterator();
        }

        //visited[startIndex] = true;
        cost[startIndex] = 0;
        int flag = 0;

        while (flag != numVertices) {
            double costTemp = Double.MAX_VALUE;
            for (int i = 0; i < cost.length ; i++) {
                if (costTemp > cost[i] && visited[i] != true) {
                    x = i;
                    costTemp = cost[i];

                }
            }
            flag++;
            visited[x] = true;

            for (int i = 0; i < numVertices; i++) {
                if ((adjMatrix[x.intValue()][i] > 0) && !visited[i]) {
                    if (cost[i] > costTemp + adjMatrix[x.intValue()][i]) {
                        lastVertice[i] = x;
                        cost[i] = costTemp + adjMatrix[x.intValue()][i];
                    }

                }

            }

        }
        int vertex=targetIndex;
        
        if(lastVertice[vertex]==-1){
           throw new NonAvailablePath();
        }
        
        while(vertex!=startIndex){
            resultShortList.addToFront(this.vertices[vertex]);
            vertex=lastVertice[vertex];
        }
        resultShortList.addToFront(this.vertices[startIndex]);
        
        return resultShortList.iterator();

    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double getPathWeight(UnorderedListADT<Integer> list){
        double sum=0;
        int var1=list.removeFirst();
        int var2=list.removeFirst();
        sum+=adjMatrix[var1][var2];
        for(Integer i:list){
            var1=var2;
            var2=list.removeFirst();
            sum+=adjMatrix[var1][var2];
        }
        return sum;
        
    }

    @Override
    protected void expandCapacity() {
        double[][] adjMatrix2 = new double[this.numVertices * 2][this.numVertices * 2];

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
        this.adjMatrix = adjMatrix2;

    }

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
                if ((adjMatrix[x.intValue()][i] > 0)
                        && !visited[i]) {
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
    public Iterator<T> iteratorBFS(int startIndex) {
        Integer x = null;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

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
                if ((adjMatrix[x.intValue()][i] > 0)
                        && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    @Override
    public void printmatriz() {
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.adjMatrix[i][j] + " ||");
            }
            System.out.println("");
        }

    }

//    public Network mstNetwork() {
//        int x, y;
//        int index;
//        double weight;
//        int[] edge = new int[2];
//        Heap<Double> minHeap = new Heap<>();
//        Network<T> resultGraph = new Network<>();
//        if (isEmpty() || !isConnected()) {
//            return resultGraph;
//        }
//        resultGraph.adjMatrix = new double[numVertices][numVertices];
//        for (int i = 0; i < numVertices; i++) {
//            for (int j = 0; j < numVertices; j++) {
//                resultGraph.adjMatrix[i][j] = Double.POSITIVE_INFINITY;
//            }
//        }
//        resultGraph.vertices = (T[]) (new Object[numVertices]);
//
//        boolean[] visited = new boolean[numVertices];
//        for (int i = 0; i < numVertices; i++) {
//            visited[i] = false;
//        }
//
//        edge[0] = 0;
//        resultGraph.vertices[0] = this.vertices[0];
//        resultGraph.numVertices++;
//        visited[0] = true;
//        /**
//         * Add all edges, which are adjacent to the starting vertex, to the heap
//         */
//        for (int i = 0; i < numVertices; i++) {
//            minHeap.addElement(new Double(adjMatrix[0][i]));
//        }
//        while ((resultGraph.size() < this.size()) && !minHeap.isEmpty()) {
//            /**
//             * Get the edge with the smallest weight that has exactly one vertex
//             * already in the resultGraph
//             */
//            do {
//                weight = (minHeap.removeMin()).doubleValue();
//                edge = getEdgeWithWeightOf(weight, visited);
//            } while (!indexIsValid(edge[0]) || !indexIsValid(edge[1]));
//
//            x = edge[0];
//            y = edge[1];
//            if (!visited[x]) {
//                index = x;
//            } else {
//                index = y;
//            }
//            /**
//             * Add the new edge and vertex to the resultGraph
//             */
//            resultGraph.vertices[index] = this.vertices[index];
//            visited[index] = true;
//            resultGraph.numVertices++;
//            resultGraph.adjMatrix[x][y] = this.adjMatrix[x][y];
//            resultGraph.adjMatrix[y][x] = this.adjMatrix[y][x];
//            /**
//             * Add all edges, that are adjacent to the newly added vertex, to
//             * the heap
//             */
//            for (int i = 0; i < numVertices; i++) {
//                if (!visited[i] && (this.adjMatrix[i][index]
//                        < Double.POSITIVE_INFINITY)) {
//                    edge[0] = index;
//                    edge[1] = I;
//                    minHeap.addElement(new Double(adjMatrix[index][i]));
//                }
//            }
//        }
//        return resultGraph;
//    }
}
