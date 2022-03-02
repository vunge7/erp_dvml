/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.entity;

import java.math.BigDecimal;

/**
 *
 * @author Domingos Dala Vunge
 */
public class LinhasAdesao
{
    private int pkParcLinhasAdesao;
    private int fkParcSoftware;
    private int fkParcAdesao;
    private BigDecimal valorPercentagem;

    public LinhasAdesao()
    {
    }

    public int getPkParcLinhasAdesao()
    {
        return pkParcLinhasAdesao;
    }

    public void setPkParcLinhasAdesao( int pkParcLinhasAdesao )
    {
        this.pkParcLinhasAdesao = pkParcLinhasAdesao;
    }

    public int getFkParcSoftware()
    {
        return fkParcSoftware;
    }

    public void setFkParcSoftware( int fkParcSoftware )
    {
        this.fkParcSoftware = fkParcSoftware;
    }

    public int getFkParcAdesao()
    {
        return fkParcAdesao;
    }

    public void setFkParcAdesao( int fkParcAdesao )
    {
        this.fkParcAdesao = fkParcAdesao;
    }

    public BigDecimal getValorPercentagem()
    {
        return valorPercentagem;
    }

    public void setValorPercentagem( BigDecimal valorPercentagem )
    {
        this.valorPercentagem = valorPercentagem;
    }
    
    
    
    
}
