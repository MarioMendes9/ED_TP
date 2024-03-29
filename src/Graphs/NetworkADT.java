package Graphs;

/**
 * NetworkADT defines the interface to a network.
 *
 * @param <T> tipos genericos de dados
 */
public interface NetworkADT<T> extends GraphADT<T> {

    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight the weight
     */
    public void addEdge(T vertex1, T vertex2, double weight);

    /**
     * Returns the weight of the shortest path in this network.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the weight of the shortest path in this network
     * @throws Graphs.NonAvailablePath se nao existir um caminho entre eles
     */
    public double shortestPathWeight(T vertex1, T vertex2) throws NonAvailablePath;
}
