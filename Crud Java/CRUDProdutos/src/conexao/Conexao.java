package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mariadb://127.0.0.1:3306/crud_produtos";
    private static final String USUARIO = "root";
    private static final String SENHA = "22659";

    public static Connection conectar() {

        try {

            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);

            System.out.println("====================================");
            System.out.println("Conectado ao banco de dados com sucesso!");
            System.out.println("====================================");

            return conn;

        } catch (SQLException e) {

            System.out.println("====================================");
            System.out.println("ERRO AO CONECTAR AO BANCO!");
            System.out.println(e.getMessage());
            System.out.println("====================================");

            return null;

        }

    }

}