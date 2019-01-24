/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_tp;

/**
 *
 * @author dani_
 */
public class FormacaoAcademica {
    private int ano;
    private String formacao;

    public FormacaoAcademica() {
    }

    public FormacaoAcademica(int ano, String formacao) {
        this.ano = ano;
        this.formacao = formacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "{" + "ano=" + ano + ", formacao=" + formacao + '}';
    }
    
    
}

