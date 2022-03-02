/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.entity;

import java.util.Date;

/**
 *
 * @author Gilberto Gaspar
 */
public class Actividade
{
    private int pkAfActividades;
    private Date data;
    private String problema;
    private String possivalResolucao;
    private int fkAfCliente;
    private int fkParcSoftware;

    public Actividade()
    {
    }

    public int getPkAfActividades()
    {
        return pkAfActividades;
    }

    public void setPkAfActividades( int pkAfActividades )
    {
        this.pkAfActividades = pkAfActividades;
    }

    public Date getData()
    {
        return data;
    }

    public void setData( Date data )
    {
        this.data = data;
    }

    public String getProblema()
    {
        return problema;
    }

    public void setProblema( String problema )
    {
        this.problema = problema;
    }

    public String getPossivalResolucao()
    {
        return possivalResolucao;
    }

    public void setPossivalResolucao( String possivalResolucao )
    {
        this.possivalResolucao = possivalResolucao;
    }

    public int getFkAfCliente()
    {
        return fkAfCliente;
    }

    public void setFkAfCliente( int fkAfCliente )
    {
        this.fkAfCliente = fkAfCliente;
    }

    public int getFkParcSoftware()
    {
        return fkParcSoftware;
    }

    public void setFkParcSoftware( int fkParcSoftware )
    {
        this.fkParcSoftware = fkParcSoftware;
    }
    
    
  
  
  
          
    
    
    
    
}
