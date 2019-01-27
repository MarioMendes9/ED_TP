/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import ed_tp.User;
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
        SocialGraph social = new SocialGraph();
        User user1 = new User(1, 10, "Mario", "mario", 1);
        User user2 = new User(2, 10, "jorge", "jorge", 1);
        User user3 = new User(3, 10, "Mendes", "mendes", 1);
        User user4 = new User(4, 10, "leite", "leite", 1);
        User user5 = new User(5, 10, "lei", "lee", 1);
        social.addUser(user1);
        social.addUser(user2);
        social.addUser(user3);
        social.addUser(user4);
      //  social.addUser(user5);

        try {
            social.addUserFriend("mario", "jorge");
            social.addUserFriend("mario", "mendes");
            social.addUserFriend("mario", "leite");

            social.addUserFriend("jorge", "mendes");
             social.addUserFriend("jorge", "leite");

            social.addUserFriend("mendes", "leite");

        } catch (ElementNotFoundException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(social.completo());
    }

}
