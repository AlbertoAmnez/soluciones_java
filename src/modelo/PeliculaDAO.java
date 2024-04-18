package modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class PeliculaDAO {

    private String path;

    public PeliculaDAO(String path) {
        this.path = path;
    }
    
    public ArrayList<Pelicula> dameTodas () throws SQLException {
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        try {
        String sql = "SELECT p.titulo, p.año, p.url_caratula, p.id_genero, p.es_animacion, d.nombre AS nombre_director " +
                     "FROM peliculas p " +
                     "INNER JOIN directores d ON p.id_director = d.id " +
                     "ORDER BY p.id_genero, p.año DESC, p.titulo";

        Connection conexion = new Conexion().getConnection(path);
        PreparedStatement sentenciaSQL = conexion.prepareStatement(sql);
        ResultSet resultado = sentenciaSQL.executeQuery();

        

        while (resultado.next()) {

            String tituloPelicula = resultado.getString("titulo");
            int id_director = resultado.getInt("id_director");
            int año = resultado.getInt("año");
            String url_caratula = resultado.getString("url_caratula");
            int id_genero = resultado.getInt("id_genero");
            boolean animacion = resultado.getInt("es_animacion") != 0;
            Genero genero = Genero.values()[id_genero - 1];

            DirectorDAO directorDAO = new DirectorDAO(path);
            Director director = directorDAO.buscaPorID(id_director);

            Pelicula pelicula = new Pelicula(tituloPelicula, director, año, url_caratula, genero, animacion);
            peliculas.add(pelicula);

        }
        resultado.close();
        sentenciaSQL.close();

    } catch (SQLException err) {
        err.printStackTrace();
    }

        return peliculas;
    }

    public Pelicula buscaPorID(int id) {

        Pelicula peliculaID = null;
        String sqlPelicula = "SELECT * FROM peliculas WHERE id = ?";
        String sqlDirector = "SELECT nombre FROM directores WHERE id = ?";
        try {
            Connection conexion = new Conexion().getConnection(path); 
            
            // Obtener información básica de la película
            PreparedStatement sentenciaSQLPelicula = conexion.prepareStatement(sqlPelicula); 
            sentenciaSQLPelicula.setInt(1, id);  
            ResultSet resultadoPelicula = sentenciaSQLPelicula.executeQuery();
            
            if (resultadoPelicula.next()) {
                String tituloPelicula = resultadoPelicula.getString("titulo");
                int id_director = resultadoPelicula.getInt("id_director");
                int año = resultadoPelicula.getInt("año");
                String url_caratula = resultadoPelicula.getString("url_caratula");
                int id_genero = resultadoPelicula.getInt("id_genero");
                boolean animacion = resultadoPelicula.getInt("es_animacion") != 0;
                Genero genero = Genero.values()[id_genero - 1];
                
                // Obtener el nombre del director
                PreparedStatement sentenciaSQLDirector = conexion.prepareStatement(sqlDirector); 
                sentenciaSQLDirector.setInt(1, id_director);  
                ResultSet resultadoDirector = sentenciaSQLDirector.executeQuery();
                String nombreDirector = "";
                if (resultadoDirector.next()) {
                    nombreDirector = resultadoDirector.getString("nombre");
                }
                Director director = new Director(nombreDirector);
                peliculaID = new Pelicula(tituloPelicula, director, año, url_caratula, genero, animacion);
                peliculaID.setId(id);
            }

            conexion.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return peliculaID;
    }
    
    public Pelicula buscaPorNombre(String nombre) {

        Pelicula porNombre = null;
        String sqlPelicula = "SELECT * FROM peliculas WHERE titulo = ?";
        try {
            Connection conexion = new Conexion().getConnection(path); 
            
            // Obtener información básica de la película
            PreparedStatement sentenciaSQLPelicula = conexion.prepareStatement(sqlPelicula); 
            sentenciaSQLPelicula.setString(1, nombre); 
            ResultSet resultadoPelicula = sentenciaSQLPelicula.executeQuery();
            
            if (resultadoPelicula.next()) {
                String tituloPelicula = resultadoPelicula.getString("titulo");
                int id_director = resultadoPelicula.getInt("id_director");
                int año = resultadoPelicula.getInt("año");
                String url_caratula = resultadoPelicula.getString("url_caratula");
                int id_genero = resultadoPelicula.getInt("id_genero");
                boolean animacion = resultadoPelicula.getInt("es_animacion") != 0;

                Genero genero = Genero.values()[id_genero - 1];
                
                // Obtener el nombre del director
                DirectorDAO directorDAO = new DirectorDAO(path);
                Director director = directorDAO.buscaPorID(id_director);
                
                porNombre = new Pelicula(tituloPelicula, director, año, url_caratula, genero, animacion);
            }

            conexion.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return porNombre;
    }

    public void eliminarID(int id) {

        String sql = "Delete FROM peliculas WHERE id = ?";
        
        try {

        Connection conexion = new Conexion().getConnection(path); 
        PreparedStatement sentenciaSQL = conexion.prepareStatement(sql); 
        sentenciaSQL.setInt(1, id);  
        int filasEliminadas = sentenciaSQL.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Se ha borrado la pelicula con ID " + id);
            } else {
                System.out.println("No se encontró ninguna pelicula con el ID " + id + " para borrar.");
            }
            sentenciaSQL.close();
            conexion.close();

        } catch (SQLException err) {
            err.printStackTrace();
        }
    }
}