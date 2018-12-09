package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingletonConexao {

    private Connection connection = null;
    private static String dsn = "jdbc:mysql://localhost:3306/eventosapp";
    private static String username = "root";
    private static String password = "root123";

    public  Connection getConnection() {
        if (connection != null) {
            try {
                connection = DriverManager.getConnection(dsn, username, password);
            } catch (SQLException ex) {
                System.out.println("Houve um erro ao conectar com o Banco de Dados.");
            }
        }

        return connection;
    }

    public  PreparedStatement getPreparedStatement(String sql){
        // testo se a conexão já foi criada
        if (connection == null){
            // cria a conexão
            connection = getConnection();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return connection.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Erro de sql: "+
                    e.getMessage());
        }
        return null;
    }

}