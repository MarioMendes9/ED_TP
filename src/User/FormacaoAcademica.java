/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * 
 * @author dani_
 */
public class FormacaoAcademica {
    private int ano;
    private String formacao;

    /**
     *Construtor por defeito
     */
    public FormacaoAcademica() {
    }

    /**
     *Construtor com parametros
     * @param ano
     * @param formacao
     */
    public FormacaoAcademica(int ano, String formacao) {
        this.ano = ano;
        this.formacao = formacao;
    }

    /**
     *
     * @return ano
     */
    public int getAno() {
        return ano;
    }

    /**
     *
     * @param ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     *
     * @return formaçao
     */
    public String getFormacao() {
        return formacao;
    }

    /**
     *
     * @param formacao
     */
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    /**
     *Método tostring
     * @return
     */
    @Override
    public String toString() {
        return "Ano=" + ano + ", formacao=" + formacao;
    }
    
    
}

