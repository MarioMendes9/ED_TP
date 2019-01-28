/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_ad;

import ArrayList.ArrayUnorderedList;
import java.util.Iterator;

/**
 *
 * @author dani_
 */
public class SuperNetwork<T> extends Network<T> {

    public SuperNetwork() {
        super();
    }

    public Iterator iteratorShortestPathEdges(T startVertex, T targetVertex) throws NonAvailablePath {
        return iteratorShortestPathEdges(getIndex(startVertex), getIndex(targetVertex));
    }

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
        System.out.println("Vertice || Visited || Cost || Last");
        for (int i = 0; i < lastVertice.length; i++) {
            System.out.println(vertices[i] + "||" + visited[i] + "||" + cost[i] + "||" + lastVertice[i]);

        }
        return resultShortList.iterator();
    }

    public boolean areConnected(T u1, T u2) {
        return (adjMatrix[getIndex(u1)][getIndex(u2)] > 0);
    }

}
