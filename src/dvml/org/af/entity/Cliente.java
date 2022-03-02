/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.entity;

/**
 *
 * @author Fredy Vicungo
 */
public class Cliente
{
    private int pkAfCliente;
    private String nome;
    private String nif;
    private String endereco;
    private String telefone;

    public Cliente()
    {
    }

    public int getPkAfCliente()
    {
        return pkAfCliente;
    }

    public void setPkAfCliente( int pkAfCliente )
    {
        this.pkAfCliente = pkAfCliente;
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

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco( String endereco )
    {
        this.endereco = endereco;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone( String telefone )
    {
        this.telefone = telefone;
    }
    
    
    
            
            
            
            
            
            
            
            
            
            
            
            
            
}
