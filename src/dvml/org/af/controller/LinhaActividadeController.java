/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.af.controller;

import dvml.org.af.entity.LinhasAtividade;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DELL OPTIPLEX 7010
 */
public class LinhaActividadeController implements EntityInterface
{
    private final String INSERT = "INSERT INTO af_Linhas_Actividades(fk_af_funcionario, fk_af_actividade, funcao) VALUES(?,?,?)";
    private final BDConexao conexao;
    
   public LinhaActividadeController(BDConexao conexao)
   {
   this.conexao = conexao;
   
   }
    @Override
    public boolean criar(Object object)
    {
        LinhasAtividade lA =  ( LinhasAtividade) object;
      Connection cnn = conexao.ligarBB();
      
      try{
     PreparedStatement ps = cnn.prepareStatement(INSERT);
     
//     ps.setString(1,lA.getFuncionario() );
//     ps.setString(2,lA.getActividade() );
//     ps.setString(3,lA.getFuncao() );
//     
     ps.executeUpdate();
     
     
     return true;
      }catch(SQLException e)
      {
          e.printStackTrace();
      }
        return false;
      
    }

  
    @Override
    public boolean actualizar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
           
}
