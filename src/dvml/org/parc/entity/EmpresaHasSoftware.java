/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.entity;

import java.util.Date;

/**
 *
 * @author Domingos Dala Vunge
 */
public class EmpresaHasSoftware
{
    private int fkParcEmpresa;
    private int fkParcSoftware;
    private Date dataAtribuicao;

    public EmpresaHasSoftware()
    {
    }

    public int getFkParcEmpresa()
    {
        return fkParcEmpresa;
    }

    public void setFkParcEmpresa( int fkParcEmpresa )
    {
        this.fkParcEmpresa = fkParcEmpresa;
    }

    public int getFkParcSoftware()
    {
        return fkParcSoftware;
    }

    public void setFkParcSoftware( int fkParcSoftware )
    {
        this.fkParcSoftware = fkParcSoftware;
    }

    public Date getDataAtribuicao()
    {
        return dataAtribuicao;
    }

    public void setDataAtribuicao( Date dataAtribuicao )
    {
        this.dataAtribuicao = dataAtribuicao;
    }
    
    
}
