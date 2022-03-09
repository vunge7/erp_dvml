/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.util;

import dvml.org.pat.controller.CategoriaController;
import dvml.org.pat.entity.Categoria;
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
        CategoriaController catC = new CategoriaController( conexao );
        
        Categoria cat = new Categoria();
        cat.setDesignacao( "ACs" );
        cat.setPkPtCategoria( 1 );
        
        if ( catC.actualizar(cat ) )
        {
            JOptionPane.showMessageDialog( null, "Categoria actualizada com sucesso!..." );
        }
        else
        {
            JOptionPane.showMessageDialog( null, "Falhao ao actualizar a categoria" );
        }
        
    }
    
}
