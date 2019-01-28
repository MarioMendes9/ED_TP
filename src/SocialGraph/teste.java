/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

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
        User user1 = new User(1, 10, "Mario", "mario@m.msd", 1);
        User user2 = new User(2, 10, "jorge", "jorge@j.jsd", 1);
        User user3 = new User(3, 10, "Mendes", "mendes@m.msd", 1);
        User user4 = new User(4, 10, "leite", "leite@l.lsd", 1);
        User user5 = new User(5, 10, "lei", "lee@l.lsd", 1);
        User user6 = new User(6, 10, "babo", "babo@l.lsd", 1);
        User user7 = new User(7, 10, "sete", "sete@l.lsd", 1);
        User user8 = new User(8, 10, "oito", "oito@l.lsd", 1);
        
        social.addUser(user1);
        social.addUser(user2);
        social.addUser(user3);
        social.addUser(user4);
        social.addUser(user5);
        social.addUser(user6);
        social.addUser(user7);
         social.addUser(user8);
        //user6.addCargo(1999, "rei", "Estg");
        user5.addSkill("Netbeans");
       // user3.addSkill("Netbeans");
        user3.addSkill("Java");
        user7.addSkill("Netbeans");
        user5.addCargo(1998, "roubo", "Estg");
        user8.addCargo(1555, "mano", "Estg");

        try {
            social.addUserFriend("mario@m.msd", "jorge@j.jsd");
            // social.addUserFriend("mario", "mendes");
            social.addUserFriend("mario@m.msd", "leite@l.lsd");
            social.addUserFriend("babo@l.lsd", "lee@l.lsd");
            social.addUserFriend("jorge@j.jsd", "mendes@m.msd");
            social.addUserFriend("jorge@j.jsd", "leite@l.lsd");

            social.addUserFriend("mendes@m.msd", "lee@l.lsd");
            social.addUserFriend("mario@m.msd", "lee@l.lsd");
            social.addUserFriend("mendes@m.msd", "sete@l.lsd");

            ArrayUnorderedList<User> a = social.fastFriendsEmpresa("mario@m.msd", "Netbeans");
            ArrayUnorderedList<User> b = social.fastFriendsEmpresa("mario@m.msd", "Estg");
            System.out.println(a.size());
            System.out.println(b.size());

            Iterator<User> xd = social.canMeet("mario@m.msd").iterator();
            while (xd.hasNext()) {
                System.out.println(xd.next().getEmail());
            }
            System.out.println("cantasdasdasdasASDASDASDASDASDASD");
            Iterator<User> xdd = social.cantMeet("mario@m.msd").iterator();
            while (xdd.hasNext()) {
                System.out.println(xdd.next().getEmail());
            }
           
            
            Iterator<User> dd=social.workOn("mario@m.msd", "Estg").iterator();
            
            while(dd.hasNext()){
                System.out.println(dd.next());
            }
            ArrayUnorderedList<String> skills=new ArrayUnorderedList<>();
            skills.addToFront("Java");
            skills.addToFront("Netbeans");
            skills.addToFront("C++");
            
            Iterator<User> ddd=social.fastFriendsSkills("jorge@j.jsd", skills).iterator();
            System.out.println("\n\n\n\n\n\n\n\n");
            while(ddd.hasNext()){
                System.out.println(ddd.next());
                      
            }
               
        } catch (ElementNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
