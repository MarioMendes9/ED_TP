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
public class CargosProfissionais {
    private int ano;
    private String cargo, empresa;

    /**
     *
     */
    public CargosProfissionais() {
    }

    /**
     *
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
     * @return
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
     *
     * @return
     */
    @Override
    public String toString() {
        return "{" + "ano=" + ano + ", cargo=" + cargo + ", empresa=" + empresa + '}';
    }
    
    
}
