/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.entity;

/**
 *
 * @author Esperanca dos santos & Horácio Nhanga
 */
public class LinhasAtividade
{
    private int fkAfFuncionario;
    private int fkAfActividade;
    private String funcao;

    public LinhasAtividade()
    {
    }

    public int getFkAfFuncionario()
    {
        return fkAfFuncionario;
    }

    public void setFkAfFuncionario( int fkAfFuncionario )
    {
        this.fkAfFuncionario = fkAfFuncionario;
    }

    public int getFkAfActividade()
    {
        return fkAfActividade;
    }

    public void setFkAfActividade( int fkAfActividade )
    {
        this.fkAfActividade = fkAfActividade;
    }

    public String getFuncao()
    {
        return funcao;
    }

    public void setFuncao( String funcao )
    {
        this.funcao = funcao;
    }
    
    
}
