/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.controller;

import dvml.org.parc.entity.Software;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Binilson e Domingos
 */
public class SoftwareController implements EntityInterface
{

    private String INSERT = "INSERT INTO parc_software(nome, descricao) VALUES(?,?)";
    private String UPDATE = "";
    private String DLETE = "";

    private BDConexao conexao;

    public SoftwareController( BDConexao conexao )
    {
        this.conexao = conexao;
    }

    @Override
    public boolean criar( Object object )
    {
        Software software = ( Software ) object; //aplicação do casting
        PreparedStatement ps;
        Connection connection = conexao.ligarBB();
        try
        {
            ps = connection.prepareStatement( INSERT );
            ps.setString( 1, software.getNome() );
            ps.setString( 2, software.getDescricao() );

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
        SoftwareController sc = new SoftwareController( conexao );

        Software soft = new Software();
        soft.setNome( "Kitanda" );
        soft.setDescricao( "Software de Gestão Comercial" );

        if ( sc.criar( soft ) )
        {
            JOptionPane.showMessageDialog( null, "Software criado com sucesso" );
        }
        else
        {
            JOptionPane.showMessageDialog( null, "Falha ao salvar o software" );
        }
    }

}
