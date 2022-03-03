/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.controller;

import dvml.org.parc.entity.Tipologia;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Domingos Dala Vunge
 */
public class TipologiaController implements EntityInterface
{

    private String INSERT = "INSERT INTO parc_tipologia(designacao, percentagem) VALUES(?,?)";
    private String UPDATE = "";
    private String DELETE = "";

    private BDConexao conexao;

    public TipologiaController( BDConexao conexao )
    {
        this.conexao = conexao;
    }

    @Override
    public boolean criar( Object object )
    {

        Tipologia tipologia = ( Tipologia ) object; //aplicação do casting
        PreparedStatement ps;
        Connection connection = conexao.ligarBB();
        try
        {
            ps = connection.prepareStatement( INSERT );
            ps.setString( 1, tipologia.getDesignacao() );
            ps.setDouble( 2, tipologia.getPercentagem() );
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

    public static void main( String[] args )
    {
        BDConexao conexao = new BDConexao();
        TipologiaController tp = new TipologiaController( conexao );
        Tipologia tipologia = new Tipologia();

        tipologia.setDesignacao( "Grupo A" );
        tipologia.setPercentagem( 50 );

        if ( tp.criar( tipologia ) )
        {
            JOptionPane.showMessageDialog( null, "Criado com sucesso!...");
        }
        else
        {
            JOptionPane.showMessageDialog( null, "Erro ao salvar no banco de dados");
        }
    }

}
