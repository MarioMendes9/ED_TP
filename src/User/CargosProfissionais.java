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
public class CargosProfissionais {
    private int ano;
    private String cargo, empresa;

    /**
     *Construtor por defeito
     */
    public CargosProfissionais() {
    }

    /**
     *Construtor com parametros
     * @param ano 
     * @param cargo 
     * @param empresa
     */
    public CargosProfissionais(int ano, String cargo, String empresa) {
        this.ano = ano;
        this.cargo = cargo;
        this.empresa = empresa;
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
     * @return cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     *
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @return empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     *
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     *método tostring
     * @return
     */
    @Override
    public String toString() {
        return "Ano=" + ano + ", cargo=" + cargo + ", empresa=" + empresa;
    }
    
    
}
