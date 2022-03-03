/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.controller;

import dvml.org.af.entity.Cliente;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Domingos Dala Vunge
 */
public class ClienteController implements EntityInterface
{

    private final String INSERT = "INSERT INTO af_clientes(nome, nif, endereco, telefone) VALUES(?,?,?,?)";
    private final BDConexao conexao;

    public ClienteController( BDConexao conexao )
    {
        this.conexao = conexao;
    }

    @Override
    public boolean criar( Object object )
    {
        //casting
        Cliente cliente = ( Cliente ) object;
        //ligar a conexão
        Connection cnn = conexao.ligarBB();

        try
        {
            //preparar o sql 
            PreparedStatement ps = cnn.prepareStatement( INSERT );
            /**
             * Definição dos ? na query
             */
            ps.setString( 1, cliente.getNome() );
            ps.setString( 2, cliente.getNif());
            ps.setString( 3, cliente.getEndereco());
            ps.setString( 4, cliente.getTelefone());
            
            //executa a query
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
