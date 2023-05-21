/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package model;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class Classe {
    private String nomeClasse;
    private List<Atributo> atributosList;
    private String nomeProgeto;
    private String tipoClasse;
    
    public Classe(String nomeProgeto,String tipoClasse,String nomeClasse, List<Atributo> atributosList) {
        this.nomeProgeto= nomeProgeto;
        this.nomeClasse = nomeClasse;
        this.tipoClasse = tipoClasse;
        this.atributosList = atributosList;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public String getTipoClasse() {
        return tipoClasse;
    }

    public void setTipoClasse(String tipoClasse) {
        this.tipoClasse = tipoClasse;
    }
    

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

   

    /**
     * @return the atributosList
     */
    public List<Atributo> getAtributos() {
        return atributosList;
    }

    /**
     * @param atributosList the atributosList to set
     */
    public void setAtributosList(List<Atributo> atributosList) {
        this.atributosList = atributosList;
    }

    public String getNomeProgeto() {
        return nomeProgeto;
    }

    public void setNomeProgeto(String nomeProgeto) {
        this.nomeProgeto = nomeProgeto;
    }


}
