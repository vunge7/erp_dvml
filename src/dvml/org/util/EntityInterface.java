/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.util;

/**
 *
 * @author Domingos Dala Vunge
 */
public interface EntityInterface
{
    public boolean criar(Object object);
    public boolean actualizar(Object object);
    public boolean excluir(int id);
    
}
