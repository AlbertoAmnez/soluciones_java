package modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DirectorDAO {

    private String path;

    public DirectorDAO(String path) {
        this.path = path;
    }
    
    public ArrayList<Director> dameTodos () throws SQLException {
        ArrayList<Director> directores = new ArrayList<>();

        try {
        String sql = "Select nombre FROM directores ORDER BY nombre";

        Connection conexion = new Conexion().getConnection(path);
        PreparedStatement sentenciaSQL = conexion.prepareStatement(sql);
        ResultSet resultado = sentenciaSQL.executeQuery();

        while (resultado.next()) {
            String nombreDirector = resultado.getString("nombre");
            directores.add(new Director(nombreDirector));

        }
        resultado.close();
        sentenciaSQL.close();

    } catch (SQLException err) {
        err.printStackTrace();
    }

        return directores;
    }

    
}
