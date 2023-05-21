/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package model;

import java.util.List;
import static view.Main.ListaAtributos.anotacao;

/**
 *
 * @author Administrator
 */
public class Atributo {
    private int idClasse;
    private String nomeAtributo;
    private String tipoAtributo;
    private final String relacionamento;
    private final String anotacao;

    public Atributo(int idClasse, String tipoAtributo, String nomeAtributo,String anotacao, String relacionamento ) {
        this.idClasse = idClasse;
        this.nomeAtributo = nomeAtributo;
        this.tipoAtributo = tipoAtributo;
        this.anotacao = anotacao;
        this.relacionamento = relacionamento;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public String getRelacionamento() {
        return relacionamento;
    }

 
    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomeAtributo() {
        return nomeAtributo;
    }

    public void setNomeAtributo(String nomeAtributo) {
        this.nomeAtributo = nomeAtributo;
    }

    public String getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(String tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

    
    
}
