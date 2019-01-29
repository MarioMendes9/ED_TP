/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class EDFP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Network<String> net = new Network<>();
//
//        net.addVertex("A");
//        net.addVertex("B");
//        net.addVertex("C");
//        net.addVertex("D");
//        net.addVertex("E");
//        net.addVertex("F");
//        net.addVertex("G");
//        net.addVertex("H");
//
//        net.addEdge("A", "B", 1);
//        net.addEdge("A", "E", 1);
//        net.addEdge("D", "B", 6);
//        net.addEdge("G", "E", 5);
//        net.addEdge("C", "G", 8);
//        net.addEdge("F", "B", 4);
//        net.addEdge("F", "G", 4);
//        net.addEdge("G", "H", 1);
//        net.addEdge("H", "G", 2);
//        net.addEdge("H", "F", 9);
//        net.addEdge("D", "H", 1);
//        net.addEdge("A", "B", 2);
//       // net.addEdge("B", "A", 3);
//        //net.addEdge("A", "C", 7);
//        net.addEdge("A", "D", 3);
//        //net.addEdge("B", "C", 2);
//        net.addEdge("B", "D", 4);
//        //net.addEdge("C", "A", 1);
//      //  net.addEdge("C", "B", 5);
//       // net.addEdge("C", "D", 6);
//       // net.addEdge("D", "A", 4);
//     //   net.addEdge("D", "B", 3);
//        net.addEdge("D", "C", 2);

        //net.printmatriz();
        //System.out.println("kkkkkkkkkkkkkkkk");
        // System.out.println(net.toString());
        // net.removeVertex("D");
       // net.printmatriz();
        //Iterator<String> a=net.iteratorDFS("A");
//        a.next();
        //while(a.hasNext()){
        //  System.out.print(a.next());

        //}
//        Iterator<String> a = null;
//        try {
//            a = net.iteratorShortestPath("D", "E");
//            while (a.hasNext()) {
//                System.out.print(a.next() + "||");
//            }
//            System.out.println("ggggggg");
//            System.out.println(net.shortestPathWeight("D", "E"));
//        } catch (NonAvailablePath ex) {
//            System.out.println(ex.getMessage());
//        }

        Graph<String> graph = new Graph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        
        graph.addEdge("A", "B");
        graph.addEdge("B", "A");
        graph.addEdge("E", "B");
        graph.addEdge("B", "E");
        graph.addEdge("D", "E");
        graph.addEdge("E", "D");
        graph.addEdge("B", "D");
        graph.addEdge("D", "B");
        graph.addEdge("D", "C");
        graph.addEdge("C", "D");
        graph.addEdge("B", "C");
        graph.addEdge("C", "B");
        
        
        try {
           Iterator c= graph.iteratorShortestPath("A", "C");
           
           while(c.hasNext()){
               System.out.println(c.next());
           }
        } catch (NonAvailablePath ex) {
            Logger.getLogger(EDFP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
