package com.jdenner.dao;

import com.jdenner.to.Cliente;
import com.jdenner.to.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Classe de acesso a dados do produto
 *
 * @author Juliano
 */
public class ProdutoDAO implements IDAO<Produto> {

    @Override
    public void inserir(Produto produto) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO produto (`nome`, `valor_compra`, `valor_venda`, `quant_estoque`) VALUES (?, ?, ?, 0)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setDouble(2, produto.getValor_compra());
        ps.setDouble(3, produto.getValor_venda());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Produto produto) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE produto SET `nome`=?, `valor_compra`=?, `valor_venda`=? WHERE codigo=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setDouble(2, produto.getValor_compra());
        ps.setDouble(3, produto.getValor_venda());
        ps.setInt(4, produto.getCodigo());
        ps.execute();
        c.confirmar();
    }

    public void entradaEstoque(Conexao c, int codigo, int quantidade) throws Exception {
        String sql = "UPDATE produto SET `quant_estoque`= `quant_estoque`  + ? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, quantidade);
        ps.setInt(2, codigo);
        ps.execute();
    }

    public void saidaEstoque(Conexao c, int codigo, int quantidade) throws Exception {
        String sql = "UPDATE produto SET `quant_estoque`= `quant_estoque`  - ? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, quantidade);
        ps.setInt(2, codigo);
        ps.execute();
    }

    @Override
    public void excluir(Produto produto) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM produto WHERE `codigo`=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, produto.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Produto> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM produto ORDER BY `nome`";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaProdutos = new ArrayList();
        while (rs.next()) {
            listaProdutos.add(novo(rs));
        }

        return listaProdutos;
    }

    @Override
    public Produto recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM produto WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Produto produto = new Produto();
        if (rs.next()) {
            produto = novo(rs);
        }

        return produto;
    }
    
    public Produto novo(ResultSet rs) throws Exception {
        Produto produto = new Produto();
        produto.setCodigo(rs.getInt("codigo"));
        produto.setNome(rs.getString("nome"));
        produto.setValor_compra(rs.getDouble("valor_compra"));
        produto.setValor_venda(rs.getDouble("valor_venda"));
        return produto;
    }
}
