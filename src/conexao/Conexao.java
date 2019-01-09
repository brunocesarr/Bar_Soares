package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private static Connection connection;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SERVIDOR = "127.0.0.1";
    private static final String PORTA = "3306";
    private static final String BANCO = "Bar_Soares";
    private static final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + BANCO;
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private Conexao() {
    }

    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o driver de conex�o\n" + e);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "N�o foi poss�vel estabalecer conex�o com o banco de dados\n" + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conex�o realizada com sucesso!");
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível encerrar a conexão - ", ex);
        }

    }

}
