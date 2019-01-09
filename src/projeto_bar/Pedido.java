package projeto_bar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int codigo;
    private int cod_cliente;
    private Date data;
    private List<ItemPedido> lista_produto;
    private double valor_total;

    public Pedido() {
        this.lista_produto = new ArrayList<>();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getLista_produto() {
        return lista_produto;
    }

    public void setLista_produto(List<ItemPedido> lista_produto) {
        this.lista_produto = lista_produto;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        if(this.lista_produto.isEmpty()){
            this.valor_total = 0;
        } else {
            int i = 0;
            this.valor_total = 0;
            //  Valor += produto.valor_venda * lista_produto.quantidade;
            while(i < this.lista_produto.size()) {
                this.valor_total += 0;
            }
        }
    }
    
    
}
