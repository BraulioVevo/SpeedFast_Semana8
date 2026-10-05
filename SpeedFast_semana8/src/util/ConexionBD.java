package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/speedfast_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USUARIO = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de MySQL (com.mysql.cj.jdbc.Driver).");
        }
    }

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(

                URL,
                USUARIO,
                PASSWORD);
    }
}
