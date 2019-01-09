package projeto_bar;

import java.util.Date;

public class Fornecedor {

    private int codigo;
    private String nome;
    private String cnpj;
    private String telefone;
    private String endereco;
    private Date data_cadastro;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        if (data_cadastro.before(new Date())) {
            this.data_cadastro = new Date();
        } else {
            this.data_cadastro = data_cadastro;
        }
    }

}
