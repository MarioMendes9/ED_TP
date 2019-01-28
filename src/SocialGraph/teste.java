/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import Heap.EmptyCollectionException;
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
    public static void main(String[] args) throws EmptyCollectionException {
//        JanelaPrincipal j= new JanelaPrincipal();
        SocialGraph social = new SocialGraph();
        User user1 = new User(1, 10, "Mario", "mario@mm.mmm", 2);
        User user2 = new User(2, 10, "jorge", "jorge@mmm.mmm", 3);
        User user3 = new User(3, 10, "Mendes", "mendes@mmm.mmm", 4);
        User user4 = new User(4, 10, "leite", "leite@mmm.mmn", 5);
        User user5 = new User(5, 10, "lei", "lei@mmm.mmm", 6);
        user1.addSkill("java");
       //user2.addSkill("java");
        user3.addSkill("java");
        user4.addSkill("java");
        user5.addSkill("java");
        social.addUser(user1);
        social.addUser(user2);
        social.addUser(user3);
        social.addUser(user4);
        social.addUser(user5);

        try {
            social.addUserFriend("mario@mm.mmm", "jorge@mmm.mmm");           
           

            social.addUserFriend("jorge@mmm.mmm", "mendes@mmm.mmm");
             social.addUserFriend("jorge@mmm.mmm", "lei@mmm.mmm");

            social.addUserFriend("mendes@mmm.mmm", "lei@mmm.mmm");

           Iterator<User> it= social.usersWithSkill("java", user1).iterator();
            System.out.println("IMPRIMIR");
           while(it.hasNext()){
               User a=it.next();
               System.out.println(a.getNome());
           }
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

}
