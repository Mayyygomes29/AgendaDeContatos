package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {
    
//CONEXÃO DO BANCO DE DADOS COM O JAVA

    public Connection conexaoBD() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/Agenda?user=root&password=Familia431";
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        return conn;
    }
}
