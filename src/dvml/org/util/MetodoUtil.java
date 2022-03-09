/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.util;

import java.util.Date;

/**
 *
 * @author mac
 */
public class MetodoUtil
{
    
    
    
    public static void main( String[] args )
    {
        System.out.println( "Data: " +getDataAAAAMMDDHHMMSS( new Date()) );  ;
    }
    
    public static String getDataAAAAMMDDHHMMSS(Date date)
    {
        
        //concatenação
        String data = "";
        
        int ano = date.getYear() + 1900;
        int mes = date.getMonth() + 1;
        int dia = date.getDate();
        int hora = date.getHours();
        int minuto = date.getMinutes();
        int segundo = date.getSeconds();
        
        data = ano  + "-" +mes +"-" +dia + " " +hora + ":" +minuto + ":" +segundo;
        
        return data;
        
    }
    public static String getDataAAAAMMDD(Date date)
    {
        
        //concatenação
        String data = "";
        
        int ano = date.getYear() + 1900;
        int mes = date.getMonth() + 1;
        int dia = date.getDate();
       
        
        data = ano  + "-" +mes +"-" +dia ;
        
        return data;
        
    }
    
}
