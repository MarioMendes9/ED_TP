/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import ed_tp.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import matriz_ad.NonAvailablePath;

/**
 *
 * @author User
 */
public class testSocialGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user1= new User(1, 23, "Mário", "mario@hotmail.com", 1);
        User user2= new User(2, 24, "Jorge", "j@hotmail.com", 2);
        User user3= new User(3, 25, "Mendes", "m@hotmail.com", 3);
        User user4= new User(4, 26, "Leite", "leite@hotmail.com", 4);
        User user5= new User(5, 27, "Leite", "leitxde@hotmail.com", 5);
        User user6= new User(6, 27, "Leite", "leitejorge@hotmail.com", 5);
        SocialGraph social=new SocialGraph();
        social.addUser(user1);
        social.addUser(user2);
        social.addUser(user3);
        social.addUser(user4);
        social.addUser(user5);
        social.addUser(user6);
        social.addUserFriend(user1, user2);
        social.addUserFriend(user2, user4);
        social.addUserFriend(user3,user1);
        social.addUserFriend(user5, user4);
       // social.addUserFriend(user6, user2);
        
        social.print();
        
        System.out.println(social.completo());
        
        try {
            ArrayList.ArrayUnorderedList<User> xd=social.fastFriends("mario@hotmail.com");
            System.out.println("print pode conhecer");
            for (int i = 0; i <= xd.size(); i++) {
                System.out.println(xd.removeFirst()+" ");
                
            }
            
        } catch (ElementNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
