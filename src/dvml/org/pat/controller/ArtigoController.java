/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.pat.controller;

import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import dvml.org.pat.entity.Artigo;
import dvml.org.util.MetodoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Stella Diniz, Alquenia Samba,Luísa Dala, Amadeu Cariango, Gabriel
 * Gomes,Elídio Luembe
 */
public class ArtigoController implements EntityInterface
{

    private final String INSERT = "INSERT INTO pat_artigos(nome, data_fabrico, data_expiracao, custo_compra, estado, fk_pat_categoria)VALUES (?,?,?,?,?,?)";
    private final BDConexao conexao;

    public ArtigoController( BDConexao conexao )
    {
        this.conexao = conexao;
    }

    @Override
    public boolean criar( Object object )
    {
        Artigo art = ( Artigo ) object;
        Connection cnn = conexao.ligarBB();
        try
        {
            PreparedStatement ps = cnn.prepareStatement( INSERT );

            //aaaa-mm-dd
            ps.setString( 1, art.getNome() );
            ps.setString( 2, MetodoUtil.getDataAAAAMMDD( art.getDataFabrico() ) );
            ps.setString( 3, MetodoUtil.getDataAAAAMMDD( art.getDataExpiracao() ) );
            ps.setBigDecimal( 4, art.getCustoCompra() );
            ps.setString( 5, art.getEstado() );
            ps.setInt( 6, art.getFkPatCategoria() );
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
