/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_tp;

import Heap.LinkedUnorderedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 
 */
public class User {
    private int id, idade, visualizacoes;
    private String nome, email;
    private LinkedUnorderedList<String> skills;
    private LinkedUnorderedList<FormacaoAcademica> formacao;
    private LinkedUnorderedList<CargosProfissionais> cargos;
    private LinkedUnorderedList<Integer> contacts, mencoes;    

    /**
     *
     */
    public User() {
        this.formacao= new LinkedUnorderedList<>();
        this.cargos=new LinkedUnorderedList<>();
        this.skills=new LinkedUnorderedList<>();
        this.visualizacoes=1;
        this.contacts=new LinkedUnorderedList<>();
        this.mencoes=new LinkedUnorderedList<>();
    }

    /**
     *
     * @param id
     * @param idade
     * @param nome
     * @param email
     * @param visualizacoes
     */
    public User(int id, int idade, String nome, String email, int visualizacoes) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        setEmail(email);
        this.formacao= new LinkedUnorderedList<>();
        this.cargos=new LinkedUnorderedList<>();
        this.skills=new LinkedUnorderedList<>();
        this.visualizacoes=visualizacoes;
        this.contacts=new LinkedUnorderedList<>();
        this.mencoes=new LinkedUnorderedList<>();
    }
    
    /**
     *
     * @param s
     */
    public void addSkill(String s){
        skills.addToRear(s);
    }
    
    /**
     * 
     * @param c 
     */
    public void addContact(int c){
        contacts.addToRear(c);
    } 
    
    /**
     *
     * @param c
     */
    public void addMencao(int c){
        mencoes.addToRear(c);
    }
    
    /**
     *
     * @param ano
     * @param form
     */
    public void addFormacao(int ano, String form){
        FormacaoAcademica f=new FormacaoAcademica(ano, form);
        formacao.addToRear(f);
    }
    
    /**
     *
     * @param ano
     * @param cargo
     * @param empresa
     */
    public void addCargo(int ano, String cargo, String empresa){
        CargosProfissionais c=new CargosProfissionais(ano,cargo,empresa);
        cargos.addToRear(c);
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public int getIdade() {
        return idade;
    }

    /**
     *
     * @return
     */
    public int getVisualizacoes() {
        return visualizacoes;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    public LinkedUnorderedList<String> getSkills() {
        return skills;
    }

    public LinkedUnorderedList<FormacaoAcademica> getFormacao() {
        return formacao;
    }

    public LinkedUnorderedList<CargosProfissionais> getCargos() {
        return cargos;
    }

    public LinkedUnorderedList<Integer> getContacts() {
        return contacts;
    }

    public LinkedUnorderedList<Integer> getMencoes() {
        return mencoes;
    }

   
    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        if(isEmailValid(email)){
            this.email=email;
        }else
            System.out.println("Email inválido!");        
    }

    public boolean isEmailValid(String email) {
    String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
}
    
    /**
     *
     */
    public void addVisualizacao(){
        this.visualizacoes++;
    }

    /**
     *
     * @param visualizacoes
     */
    public void setVisualizacoes(int visualizacoes) {
        this.visualizacoes = visualizacoes;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
//        String s="{";
//        for(Object ob:skills){
//            if(ob!=null){
//                s+=ob + ", ";
//            }
//        }       
//        s=s.substring(0,s.length()-2);
//        s+="}";
//        String f="";
//        for(Object ob:formacao){
//            if(ob!=null){
//                f+=ob.toString();
//            }
//        }
//        String c="";
//        for(Object ob:cargos){
//            if(ob!=null){
//                c+=ob.toString();
//            }
//        }
//        String co="";
//        for(Object ob:contacts){
//            if((int)ob!=0){
//                co+=ob +" ";
//            }
//        }
//        String m="";
//        for(Object ob:mencoes){
//            if((int)ob!=0){
//                m+=ob+" ";
//            }
//        }    
        
        return "User{" + "id=" + id + "; idade=" + idade + "; nome=" + nome + "; email=" + email ;//+ "; skills=" + s + "; formacao=" + f + "; cargos=" + c + ";, contacts=" + co + "; mencoes=" + m + '}'+ "; visualizacoes=" + visualizacoes ;
    }
    
    
}
