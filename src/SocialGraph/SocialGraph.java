/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import ArrayList.ArrayUnorderedList;
import Heap.UnorderedListADT;
import matriz_ad.Network;
import ed_tp.User;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import matriz_ad.NonAvailablePath;

/**
 *
 * @author User
 * @param <User>
 */
public class SocialGraph {

    private Network<User> socialGraph;

    public SocialGraph() {
        this.socialGraph = new Network<>();

    }

    public void addUser(User add) {
        this.socialGraph.addVertex(add);

    }

    public void removeUser(User remove) {
        this.socialGraph.removeVertex(remove);
    }

    public void addUserFriend(User first, User second) {
        this.socialGraph.addEdge(first, second, (1.0 / first.getVisualizacoes()));
        this.socialGraph.addEdge(second, first, (1.0 / second.getVisualizacoes()));

    }

    public User searchUser(String email) throws ElementNotFoundException {

        Object[] users = socialGraph.getVertices();

        int i = 0;
        while (i < socialGraph.getNumVertices()) {
            if (((User) users[i]).getEmail().equals(email)) {
                ((User) users[i]).setVisualizacoes(((User) users[i]).getVisualizacoes() + 1);
                return ((User) users[i]);
            }
            i++;
        }

        throw new ElementNotFoundException();

    }

    public boolean completo() {
        double[][] adjxma = socialGraph.getAdjMatrix();

        for (int i = 0; i < socialGraph.getNumVertices(); i++) {
            for (int j = 0; j < socialGraph.getNumVertices(); j++) {
                if (i != j && adjxma[i][j] == 0.0) {
                    return false;
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

        for (int i = 0; i < socialGraph.getNumVertices(); i++) {
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

    public void dez() {

    }

    public void print() {
        socialGraph.printmatriz();
    }
}
