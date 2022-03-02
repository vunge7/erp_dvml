/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.pat.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Misael Gomes Cassoma
 */
public class Reparacao
{
    private int pkPatReparacao;
    private Date data;
    private String nomeResponsavel;
    private BigDecimal custo;

    public Reparacao()
    {
    }

    public int getPkPatReparacao()
    {
        return pkPatReparacao;
    }

    public void setPkPatReparacao( int pkPatReparacao )
    {
        this.pkPatReparacao = pkPatReparacao;
    }

    public Date getData()
    {
        return data;
    }

    public void setData( Date data )
    {
        this.data = data;
    }

    public String getNomeResponsavel()
    {
        return nomeResponsavel;
    }

    public void setNomeResponsavel( String nomeResponsavel )
    {
        this.nomeResponsavel = nomeResponsavel;
    }

    public BigDecimal getCusto()
    {
        return custo;
    }

    public void setCusto( BigDecimal custo )
    {
        this.custo = custo;
    }
    
    
    
    
}
