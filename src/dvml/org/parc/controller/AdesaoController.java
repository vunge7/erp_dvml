/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.controller;

import dvml.org.parc.entity.Adesao;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import dvml.org.util.MetodoUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Domingos Dala Vunge
 */
public class AdesaoController implements EntityInterface
{

    private String INSERT = "INSERT INTO parc_adesao(data, valor_venda, valor_equivalente, pago_totalidade, fk_parc_empresa) VALUES(?,?,?,?,?)";
    private String UPDATE = "";
    private String DELETE = "";

    private BDConexao conexao;

    public AdesaoController( BDConexao conexao )
    {
        this.conexao = conexao;
    }

    @Override
    public boolean criar( Object object )
    {
      
        Adesao adesao = ( Adesao ) object; //aplicação do casting
        PreparedStatement ps;
        Connection connection = conexao.ligarBB();
        try
        {
            ps = connection.prepareStatement( INSERT );
            ps.setString( 1, MetodoUtil.getDataAAAAMMDDHHMMSS( adesao.getData() ) );
            ps.setBigDecimal( 2, adesao.getValorVenda() );
            ps.setBigDecimal( 3, adesao.getValorEquivalente() );
            ps.setBoolean( 4, adesao.isPagoTotalidade() );
            ps.setInt( 5, adesao.getFkParcEmpresa() );
            ps.executeUpdate();
            return true;

        }
        catch ( Exception e )
        {
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

}
