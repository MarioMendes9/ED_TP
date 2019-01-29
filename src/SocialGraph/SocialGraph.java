package SocialGraph;

import ArrayList.ArrayUnorderedList;
import Heap.EmptyCollectionException;
import Heap.LinkedUnorderedList;
import Heap.UnorderedListADT;
import ArrayList.*;
import ed_tp.CargosProfissionais;
import ed_tp.User;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            boolean add = false;
            while (filterSkill.hasNext() && !add) {
                String s = filterSkill.next();
                if (skills.contains(s)) {
                    fastfriends.addToRear(filterUser);
                    add = true;
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
        LinkedUnorderedList<User> list = new LinkedUnorderedList<>();
        LinkedUnorderedList<User> list2 = new LinkedUnorderedList<>();
        LinkedUnorderedList<User> finallist = new LinkedUnorderedList<>();

        Object[] users = this.socialGraph.getVertices();
        for (int j = 0; j < socialGraph.size(); j++) {
            Iterator<String> i = ((User) users[j]).getSkills().iterator();
            boolean add = false;
            while (i.hasNext() && !add) {
                String s = i.next();
                if (s.equals(skill)) {
                    list.addToRear((User) (users[j]));
                    add=true;
                }
            }
        }
        
        //REMOVE OS QUE NAO TEM CAMINHO
        Iterator<User> r=list.iterator();
        while(r.hasNext()) {
            User tempuser=r.next();
            try {
                socialGraph.shortestPathWeight(u, tempuser);
                list2.addToRear(tempuser);
                
            } catch (NonAvailablePath ex) {
                
            }
            
        }
        while (!list2.isEmpty()) {
            Iterator<User> i = list2.iterator();
            double min = Double.MAX_VALUE;
            User usermin = null;
            while (i.hasNext()) {
                User a = i.next();
                try {
                    if (socialGraph.shortestPathWeight(u, a) < min) {
                        min = socialGraph.shortestPathWeight(u, a);                         
                        usermin=a;
                    }
                } catch (NonAvailablePath ex) {
                    ex.getMessage();
                    usermin=a;
                    break;
                }
                
            }
            finallist.addToRear(usermin); 
            list2.remove(usermin);
            
        }
        return finallist;
    }

    public boolean enemyCompanies(String empresa1,String empresa2) {

        Object[] users = socialGraph.getVertices();
        
        ArrayUnorderedList<User> workFirstEmpresa = new ArrayUnorderedList<>();
        //Procurar utilizadores que trabalhem na empresa 1 
        for (int i = 0; i < socialGraph.size(); i++) {
            User tempUser= (User)users[i];
            Iterator<CargosProfissionais> cargo=tempUser.getCargos().iterator();
            
            boolean add=false;
            while(cargo.hasNext() && !add){
                if(cargo.next().getEmpresa().equals(empresa1)){
                    workFirstEmpresa.addToRear(tempUser);
                    add=true;
                }
            }
            
        }
        
        Iterator<User> it=workFirstEmpresa.iterator();
        
        while(it.hasNext()){
           Iterator<User> it2= socialGraph.iteratorBFS(it.next());
            
            while(it2.hasNext()){
                User tempUser2=it2.next();
                Iterator<CargosProfissionais> cargos=tempUser2.getCargos().iterator();
                while(cargos.hasNext()){
                    if(cargos.next().getEmpresa().equals(empresa2 )){
                        return true;
                    }
                }
            }
                    
        }
        
        
        return false;
    }
    public void print() {
        socialGraph.printmatriz();
    }
}
