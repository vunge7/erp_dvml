/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.pat.controller;

import dvml.org.pat.entity.Categoria;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Domingos Dala Vunge
 */
public class CategoriaController implements EntityInterface
{

    private final String INSERT = "INSERT INTO pat_categorias(designacao) VALUES(?)";
    private final String UPDATE = "UPDATE pat_categorias SET designacao = ? WHERE pk_pat_categoria = ?";

    private final BDConexao conexao;

    public CategoriaController( BDConexao conexao )
    {
        this.conexao = conexao;
    }

    @Override
    public boolean criar( Object object )
    {
        Categoria cat = ( Categoria ) object;
        Connection cnn = conexao.ligarBB();
        try
        {
            PreparedStatement ps = cnn.prepareStatement( INSERT );
            ps.setString( 1, cat.getDesignacao() );
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
        Categoria cat = ( Categoria ) object;

        Connection cnn = conexao.ligarBB();

        try
        {
            PreparedStatement ps = cnn.prepareStatement( UPDATE );
            ps.setString( 1, cat.getDesignacao() );
            ps.setInt( 2, cat.getPkPtCategoria() );
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
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

}
