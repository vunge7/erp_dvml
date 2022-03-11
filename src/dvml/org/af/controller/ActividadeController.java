/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.controller;

import dvml.org.af.entity.Actividade;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import dvml.org.util.MetodoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Hermenegildo Munuma, JoÃO Ndapandula, Elísio Kiteque, Genilson
 * Figueira, Eduardo Quiosa
 */
public class ActividadeController implements EntityInterface
{

    private final String INSERT = "INSERT INTO af_actividades(data, problema, possivel_resolucao, fk_af_cliente, fk_parc_software) VALUES (?,?,?,?,?)";
    private final BDConexao conexao;

    public ActividadeController( BDConexao conexao )
    {
        this.conexao = conexao;
    }

    @Override
    public boolean criar( Object object )
    {

        Actividade actividade = ( Actividade ) object;

        Connection cnn = conexao.ligarBB();

        try
        {

            PreparedStatement ps = cnn.prepareStatement( INSERT );
            ps.setString( 1, MetodoUtil.getDataAAAAMMDDHHMMSS( actividade.getData() ) );
            ps.setString( 2, actividade.getProblema() );
            ps.setString( 3, actividade.getPossivalResolucao() );
            ps.setInt( 4, actividade.getFkAfCliente() );
            ps.setInt( 5, actividade.getFkParcSoftware() );

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
        throw new UnsupportedOperationException( " Not supported yet." );
    }

    @Override
    public boolean actualizar( Object object )
    {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }
}
