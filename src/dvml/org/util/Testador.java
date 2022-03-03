/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.util;

import dvml.org.af.controller.ClienteController;
import dvml.org.af.entity.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author mac
 */
public class Testador
{

    public static void main( String[] args )
    {
        BDConexao conexao = new BDConexao();
        ClienteController cc = new ClienteController( conexao );

        Cliente cliente = new Cliente();
        cliente.setNome( "Paulo Costa" );
        cliente.setTelefone( "923456778" );
        cliente.setEndereco( "Luanda/belas" );
        cliente.setNif( "999999999" );

        if ( cc.criar( cliente ) )
        {
            JOptionPane.showMessageDialog( null, "Cliente adicionado com sucesso na BD" );
        }
        else
        {
            JOptionPane.showMessageDialog( null, "Falha ao salvar o cliente na BD", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

}
