package dvml.org.util;

/*----------------------------------------------
 *project: SGC
 *fle:	BDConexao.java
 *Desenvolvido por: Domingos Dala Vunge
 *----------------------------------------------*/
import javax.swing.*;
import java.sql.*;


public class BDConexao
{

    private static String URL = "";
    private final static String USER = "estagio";
    private final static String PASSWORD = "root";
    private static Connection connection;
    private Statement statement;
    private String DRIVERMYSQL8 = "com.mysql.cj.jdbc.Driver";
    public ResultSet resultset = null;
    

    public BDConexao()
    {
        LerParamentoUtil.leitor_de_parametro();
        URL = "jdbc:mysql://" + LerParamentoUtil.HOST + ":" + LerParamentoUtil.PORTA + "/erp_dvml_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        try
        {
            Class.forName( DRIVERMYSQL8 );
            connection = DriverManager.getConnection( URL, USER, PASSWORD );
            statement = connection.createStatement();

        }
        catch ( Exception e )
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog( null, "Falhou a Conexão com a Base de Dados" );
        }

    }

    public Connection ligarBB()
    {

        try
        {
            Class.forName( DRIVERMYSQL8 );
            return connection = DriverManager.getConnection( URL, USER, PASSWORD );
        }
        catch ( ClassNotFoundException | SQLException ex )
        {
            System.err.println( "Erro de conexao com a base de dados" + ex.getLocalizedMessage() );
            return null;
        }

    }

    public static BDConexao getBDConetion()
    {
        return new BDConexao();
    }

    public static Connection getConexao() throws SQLException
    {
        return DriverManager.getConnection( URL, USER, PASSWORD );
    }

    protected void finalized()
    {
        close();
    }

    public ResultSet executeQuery( String query )
    {
        ResultSet resultSet = null;
        try
        {
            resultSet = statement.executeQuery( query );

            return resultSet;
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
            showMessage( "Falha ao Carregar os Dados" );
        }

        return resultSet;
    }

    public boolean executeUpdate( String query )
    {
        ResultSet result = null;
        try
        {
            statement.executeUpdate( query );
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
            showMessage( "Falha ao Actualizar a BD" );

            return false;
        }
        return true;
    }

    public void close()
    {
        try
        {
            statement.close();
            connection.close();
        }
        catch ( SQLException sqlException )
        {
            //sqlException.printStackTrace();
            showMessage( "Erro ao Fechar a Conexao" );
        }
    }

    public static void showMessage( String mensagen )
    {
        JOptionPane.showMessageDialog( null, mensagen );

    }

    public static void main( String[] args )
    {
        BDConexao bdConexao = new BDConexao();
    }

}
