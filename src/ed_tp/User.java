/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_tp;

/**
 * TODOS OS USER IDS TEM QUE SER >0
 * @author dani_
 */
public class User {
    private int id, idade, visualizacoes;
    private String nome, email;
    private String[] skills;
    private FormacaoAcademica[] formacao;
    private CargosProfissionais[] cargos;
    private int[] contacts, mencoes;    

    /**
     *
     */
    public User() {
        this.formacao= new FormacaoAcademica[3];
        this.cargos=new CargosProfissionais[5];
        this.skills=new String[10];
        this.visualizacoes=1;
        this.contacts=new int[20];
        this.mencoes=new int[20];
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
        this.email = email;
        this.formacao= new FormacaoAcademica[3];
        this.cargos=new CargosProfissionais[5];
        this.visualizacoes=visualizacoes;
        this.skills=new String[10];
        this.contacts=new int[20];
        this.mencoes=new int[20];
    }
    
    /**
     *
     * @param s
     */
    public void addSkill(String s){
        if(skills[skills.length-1]!=null){
            expandSkillsCapacity();
        }
        for(int i=0;i<skills.length;i++){
            if(skills[i]==null){
                skills[i]=s;
                break;
            }
        }
    }
    
    /**
     * 
     * @param c 
     */
    public void addContact(int c){
        if(contacts[contacts.length-1]!=0){
            expandSkillsCapacity();
        }
        for(int i=0;i<contacts.length;i++){
            if(contacts[i]==0){
                contacts[i]=c;
                break;
            }
        }
    } 
    
    /**
     *
     * @param c
     */
    public void addMencao(int c){
        if(mencoes[mencoes.length-1]!=0){
            expandSkillsCapacity();
        }
        for(int i=0;i<mencoes.length;i++){
            if(mencoes[i]==0){
                mencoes[i]=c;
                break;
            }
        }
    }
    
    /**
     *
     * @param ano
     * @param form
     */
    public void addFormacao(int ano, String form){
        FormacaoAcademica f=new FormacaoAcademica(ano,form);
        if(formacao[formacao.length-1]!=null){
            expandFormacaoCapacity();
        }
        for(int i=0;i<formacao.length;i++){
            if(formacao[i]==null){
                formacao[i]=f;
                break;
            }
        }
    }
    
    /**
     *
     * @param ano
     * @param cargo
     * @param empresa
     */
    public void addCargo(int ano, String cargo, String empresa){
        CargosProfissionais c=new CargosProfissionais(ano,cargo,empresa);
        if(cargos[cargos.length-1]!=null){
            expandCargosCapacity();
        }
        for(int i=0;i<cargos.length;i++){
            if(cargos[i]==null){
                cargos[i]=c;
                break;
            }
        }
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

    /**
     *
     * @return
     */
    public String[] getSkills() {
        return skills;
    }

    /**
     *
     * @return
     */
    public FormacaoAcademica[] getFormacao() {
        return formacao;
    }

    /**
     *
     * @return
     */
    public CargosProfissionais[] getCargos() {
        return cargos;
    }

    /**
     *
     * @return
     */
    public int[] getContacts() {
        return contacts;
    }

    /**
     *
     * @return
     */
    public int[] getMencoes() {
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
        this.email = email;
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
     */
    public void expandContactCapacity(){
       int[] array = new int[this.contacts.length * 2];
        /**
         * Copia os valores para o novo vetor
         */
        for (int i = 0; i < this.contacts.length; i++) {
            array[i] = this.contacts[i];
        }
        contacts=array;
   }
   
    /**
     *
     */
    public void expandMencoesCapacity(){
       int[] array = new int[this.mencoes.length * 2];
        /**
         * Copia os valores para o novo vetor
         */
        for (int i = 0; i < this.mencoes.length; i++) {
            array[i] = this.mencoes[i];
        }
        mencoes=array;
   }
   
    /**
     *
     */
    public void expandSkillsCapacity(){
       String[] array = new String[this.skills.length * 2];
        /**
         * Copia os valores para o novo vetor
         */
        for (int i = 0; i < this.skills.length; i++) {
            array[i] = this.skills[i];
        }
        skills=array;
   }
    
    /**
     *
     */
    public void expandCargosCapacity(){
       CargosProfissionais[] array = (CargosProfissionais[])(new Object[this.cargos.length * 2]);
        /**
         * Copia os valores para o novo vetor
         */
        for (int i = 0; i < this.cargos.length; i++) {
            array[i] = this.cargos[i];
        }
        cargos=array;
   }
    
    /**
     *
     */
    public void expandFormacaoCapacity(){
       FormacaoAcademica[] array = (FormacaoAcademica[])(new Object[this.formacao.length * 2]);
        /**
         * Copia os valores para o novo vetor
         */
        for (int i = 0; i < this.formacao.length; i++) {
            array[i] = this.formacao[i];
        }
        formacao=array;
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
