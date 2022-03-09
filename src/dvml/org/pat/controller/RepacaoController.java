/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.pat.controller;

import dvml.org.pat.entity.Reparacao;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import dvml.org.util.MetodoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Sandro Lamba, Jose Valente, Júlia Kitque, Antonia Francisco,
 * ALexandre Marcos
 */
public class RepacaoController implements EntityInterface
{
    
    private final String INSERT = "INSERT INTO pat_repacoes (data,nome_responsavel,custo) VALUES (?,?,?)";
    private final BDConexao conexao;
    
    public RepacaoController( BDConexao conexao )
    {
        this.conexao = conexao;
    }
    
    @Override
    public boolean criar( Object object )
    {
        Reparacao rep = ( Reparacao ) object;
        Connection cnn = conexao.ligarBB();
        try
        {
            PreparedStatement ps = cnn.prepareStatement( INSERT );
            ps.setString( 1, MetodoUtil.getDataAAAAMMDDHHMMSS( rep.getData() ) );
            ps.setString( 2, rep.getNomeResponsavel() );
            ps.setBigDecimal( 3, rep.getCusto() );
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
