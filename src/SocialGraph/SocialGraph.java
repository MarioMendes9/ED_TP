/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import ArrayList.ArrayUnorderedList;
import Heap.EmptyCollectionException;
import Heap.LinkedUnorderedList;
import Heap.UnorderedListADT;
import ed_tp.User;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import matriz_ad.NonAvailablePath;
import matriz_ad.SuperNetwork;

/**
 *
 * @author User
 * @param <User>
 */
public class SocialGraph {

    private SuperNetwork<User> socialGraph;

    public SocialGraph() {
        this.socialGraph = new SuperNetwork<>();

    }

    public void addUser(User add) {
        this.socialGraph.addVertex(add);

    }

    public void removeUser(String email) throws ElementNotFoundException {
        this.socialGraph.removeVertex(searchUser(email));
    }

    public void addUserFriend(String first, String second) throws ElementNotFoundException {
        this.socialGraph.addEdge(searchUser(first), searchUser(second), (1.0 / searchUser(first).getVisualizacoes()));
        this.socialGraph.addEdge(searchUser(second), searchUser(first), (1.0 / searchUser(second).getVisualizacoes()));

    }

    public User searchUser(String email) throws ElementNotFoundException {

        Object[] users = socialGraph.getVertices();

        int i = 0;
        while (i < socialGraph.size()) {
            if (((User) users[i]).getEmail().equals(email)) {
                return ((User) users[i]);
            }
            i++;
        }

        throw new ElementNotFoundException();

    }

    public boolean completo() {
        if (!socialGraph.isConnected()) {
            return false;

        }

        for (int i = 0; i < socialGraph.size(); i++) {
            for (int j = 0; j < socialGraph.size(); j++) {
                if (i != j) {
                    try {
                        Iterator it = socialGraph.iteratorShortestPathEdges(i, j);
                        int n = 0;
                        while (it.hasNext()) {
                            System.out.println(it.next());
                            n++;
                            
                        }

                        if (n != 2) {
                            System.out.println("passou aqui");
                            return false;
                        }
                    } catch (NonAvailablePath ex) {
                        return false;
                    }

                }
            }

        }
        return true;
    }

    public Iterator<User> shortPath(String emailUser1, String emailUser2) throws NonAvailablePath, ElementNotFoundException {

        Iterator<User> it = socialGraph.iteratorShortestPath(searchUser(emailUser1), searchUser(emailUser2));

        return it;
    }

    public ArrayUnorderedList<User> canMeet(String userMail) throws ElementNotFoundException {
        User user = searchUser(userMail);
        ArrayUnorderedList<User> knows = new ArrayUnorderedList<>();

        Iterator<User> it = socialGraph.iteratorBFS(user);

        while (it.hasNext()) {
            knows.addToRear(it.next());
        }

        return knows;
    }

    public ArrayUnorderedList<User> fastFriends(String userMail) throws ElementNotFoundException {

        User user = searchUser(userMail);
        Object[] users = socialGraph.getVertices();
        ArrayUnorderedList<User> fastFriends = new ArrayUnorderedList<>();

        for (int i = 0; i < socialGraph.size(); i++) {
            Iterator<User> it;
            try {
                it = socialGraph.iteratorShortestPath(user, ((User) users[i]));

                int count = 0;
                while (it.hasNext()) {
                    count++;
                    it.next();
                }
                if (count == 3) {
                    fastFriends.addToRear(((User) users[i]));
                }
            } catch (NonAvailablePath ex) {
                System.out.println("");
            }

        }

        return fastFriends;
    }

    public void oito() {

    }

    public void nove() {

    }

    public LinkedUnorderedList<User> usersWithSkill(String skill, User u) throws EmptyCollectionException {
      LinkedUnorderedList<User> list=new LinkedUnorderedList<>();
      LinkedUnorderedList<User> finallist=new LinkedUnorderedList<>();
     
      Object[] users=this.socialGraph.getVertices();
      for(int j=0;j<users.length;j++){
          Iterator<String> i=((User)users[j]).getSkills().iterator();
          while(i.hasNext()){
              String s=i.next();
              if(s.equals(skill)){
                  list.addToRear((User)(users[j]));
              }
          }     
      }
      Iterator<User> i=list.iterator();
      while(i.hasNext()){
          User a = null;
          User us=i.next();
          try {
              double d=socialGraph.shortestPathWeight(u,us);
              if(finallist.isEmpty()){
                  finallist.addToFront(us);
              }else{
                  Iterator<User> it=finallist.iterator();
                  while(it.hasNext()){
                      a=it.next();
                      double e=socialGraph.shortestPathWeight(u, a);
                      double f=socialGraph.shortestPathWeight(u,finallist.first());
                      if(e<f){
                          finallist.addToFront(a);
                          
                      }else
                      if(d>e){
                          finallist.addAfter(a, us);
                          break;
                      }
                  }
                  
              }
          } catch (NonAvailablePath ex) {
            
          }
      }
        return finallist;
    }

    public void print() {
        socialGraph.printmatriz();
    }
}
