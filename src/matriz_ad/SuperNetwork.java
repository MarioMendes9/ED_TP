
package matriz_ad;

import ArrayList.ArrayUnorderedList;
import java.util.Iterator;

/**
 * Classe que representaçao uma super Network 
 * @param <T> tipo generido de dados 
 */
public class SuperNetwork<T> extends Network<T> {

    /**
     * Construtor para a classe super network 
     */
    public SuperNetwork() {
        super();
    }

    /**
     * Iterator caminho mais curto por numero de arestas para esta classe 
     * @param startVertex vertice inicial 
     * @param targetVertex vertice final 
     * @return iterator com o conjunto de vertices 
     * @throws NonAvailablePath se nao existir caminho 
     */
    public Iterator iteratorShortestPathEdges(T startVertex, T targetVertex) throws NonAvailablePath {
        return iteratorShortestPathEdges(getIndex(startVertex), getIndex(targetVertex));
    }

     /**
     * Iterator caminho mais curto por numero de arestas para esta classe 
     * @param startVertex vertice inicial 
     * @param targetVertex vertice final 
     * @return iterator com o conjunto de vertices 
     * @throws NonAvailablePath se nao existir caminho 
     */
    
    public Iterator iteratorShortestPathEdges(int startVertex, int targetVertex) throws NonAvailablePath {
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
                if ((adjMatrix[x.intValue()][i] > 0.0) && !visited[i]) {
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
     * Método para verificar se dois vertices estao ligados
     * @param u1 primeiro vertice 
     * @param u2 segundo vertice 
     * @return true caso esteja, false caso contrario 
     */
    public boolean areConnected(T u1, T u2) {
        return (adjMatrix[getIndex(u1)][getIndex(u2)] > 0);
    }

}
