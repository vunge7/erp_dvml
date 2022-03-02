/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.entity;

/**
 *
 * @author Domingos Dala Vunge
 */
public class Tipologia
{
    private int pkParcTipologia;
    private String designacao;
    private double percentagem;

    public Tipologia()
    {
    }

    public int getPkParcTipologia()
    {
        return pkParcTipologia;
    }

    public void setPkParcTipologia( int pkParcTipologia )
    {
        this.pkParcTipologia = pkParcTipologia;
    }

    public String getDesignacao()
    {
        return designacao;
    }

    public void setDesignacao( String designacao )
    {
        this.designacao = designacao;
    }

    public double getPercentagem()
    {
        return percentagem;
    }

    public void setPercentagem( double percentagem )
    {
        this.percentagem = percentagem;
    }

    
    
    
    
    
    
}
