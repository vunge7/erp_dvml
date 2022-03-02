/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.controller;

import dvml.org.af.entity.Actividade;
import dvml.org.util.EntityInterface;
import java.util.Date;

/**
 *
 * @author mac
 */
public class ActividadeController implements EntityInterface
{

    public ActividadeController()
    {
    }
    

    @Override
    public boolean criar( Object object )
    {
        Actividade actividade = ( Actividade ) object;
        
        System.out.println( "Problema: " +actividade.getProblema() );
        
        return true;
    }

    public static void main( String[] args )
    {
        ActividadeController controller = new ActividadeController();
        Actividade actividade = new Actividade();
        actividade.setProblema( "Exemplo problema");
        actividade.setData( new Date() );

        controller.criar( actividade );

    }
}
