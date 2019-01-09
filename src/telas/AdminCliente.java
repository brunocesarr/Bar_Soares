/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author INSS-BENEF
 */
public class AdminCliente implements TelaCliente {

    public String formataNome(String nome) {
        String[] formatar = nome.split(" ");
        nome = "";
        for (String formatar1 : formatar) {
            nome = nome.concat(formatar1.substring(0, 1).toUpperCase().concat(formatar1.substring(1)).concat(" "));
        }
        return nome.trim();
    }

    public void consultaClient() {

    }

    public void cadastrarCliente(String nome, String cpf, String telefone) {
        System.out.println(formataNome(nome));
    }

    @Override
    public void alterarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cadastrarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
