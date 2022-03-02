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
 * @author  Amadeu Leiria Cariango & luisa Dala
 */
public class Artigo
{
   private int pkPatArtigo;
   private String nome; 
   private Date dataFabrico;
   private Date dataExpiracao;
   private BigDecimal custoCompra;
   private String estado;
   private int fkPatCategoria;

    public Artigo()
    {
    }

    public int getPkPatArtigo()
    {
        return pkPatArtigo;
    }

    public void setPkPatArtigo( int pkPatArtigo )
    {
        this.pkPatArtigo = pkPatArtigo;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome( String nome )
    {
        this.nome = nome;
    }

    public Date getDataFabrico()
    {
        return dataFabrico;
    }

    public void setDataFabrico( Date dataFabrico )
    {
        this.dataFabrico = dataFabrico;
    }

    public Date getDataExpiracao()
    {
        return dataExpiracao;
    }

    public void setDataExpiracao( Date dataExpiracao )
    {
        this.dataExpiracao = dataExpiracao;
    }

    public BigDecimal getCustoCompra()
    {
        return custoCompra;
    }

    public void setCustoCompra( BigDecimal custoCompra )
    {
        this.custoCompra = custoCompra;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado( String estado )
    {
        this.estado = estado;
    }

    public int getFkPatCategoria()
    {
        return fkPatCategoria;
    }

    public void setFkPatCategoria( int fkPatCategoria )
    {
        this.fkPatCategoria = fkPatCategoria;
    }
   
   
   
   
   
   
   
   
   
   
   
}
