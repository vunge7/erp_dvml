/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.entity;

/**
 *
 * @author Alexandre Geraldo
 */
public class Empresa
{
    /**
     * Definição dos atributos da classe Empresa
     */
   
    private int pkParcEmpresa; //atributo responsável pela chave primária
    private String nome;
    private String nif;
    private String telefone;
    private String email;
    private String endereco;
    private int fkParcTipologia;

    public Empresa()
    {
    }

    public int getPkParcEmpresa()
    {
        return pkParcEmpresa;
    }

    public void setPkParcEmpresa( int pkParcEmpresa )
    {
        this.pkParcEmpresa = pkParcEmpresa;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome( String nome )
    {
        this.nome = nome;
    }

    public String getNif()
    {
        return nif;
    }

    public void setNif( String nif )
    {
        this.nif = nif;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone( String telefone )
    {
        this.telefone = telefone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco( String endereco )
    {
        this.endereco = endereco;
    }

    public int getFkParcTipologia()
    {
        return fkParcTipologia;
    }

    public void setFkParcTipologia( int fkParcTipologia )
    {
        this.fkParcTipologia = fkParcTipologia;
    }
    
    
    
    
    
    
    
    
    
}
