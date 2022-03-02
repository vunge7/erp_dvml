/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.pat.entity;

import java.math.BigDecimal;

/**
 *
 * @author Stella Diniz & Antónia Francisco
 */
public class LinhaReparacao
{
    private int fkPatArtigo;
    private int fkPatReparacao;
    private int qtd;
    private BigDecimal subTotal;

    public LinhaReparacao()
    {
    }

    public int getFkPatArtigo()
    {
        return fkPatArtigo;
    }

    public void setFkPatArtigo( int fkPatArtigo )
    {
        this.fkPatArtigo = fkPatArtigo;
    }

    public int getFkPatReparacao()
    {
        return fkPatReparacao;
    }

    public void setFkPatReparacao( int fkPatReparacao )
    {
        this.fkPatReparacao = fkPatReparacao;
    }

    public int getQtd()
    {
        return qtd;
    }

    public void setQtd( int qtd )
    {
        this.qtd = qtd;
    }

    public BigDecimal getSubTotal()
    {
        return subTotal;
    }

    public void setSubTotal( BigDecimal subTotal )
    {
        this.subTotal = subTotal;
    }
    
    
    
    
    
}
