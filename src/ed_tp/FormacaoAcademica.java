/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_tp;

/**
 *
 * 
 */
public class FormacaoAcademica {
    private int ano;
    private String formacao;

    /**
     *
     */
    public FormacaoAcademica() {
    }

    /**
     *
     * @param ano
     * @param formacao
     */
    public FormacaoAcademica(int ano, String formacao) {
        this.ano = ano;
        this.formacao = formacao;
    }

    /**
     *
     * @return
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
     * @return
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
     *
     * @return
     */
    @Override
    public String toString() {
        return "Ano=" + ano + ", formacao=" + formacao;
    }
    
    
}

