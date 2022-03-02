/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.entity;

/**
 *
 * @author Domingos Dala Vunge
 */
public class Funcionario
{

    /**
     * Definir os atributos (comentário por bloco)
     */
    private int pkAfFuncionario;
    private String nome;
    private String telefone;
    private String endereco;
    private String funcao;
    private String status;
    private String email;
    private String sexo;

    //contrutor da classe
    public Funcionario()
    {
    }

    /**
     * Métodos sets e gets
     */
    public int getPkAfFuncionario()
    {
        return pkAfFuncionario;
    }

    public void setPkAfFuncionario( int pkAfFuncionario )
    {
        this.pkAfFuncionario = pkAfFuncionario;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome( String nome )
    {
        this.nome = nome;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone( String telefone )
    {
        this.telefone = telefone;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco( String endereco )
    {
        this.endereco = endereco;
    }

    public String getFuncao()
    {
        return funcao;
    }

    public void setFuncao( String funcao )
    {
        this.funcao = funcao;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus( String status )
    {
        this.status = status;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo( String sexo )
    {
        this.sexo = sexo;
    }

}
