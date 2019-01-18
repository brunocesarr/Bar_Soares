package com.jdenner.dao;

import com.jdenner.to.Fornecedor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Classe de acesso a dados do fornecedor
 *
 * @author Juliano
 */
public class FornecedorDAO implements IDAO<Fornecedor> {

    @Override
    public void inserir(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO `fornecedor` (`nome`, `cnpj`, `telefone`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `data_cadastro`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, fornecedor.getNome());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getTelefone());
        ps.setString(4, fornecedor.getRua());
        ps.setInt(5, fornecedor.getNumero());
        ps.setString(6, fornecedor.getComplemento());
        ps.setString(7, fornecedor.getBairro());
        ps.setString(8, fornecedor.getCidade());
        ps.setString(9, fornecedor.getEstado());
        ps.setDate(10, new Date(fornecedor.getData_cadastro().getTime()));
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE fornecedor SET `nome` = ?, `cnpj` = ?, `telefone` = ?, `rua` = ?, `numero` = ?, `complemento` = ?, `bairro` = ?, `cidade` = ?, `estado` = ?" +
                     "WHERE `codigo` = ?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, fornecedor.getNome());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getTelefone());
        ps.setString(4, fornecedor.getRua());
        ps.setInt(5, fornecedor.getNumero());
        ps.setString(6, fornecedor.getComplemento());
        ps.setString(7, fornecedor.getBairro());
        ps.setString(8, fornecedor.getCidade());
        ps.setString(9, fornecedor.getEstado());
        ps.setDate(10, new Date(fornecedor.getData_cadastro().getTime()));
        ps.setInt(11, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM fornecedor WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Fornecedor> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM fornecedor ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaFornecedors = new ArrayList();
        while (rs.next()) {
            listaFornecedors.add(novo(rs));
        }

        return listaFornecedors;
    }

    @Override
    public Fornecedor recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM fornecedor WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        if (rs.next()) {
            fornecedor = novo(rs);
        }

        return fornecedor;
    }
    
    public Fornecedor novo(ResultSet rs) throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCodigo(rs.getInt("codigo"));
        fornecedor.setNome(rs.getString("nome"));
        fornecedor.setCnpj(rs.getString("cnpj"));
        fornecedor.setTelefone(rs.getString("telefone"));
        fornecedor.setRua(rs.getString("rua"));
        fornecedor.setNumero(rs.getInt("numero"));
        fornecedor.setComplemento(rs.getString("complemento"));
        fornecedor.setBairro(rs.getString("bairro"));
        fornecedor.setCidade(rs.getString("cidade"));
        fornecedor.setEstado(rs.getString("estado"));
        return fornecedor;
    }
}
