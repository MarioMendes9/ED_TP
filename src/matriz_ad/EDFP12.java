/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_ad;

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
        Network<String> net=new Network<>();
        
        net.addVertex("A");
        net.addVertex("B");
        net.addVertex("C");
        net.addVertex("D");
        net.addVertex("E");
        net.addVertex("F");
        net.addVertex("G");
        net.addVertex("H");
       
       net.addEdge("A","D", 2);
       net.addEdge("D","H", 6);
       net.addEdge("B","A", 7);
       net.addEdge("A","C", 6);
       net.addEdge("C","A", 7);
       net.addEdge("B","C", 7);
       net.addEdge("C","B", 6);
       net.addEdge("B","F", 6);
       net.addEdge("G","F", 2);
       net.addEdge("A","E", 8);
       net.addEdge("E","H", 6);
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
         net.printmatriz();
        //Iterator<String> a=net.iteratorDFS("A");
//        a.next();
        //while(a.hasNext()){
          //  System.out.print(a.next());
            
        //}
       Iterator <String> a = null;
        try {
            a = net.iteratorShortestPath("A", "F");
             while(a.hasNext()){
            System.out.print(a.next()+"||");
        }
        } catch (NonAvailablePath ex) {
            System.out.println(ex.getMessage());
        }
       
        
        
        
    }
    
}
