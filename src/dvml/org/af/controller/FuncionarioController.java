/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.controller;

import dvml.org.af.entity.Funcionario;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Horácio Nhanga & Fredy Vicungo
 */
public class FuncionarioController implements EntityInterface
{

    private final String INSERT = "INSERT INTO af_funcionarios(nome,telefone, endereco,funcao,status,email,sexo) VALUES(?,?,?,?,?,?,?)";
    private final BDConexao conexao;

    public FuncionarioController( BDConexao conexao )
    {

        this.conexao = conexao;

    }

    @Override
    public boolean criar( Object object )
    {

        Funcionario funcionario = ( Funcionario ) object;

        Connection cnn = conexao.ligarBB();
        try
        {
            PreparedStatement ps = cnn.prepareStatement( INSERT );

            ps.setString( 1, funcionario.getNome() );
            ps.setString( 2, funcionario.getTelefone() );
            ps.setString( 3, funcionario.getEndereco() );
            ps.setString( 4, funcionario.getFuncao() );
            ps.setString( 5, funcionario.getStatus() );
            ps.setString( 6, funcionario.getEmail() );
            ps.setString( 7, funcionario.getSexo() );

            ps.executeUpdate();
            return true;

        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar( Object object )
    {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir( int id )
    {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

}
