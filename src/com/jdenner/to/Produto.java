package com.jdenner.to;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe contendo os dados do produto
 *
 * @author Juliano
 */
public class Produto {

    private int codigo;
    private String nome;
    private double valor_compra;
    private double valor_venda;
    private int quant_estoque;
    private List<Integer> fornecedores;

    public Produto() {
        this.codigo = 0;
        this.nome = "";
        this.valor_compra = 0.0;
        this.valor_venda = 0.0;
        this.quant_estoque = 0;
        this.fornecedores = new ArrayList<>();
    }

    public Produto(int codProduto) {
        this.codigo = codProduto;
        this.nome = "";
        this.valor_compra = 0.0;
        this.valor_venda = 0.0;
        this.quant_estoque = 0;
        this.fornecedores = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(double valor_compra) {
        if (valor_compra < 0) {
            this.valor_compra = 0;
        } else {
            this.valor_compra = valor_compra;
        }
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        if (valor_venda < 0) {
            this.valor_venda = 0;
        } else {
            this.valor_venda = valor_venda;
        }
    }

    public int getQuant_estoque() {
        return quant_estoque;
    }

    public void setQuant_estoque(int quant_estoque) {
        if (quant_estoque < 0) {
            this.quant_estoque = 0;
        } else {
            this.quant_estoque = quant_estoque;
        }
    }

    public List<Integer> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Integer> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public boolean alteraEstoque(int quant) {
        if (quant < 0 && this.quant_estoque < quant * (-1)) {
            return false;
        } else {
            this.quant_estoque += quant;
            return true;
        }
    }
    
    public void addFornecedor(int codigo){
        if(codigo >= 1) {
            this.fornecedores.add(codigo);
        }
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            Produto p = (Produto) o;
            if (p.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
