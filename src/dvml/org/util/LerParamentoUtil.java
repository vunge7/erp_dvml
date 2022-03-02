/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Domingos Dala Vunge
 */
public class LerParamentoUtil
{

    public static String HOST = "";
    public static String PORTA = "";
    public static String DRIVER = "";
    public static String USER = "";
    public static String PASSWORD = "";
    public static String JDBC_URL = "";

    public static void main( String[] args )
    {
        leitor_de_parametro();
    }

    public static void leitor_de_parametro()
    {
        Vector<String> vector = new Vector<>();
        try
        {
            BufferedReader buffRead = new BufferedReader( new FileReader( "documentos/parametrizacao.txt" ) );
            String linha = "";
            while ( true )
            {
                if ( linha != null )
                {
                    vector.add( linha );
//                    System.out.println( linha );
                }
                else
                {
                    break;
                }
                linha = buffRead.readLine();
            }
            buffRead.close();

        }
        catch ( IOException e )
        {
        }

        if ( vector.size() > -1 )
        {
            System.out.println( vector.toString() );
            HOST = vector.get( 1 );
            PORTA = vector.get( 2 );
        }
    }

}
