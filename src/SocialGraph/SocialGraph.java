package SocialGraph;

import ArrayList.ArrayUnorderedList;
import Heap.EmptyCollectionException;
import Heap.LinkedUnorderedList;
import Heap.UnorderedListADT;
import ArrayList.*;
import ed_tp.CargosProfissionais;
import matriz_ad.Network;
import ed_tp.User;
import java.util.Iterator;
import matriz_ad.NonAvailablePath;
import matriz_ad.SuperNetwork;

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
        //Ignorar ele mesmo
        it.next();
        while (it.hasNext()) {
            knows.addToRear(it.next());
        }

        return knows;
    }

    public ArrayUnorderedList<User> cantMeet(String userMail) throws ElementNotFoundException {
        ArrayUnorderedList<User> can = this.canMeet(userMail);
        ArrayUnorderedList<User> cant = new ArrayUnorderedList<>();

        Object[] users = socialGraph.getVertices();
        if (can.size() == socialGraph.size()) {
            return cant;
        } else {
            //Nao inserir ele memso
            for (int i = 1; i < socialGraph.size(); i++) {

                if (!can.contains((User) users[i])) {
                    cant.addToRear((User) users[i]);
                }

            }
        }
        return cant;
    }

    public ArrayUnorderedList<User> fastFriendsEmpresa(String userMail, String goal) throws ElementNotFoundException {

        User user = searchUser(userMail);
        Object[] users = socialGraph.getVertices();
        ArrayUnorderedList<User> connects = new ArrayUnorderedList<>();
        ArrayUnorderedList<User> fastfriends = new ArrayUnorderedList<>();

        //Listas os utilizadores que tem pelo menos custo de 1 
        for (int i = 0; i < socialGraph.size(); i++) {
            Iterator<User> it;
            try {
                it = socialGraph.iteratorShortestPathEdges(user, ((User) users[i]));

                int count = 0;
                while (it.hasNext()) {
                    count++;
                    System.out.println(it.next());
                }

                if (count <= 3) {
                    connects.addToRear(((User) users[i]));
                }
            } catch (NonAvailablePath ex) {
            }
        }

        //Filtra os utlizadores 
        Iterator<User> iterat = connects.iterator();

        while (iterat.hasNext()) {
            User filterUser = iterat.next();

            Iterator<CargosProfissionais> filterCargo = filterUser.getCargos().iterator();

            while (filterCargo.hasNext()) {
                CargosProfissionais fc = filterCargo.next();
                if (fc.getEmpresa().equals(goal)) {
                    fastfriends.addToRear(filterUser);

                }

            }
        }
        
            return fastfriends;
    }
    

    /**
     *
     * @param userMail
     * @param skills
     * @return
     * @throws ElementNotFoundException
     */
    public ArrayUnorderedList<User> fastFriendsSkills(String userMail, ListADT<String> skills) throws ElementNotFoundException {
        
        User user = searchUser(userMail);
        Object[] users = socialGraph.getVertices();
        ArrayUnorderedList<User> connects = new ArrayUnorderedList<>();
        ArrayUnorderedList<User> fastfriends = new ArrayUnorderedList<>();

        //Listas os utilizadores que tem pelo menos custo de 1 
        for (int i = 0; i < socialGraph.size(); i++) {
            Iterator<User> it;
            try {
                it = socialGraph.iteratorShortestPathEdges(user, ((User) users[i]));

                int count = 0;
                while (it.hasNext()) {
                    count++;
                    System.out.println(it.next());
                }

                if (count <= 3) {
                    connects.addToRear(((User) users[i]));
                }
            } catch (NonAvailablePath ex) {
            }
        }

        //Filtra os utlizadores 
        Iterator<User> iterat = connects.iterator();
        while (iterat.hasNext()) {
            User filterUser = iterat.next();
            Iterator<String> filterSkill = filterUser.getSkills().iterator();
            boolean add=false;
            while (filterSkill.hasNext() && !add) {
                String s = filterSkill.next();
                if (skills.contains(s)) {
                    fastfriends.addToRear(filterUser);
                    add=true;
                }
            }
        }
        return fastfriends;
    }

    public ArrayUnorderedList<User> workOn(String userMail, String Empresa) throws ElementNotFoundException {
        User user = searchUser(userMail);
        ArrayUnorderedList<User> workThere = new ArrayUnorderedList<>();
        Iterator<User> it = socialGraph.iteratorBFS(user);

        while (it.hasNext()) {
            User tempUser = it.next();
            Iterator<CargosProfissionais> filterEmpresa = tempUser.getCargos().iterator();

            while (filterEmpresa.hasNext()) {
                CargosProfissionais fc = filterEmpresa.next();
                if (fc.getEmpresa().equals(Empresa)) {
                    workThere.addToRear(tempUser);

                }

            }

        }
        return workThere;

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
