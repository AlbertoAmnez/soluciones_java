package modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

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

    public Director buscaPorID(int id) {

        Director directorID = null;

        try{

        String sql = "Select id, nombre FROM directores WHERE id = ?";

        Connection conexion = new Conexion().getConnection(path); 
        PreparedStatement sentenciaSQL = conexion.prepareStatement(sql); 
        sentenciaSQL.setInt(1, id);  
        ResultSet resultado = sentenciaSQL.executeQuery();
        
        if (resultado.next()) {

            int directorId = resultado.getInt("id");
            String nombreDirector = resultado.getString("nombre");
            directorID = new Director(nombreDirector);
            directorID.setId(directorId);
            
        }

        resultado.close();
        sentenciaSQL.close();
        conexion.close();

        } catch (SQLException err) {
        err.printStackTrace();

        }
       
        return directorID;

    }  
    
    public Director buscaPorNombre(String nombre) {

        Director porNombre = null;

        try{

        String sql = "Select nombre FROM directores WHERE nombre = ?";

        Connection conexion = new Conexion().getConnection(path); 
        PreparedStatement sentenciaSQL = conexion.prepareStatement(sql); 
        sentenciaSQL.setString(1, nombre); 
        ResultSet resultado = sentenciaSQL.executeQuery();
        
        if (resultado.next()) {

            int directorId = resultado.getInt("id");
            String nombreDirector = resultado.getString("nombre");
            porNombre = new Director(nombreDirector);
            porNombre.setId(directorId);
            
        }

        resultado.close();
        sentenciaSQL.close();
        conexion.close();

        } catch (SQLException err) {
        err.printStackTrace();

        }
       
        return porNombre;

    } 

    public void eliminarID(int id) {


        try{

        String sql = "Delete FROM directores WHERE id = ?";

        Connection conexion = new Conexion().getConnection(path); 
        PreparedStatement sentenciaSQL = conexion.prepareStatement(sql); 
        sentenciaSQL.setInt(1, id);  
        int filasEliminadas = sentenciaSQL.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Se ha borrado el director con ID " + id);
            } else {
                System.out.println("No se encontró ningún director con el ID " + id + " para borrar.");
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }
}
