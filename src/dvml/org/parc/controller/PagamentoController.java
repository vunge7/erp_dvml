/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvml.org.parc.controller;

import dvml.org.parc.entity.Pagamento;
import dvml.org.util.BDConexao;
import dvml.org.util.EntityInterface;
import dvml.org.util.MetodoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Abreu Francisco & Alexandre Geraldo
 */
public class PagamentoController implements EntityInterface
{

    private String INSERT = "INSERT INTO parc_pagamento(data, valor, fk_parc_adesao)VALUES (?,?,?)";
    private String UPDATE = "";
    private String DELETE = "";

    private BDConexao conexao;

    public PagamentoController( BDConexao conexao )
    {
        this.conexao = conexao;

    }

    @Override
    public boolean criar( Object object )
    {
        Pagamento pagamento = ( Pagamento ) object; //aplicação castig
        PreparedStatement ps;
        Connection connection = conexao.ligarBB();
        try
        {
            ps = connection.prepareStatement( INSERT );
            ps.setString( 1, MetodoUtil.getDataAAAAMMDDHHMMSS( pagamento.getData() ) );
            ps.setBigDecimal( 2, pagamento.getValor() );
            ps.setInt( 3, pagamento.getFkParcAdesao() );
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
        PagamentoController pc = new PagamentoController( conexao );
        Pagamento pagamento = new Pagamento();
        pagamento.setData( new Date());
        pagamento.setFkParcAdesao( 0 );
    }

}
