/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Heap.LinkedUnorderedList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 
 * @author dani_
 */
public class User {
    private int id, idade, visualizacoes;
    private String nome, email;
    private LinkedUnorderedList<String> skills;
    private LinkedUnorderedList<FormacaoAcademica> formacao;
    private LinkedUnorderedList<CargosProfissionais> cargos;
    private LinkedUnorderedList<Integer> contacts, mencoes;    

    /**
     *Construtor por defeito que inicializa as listas
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
     *Construtor com parametros que inicializa as listas
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
     *Método que adiciona uma skill ao user
     * @param s skill
     */
    public void addSkill(String s){
        skills.addToRear(s);
    }
    
    /**
     * Método que adiciona um contacto ao user
     * @param c contacto
     */
    public void addContact(int c){
        contacts.addToRear(c);
    } 
    
    /**
     *Método que adiciona uma menção ao user
     * @param c mençao
     */
    public void addMencao(int c){
        mencoes.addToRear(c);
    }
    
    /**
     *Método que adiciona formaçao
     * @param ano
     * @param form
     */
    public void addFormacao(int ano, String form){
        FormacaoAcademica f=new FormacaoAcademica(ano, form);
        formacao.addToRear(f);
    }
    
    /**
     *Método que adiciona cargo
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
     * @return idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     *
     * @return visualizacoes
     */
    public int getVisualizacoes() {
        return visualizacoes;
    }

    /**
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return lista de skills
     */
    public LinkedUnorderedList<String> getSkills() {
        return skills;
    }

    /**
     *
     * @return lista de formações
     */
    public LinkedUnorderedList<FormacaoAcademica> getFormacao() {
        return formacao;
    }

    /**
     *
     * @return lista de cargos
     */
    public LinkedUnorderedList<CargosProfissionais> getCargos() {
        return cargos;
    }

    /**
     *
     * @return lista de contactos
     */
    public LinkedUnorderedList<Integer> getContacts() {
        return contacts;
    }

    /**
     *
     * @return lista de mençoes
     */
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

    /**
     *
     * @param email
     * @return
     */
    public boolean isEmailValid(String email) {
    String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
}
    
    /**
     *Método que adiciona uma visualização ao user
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
     *Método toString
     * @return
     */
    @Override
    public String toString() {
        
        return "User " + id + ": " + nome + ", " + email + ", " + idade +" anos, " +visualizacoes+" visualizações.";
    }

    /**
     *Método que compara dois user
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
