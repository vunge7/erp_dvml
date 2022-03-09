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
    private final String UPDATE = "UPDATE af_clientes SET nome = ?, nif = ?, endereco = ?, telefone = ? WHERE pk_af_cliente = ?";
    private final String DELETE = "DELETE FROM af_clientes WHERE pk_af_cliente = ?";

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
            ps.setString( 2, cliente.getNif() );
            ps.setString( 3, cliente.getEndereco() );
            ps.setString( 4, cliente.getTelefone() );

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
        //casting
        Cliente cliente = ( Cliente ) object;
        //ligar a conexão
        Connection cnn = conexao.ligarBB();

        try
        {
            System.out.println( UPDATE );
            PreparedStatement ps = cnn.prepareStatement( UPDATE );
            ps.setString( 1, cliente.getNome() );
            ps.setString( 2, cliente.getNif() );
            ps.setString( 3, cliente.getEndereco() );
            ps.setString( 4, cliente.getTelefone() );
            ps.setInt( 5, cliente.getPkAfCliente() );

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
    public boolean excluir( int id )
    {
        Connection cnn = conexao.ligarBB();

        try
        {
            PreparedStatement ps = cnn.prepareStatement( DELETE );
            ps.setInt( 1, id );

            ps.executeUpdate();
            return true;

        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        return false;
    }

}
