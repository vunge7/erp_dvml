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
 * @author Domingos Rodrigues
 */
public class Pagamento
{

    private int pkParcPagamentos;
    private Date data;
    private BigDecimal valor;
    private int fkParcAdesao;

    public Pagamento()
    {
    }

    public int getPkParcPagamentos()
    {
        return pkParcPagamentos;
    }

    public void setPkParcPagamentos( int pkParcPagamentos )
    {
        this.pkParcPagamentos = pkParcPagamentos;
    }

    public Date getData()
    {
        return data;
    }

    public void setData( Date data )
    {
        this.data = data;
    }

    public BigDecimal getValor()
    {
        return valor;
    }

    public void setValor( BigDecimal valor )
    {
        this.valor = valor;
    }

    public int getFkParcAdesao()
    {
        return fkParcAdesao;
    }

    public void setFkParcAdesao( int fkParcAdesao )
    {
        this.fkParcAdesao = fkParcAdesao;
    }
    
    

}
