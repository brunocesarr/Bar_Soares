package com.jdenner.dao;

import com.jdenner.to.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

/**
 * Classe de acesso a dados do cliente
 *
 * @author Juliano
 */
public class ClienteDAO implements IDAO<Cliente> {

    @Override
    public void inserir(Cliente cliente) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO `cliente` (`nome`, `cpf`, `telefone`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `data_cadastro`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getTelefone());
        ps.setString(4, cliente.getRua());
        ps.setInt(5, cliente.getNumero());
        ps.setString(6, cliente.getComplemento());
        ps.setString(7, cliente.getBairro());
        ps.setString(8, cliente.getCidade());
        ps.setString(9, cliente.getEstado());
        ps.setDate(10, new Date(cliente.getData_cadastro().getTime()));
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Cliente cliente) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE cliente SET `nome` = ?, `cpf` = ?, `telefone` = ?, `rua` = ?, `numero` = ?, `complemento` = ?, `bairro` = ?, `cidade` = ?, `estado` = ?"
                + " WHERE `codigo` = ?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getTelefone());
        ps.setString(4, cliente.getRua());
        ps.setInt(5, cliente.getNumero());
        ps.setString(6, cliente.getComplemento());
        ps.setString(7, cliente.getBairro());
        ps.setString(8, cliente.getCidade());
        ps.setString(9, cliente.getEstado());
        ps.setInt(10, cliente.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Cliente cliente) throws Exception {
        Conexao c = new Conexao();
        
        String sql = "DELETE FROM cliente WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, cliente.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Cliente> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM cliente ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaClientes = new ArrayList();
        while (rs.next()) {
            listaClientes.add(novo(rs));
        }

        return listaClientes;
    }

    @Override
    public Cliente recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM cliente WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Cliente cliente = new Cliente();
        if (rs.next()) {
            cliente = novo(rs);
        }

        return cliente;
    }
    
    public Cliente novo(ResultSet rs) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodigo(rs.getInt("codigo"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setRua(rs.getString("rua"));
        cliente.setNumero(rs.getInt("numero"));
        cliente.setComplemento(rs.getString("complemento"));
        cliente.setBairro(rs.getString("bairro"));
        cliente.setCidade(rs.getString("cidade"));
        cliente.setEstado(rs.getString("estado"));
        return cliente;
    }
}
