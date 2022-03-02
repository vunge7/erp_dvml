/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Belmira Condo
 */
public class Adesao
{
   private int pkParcAdesao;
   private Date data;
   private BigDecimal valorVenda;
   private BigDecimal valorEquivalente;
   private boolean pagoTotalidade;
   private int fkParcEmpresa;

    public Adesao()
    {
    }

    public int getPkParcAdesao()
    {
        return pkParcAdesao;
    }

    public void setPkParcAdesao( int pkParcAdesao )
    {
        this.pkParcAdesao = pkParcAdesao;
    }

    public Date getData()
    {
        return data;
    }

    public void setData( Date data )
    {
        this.data = data;
    }

    public BigDecimal getValorVenda()
    {
        return valorVenda;
    }

    public void setValorVenda( BigDecimal valorVenda )
    {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getValorEquivalente()
    {
        return valorEquivalente;
    }

    public void setValorEquivalente( BigDecimal valorEquivalente )
    {
        this.valorEquivalente = valorEquivalente;
    }

    public boolean isPagoTotalidade()
    {
        return pagoTotalidade;
    }

    public void setPagoTotalidade( boolean pagoTotalidade )
    {
        this.pagoTotalidade = pagoTotalidade;
    }

    public int getFkParcEmpresa()
    {
        return fkParcEmpresa;
    }

    public void setFkParcEmpresa( int fkParcEmpresa )
    {
        this.fkParcEmpresa = fkParcEmpresa;
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
}
