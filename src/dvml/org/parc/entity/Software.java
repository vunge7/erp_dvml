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
public class Software
{
    private int pkParcSoftware;
    private String nome, descricao;

    public Software()
    {
    }

    public int getPkParcSoftware()
    {
        return pkParcSoftware;
    }

    public void setPkParcSoftware( int pkParcSoftware )
    {
        this.pkParcSoftware = pkParcSoftware;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome( String nome )
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao( String descricao )
    {
        this.descricao = descricao;
    }
    
    
    
}
