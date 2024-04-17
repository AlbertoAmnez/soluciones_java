package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection getConnection(String path) {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(String.format("jdbc:sqlite:%s", path));
            System.out.println("La conexion con la base de datos ha sido establecida");

        } catch (SQLException err) {
            System.out.println("Error en la conexion con la base de datos");
            err.printStackTrace();
        }
        return conexion;
    }
    
}
