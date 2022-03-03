/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.controller;

import java.sql.PreparedStatement;
import java.sql.Connection;
import dvml.org.parc.entity.Empresa;
import dvml.org.util.EntityInterface;
import dvml.org.util.BDConexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Belmira Condo
 */
public class EmpresaController implements EntityInterface
{

    private String INSERT = "INSERT INTO parc_empresa(nome,nif,telefone,email,endereco,fk_parc_tipologia) VALUES(?,?,?,?,?,?)";
    private String UPDATE = "";
    private String DELETE = "";

    private BDConexao conexao;

    public EmpresaController( BDConexao conexao )
    {
        this.conexao = conexao;
    }

    @Override
    public boolean criar( Object object )
    {
        Empresa empresa = ( Empresa ) object;
        PreparedStatement ps;
        Connection connection = conexao.ligarBB();
        try
        {
            ps = connection.prepareStatement( INSERT );
            ps.setString( 1, empresa.getNome() );
            ps.setString( 2, empresa.getNif() );
            ps.setString( 3, empresa.getTelefone() );
            ps.setString( 4, empresa.getEmail() );
            ps.setString( 5, empresa.getEndereco() );
            ps.setInt( 6, empresa.getFkParcTipologia() );
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
        EmpresaController empresaController = new EmpresaController( conexao );
        Empresa empresa = new Empresa();
        empresa.setNome( "Oriente" );
        empresa.setNif( "999999999" );
        empresa.setEmail( "oriente@gmail.com" );
        empresa.setEndereco( "Fubu" );
        empresa.setTelefone( "+244 999 999 999" );
        empresa.setFkParcTipologia( 1 );

        if ( empresaController.criar( empresa ) )
        {
            JOptionPane.showMessageDialog( null, "Empresa criada com sucesso!...");
        }
        else 
        {
            JOptionPane.showMessageDialog( null, "Erro ao salvar a empresa", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
