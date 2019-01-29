/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import Heap.EmptyCollectionException;
import ArrayList.ArrayUnorderedList;
import ArrayList.EmptyListException;
import Heap.UnorderedListADT;
import ed_tp.User;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mario
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //JanelaPrincipal j= new JanelaPrincipal();
        SocialGraph social = new SocialGraph();
        User user1 = new User(1, 10, "A", "a@mmm.mmm", 2);
        User user2 = new User(2, 10, "B", "b@mmm.mmm", 3);
        User user3 = new User(3, 10, "C", "c@mmm.mmm", 4);
        User user4 = new User(4, 10, "D", "d@mmm.mmm", 5);
        User user5 = new User(5, 10, "E", "e@mmm.mmm", 1);
        User user6 = new User(6, 10, "M", "m@mmm.mmm", 2);
      //  User user7 = new User(5, 10, "g", "g@mmm.mmm", 2);
        user1.addSkill("java");
        user2.addSkill("java");
       
        user3.addSkill("java");
        user4.addSkill("netbeans");
        user5.addSkill("java");
        user6.addSkill("java");
      //  user7.addSkill("java");
      user1.addCargo(200, "dev", "estg");
      user2.addCargo(200, "dev", "estg");    
      user6.addCargo(200, "dev", "estg");
      user5.addCargo(200, "dev", "es");
      user3.addCargo(200, "dev", "estg");
      user4.addCargo(200, "dev", "estg");
      
      
      

        social.addUser(user1);
        social.addUser(user2);
        social.addUser(user3);
        social.addUser(user4);
        social.addUser(user5);
        social.addUser(user6);
      //  social.addUser(user7);
//        social.addUser(user8);
        
        
        try {
            social.addUserFriend("a@mmm.mmm", "m@mmm.mmm");
            social.addUserFriend("m@mmm.mmm", "c@mmm.mmm");
             social.addUserFriend("c@mmm.mmm", "d@mmm.mmm");
            social.addUserFriend("a@mmm.mmm", "b@mmm.mmm");         
//            social.addUserFriend("b@mmm.mmm", "d@mmm.mmm");           
//            social.addUserFriend("f@mmm.mmm", "g@mmm.mmm");           
//            social.addUserFriend("b@mmm.mmm", "f@mmm.mmm");  
           
            System.out.println(social.enemyCompanies("es", "estg"));
           
        }catch (ElementNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
       // social.print();
     //   System.out.println(social.completo());
        
        
    }
    
}
