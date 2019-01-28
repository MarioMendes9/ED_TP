/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import Heap.EmptyCollectionException;
import ArrayList.ArrayUnorderedList;
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
        User user1 = new User(1, 10, "Mario", "mario@mm.mmm", 2);
        User user2 = new User(2, 10, "jorge", "jorge@mmm.mmm", 3);
        User user3 = new User(3, 10, "Mendes", "mendes@mmm.mmm", 4);
        User user4 = new User(4, 10, "leite", "leite@mmm.mmn", 5);
        User user5 = new User(5, 10, "lei", "lei@mmm.mmm", 6);
        user1.addSkill("java");
        user2.addSkill("java");
        user3.addSkill("java");
        user4.addSkill("java");
        user5.addSkill("java");
        User user6 = new User(6, 10, "babo", "babo@l.lsd", 1);
        User user7 = new User(7, 10, "sete", "sete@l.lsd", 1);
        User user8 = new User(8, 10, "oito", "oito@l.lsd", 1);

        social.addUser(user1);
        social.addUser(user2);
        social.addUser(user3);
        social.addUser(user4);
        social.addUser(user5);
//        social.addUser(user6);
//        social.addUser(user7);
//        social.addUser(user8);
        

        try {
            social.addUserFriend("jorge@mmm.mmm", "mendes@mmm.mmm");
            social.addUserFriend("mario@mm.mmm", "leite@mmm.mmn");
             social.addUserFriend("jorge@mmm.mmm", "lei@mmm.mmm");
            social.addUserFriend("mendes@mmm.mmm", "lei@mmm.mmm");         
            social.addUserFriend("mario@mm.mmm", "jorge@mmm.mmm");           
           
           Iterator<User> it= social.usersWithSkill("java", user1).iterator();
            System.out.println("IMPRIMIR");
           while(it.hasNext()){
               User aa=it.next();
               System.out.println(aa.getNome());
           }          
        } catch (ElementNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
