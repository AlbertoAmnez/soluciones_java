package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import modelo.Conexion;
import modelo.Director;
import modelo.Genero;
import modelo.Pelicula;

public class TestModelos {
    @Test
    public void testConsultaPelicula() {
        Director director = new Director("Randal Kleiser");
        Pelicula film = new Pelicula("Grease", director, 1978, Genero.MUSICAL, false );

        assertEquals(film.getTitulo(), "Grease");
        assertEquals(film.getDirector().getNombre(), "Randal Kleiser");
        assertEquals(film.getAño(), 1978);
        assertEquals(film.getGenero(), Genero.MUSICAL);
        assertEquals(film.esAnimacion(), false);
        
    } 
    @Test
    public void testConsultaDirector() {
        Director director = new Director("Almodovar");

        assertEquals(director.getNombre(), "Almodovar");
    }

    
    @Test 
    public void testDameGenero() {

        assertEquals(Genero.ACCION.toString(), "ACCION");
        assertEquals(Genero.DRAMA.toString(), "DRAMA");
    }

    @Test
    public void testJDBCConecta() {

        boolean claseJDBCExiste = false;
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("OK");
            claseJDBCExiste = true;
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC no encontrado");
            e.printStackTrace();
        }
        
        assertTrue(claseJDBCExiste);
    }
    
    @Test 
    public void testConexion() throws SQLException {
        Conexion prueba = new Conexion();

        Connection conexion = prueba.getConnection("./soluciones.sqlite");
        assertNotNull(conexion);
        System.out.println("Conectado");
        conexion.close();
    }
    
    
    
}