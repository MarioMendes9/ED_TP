/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialGraph;

import User.CargosProfissionais;
import User.FormacaoAcademica;
import User.User;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * 
 */
public class UserInformation {

    private String file;
    private User[] users;

    /**
     *
     * @param file
     * @param users
     */
    public UserInformation(String file) {
        this.file = file;
        this.users = new User[20];
    }

    /**
     *
     * @throws IOException
     * @throws ParseException
     */
    public void loadInfo() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonobj = (JSONObject) parser.parse(new FileReader(file));
        JSONArray array = (JSONArray) jsonobj.get("grafoSocial");
        for (Object obj : array) {
            JSONObject obj1 = (JSONObject) obj;
            User u = new User((int) (long) (obj1.get("id")), (int) (long) (obj1.get("idade")), (String) (obj1.get("nome")), (String) (obj1.get("email")), (int) (long) (obj1.get("visualizacoes")));
            JSONArray arrayf = (JSONArray) obj1.get("formacaoAcademica");
            for (Object ob : arrayf) {
                JSONObject objf = (JSONObject) ob;
                u.addFormacao((int) (long) objf.get("ano"), (String) objf.get("formacao"));
            }
            JSONArray arrayca = (JSONArray) obj1.get("cargosProfissionais");
            for (Object ob : arrayca) {
                JSONObject objc = (JSONObject) ob;
                u.addCargo((int) (long) objc.get("ano"), (String) objc.get("cargo"), (String) objc.get("empresa"));
            }
            JSONArray arrayco = (JSONArray) obj1.get("contacts");
            for (Object ob : arrayco) {
                JSONObject objc = (JSONObject) ob;
                u.addContact((int) (long) objc.get("userid"));
            }
            JSONArray arraym = (JSONArray) obj1.get("mencoes");
            for (Object ob : arraym) {
                JSONObject objm = (JSONObject) ob;
                u.addMencao((int) (long) objm.get("userid"));
            }
            JSONArray arrays = (JSONArray) obj1.get("skills");
            for (int i = 0; i < arrays.size(); i++) {
                u.addSkill((String) arrays.get(i));
            }
            int i = 0;
            while (users[i] != null) {
                i++;
            }
            users[i] = u;
        }
//        for (Object obj : users) {
//            if (obj != null) {
//                System.out.println(obj.toString());
//            }
//        }
        System.out.println("Ficheiro carregado");
    }

    /**
     *
     * @param u
     * @throws IOException
     */
    public void saveInfo(User[] u) throws IOException {
        this.users=u;
        JSONArray array = new JSONArray();
        int i = 0;
        while (users[i] != null) {
            JSONObject obj = new JSONObject();
            JSONArray arrayfor = new JSONArray();
            Iterator<FormacaoAcademica> it3=users[i].getFormacao().iterator();
            while(it3.hasNext()){
                FormacaoAcademica f=it3.next();
                if (f != null) {
                    JSONObject o = new JSONObject();
                    o.put("ano", f.getAno());
                    o.put("formacao", f.getFormacao());
                    arrayfor.add(o);
                }
            }
            JSONArray arraycar = new JSONArray();
            Iterator<CargosProfissionais> it2=users[i].getCargos().iterator();
            while(it2.hasNext()){
                CargosProfissionais c=it2.next();
                if (c != null) {
                    JSONObject o = new JSONObject();
                    o.put("ano", c.getAno());
                    o.put("cargo", c.getCargo());
                    o.put("empresa", c.getEmpresa());
                    arraycar.add(o);
                }
            }
            JSONArray arraysk = new JSONArray();
            Iterator<String> it4=users[i].getSkills().iterator();
            while(it4.hasNext()){
                String s=it4.next();
                if (s != null) {
                    arraysk.add(s);
                }
            }
            JSONArray arraycont = new JSONArray();
            Iterator<Integer> it0=users[i].getContacts().iterator();
            while(it0.hasNext()){
                    JSONObject o = new JSONObject();
                    o.put("userid", it0.next());
                    arraycont.add(o);                
            }
            JSONArray arraymen = new JSONArray();
            Iterator<Integer> it1=users[i].getMencoes().iterator();
            while(it1.hasNext()){
                    JSONObject o = new JSONObject();
                    o.put("userid", it1.next());
                    arraymen.add(o);
            }
            obj.put("id", users[i].getId());
            obj.put("nome", users[i].getNome());
            obj.put("idade", users[i].getIdade());
            obj.put("email", users[i].getEmail());
            obj.put("formacaoAcademica", arrayfor);
            obj.put("cargosProfissionais", arraycar);
            obj.put("skills", arraysk);
            obj.put("contacts", arraycont);
            obj.put("mencoes", arraymen);
            obj.put("visualizacoes", users[i].getVisualizacoes());
            array.add(obj);
            i++;
        }
        JSONObject obje = new JSONObject();
        obje.put("grafoSocial", array);
        FileWriter ficheiro = new FileWriter(file);
        ficheiro.write(obje.toJSONString());
        ficheiro.close();
        System.out.println("ficheiro guardado");

    }

    public void setFile(String file) {
        this.file = file;
    }

    public User[] getUsers() {
        return users;
    }
    
    
}
