package com.jdenner.to;

public class ItemPedido {

    private int codigo;
    private int cod_produto;
    private int quantidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            //  Busca o produto e verificar se há disponibildade nessa quantidade
            this.quantidade = 0;
        } else {
            this.quantidade = quantidade;
        }
    }

}
