package test;

import static org.junit.Assert.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import modelo.Conexion;
import modelo.Director;
import modelo.DirectorDAO;
import modelo.Pelicula;
import modelo.PeliculaDAO;

public class TestDAO {

    @Test
    public void testDameTodosDirectores() throws SQLException{


        DirectorDAO dao = new DirectorDAO("./soluciones.sqlite");

        ArrayList<Director> nombresDirectores = dao.dameTodos();

        assertNotNull(nombresDirectores);
        assertFalse(nombresDirectores.isEmpty());

    }

    @Test
    public void testDamedirectorIP() throws SQLException {

        DirectorDAO dao = new DirectorDAO("./soluciones.sqlite");

        int id = 1;

        Director idBusqueda = dao.buscaPorID(id);
        assertNotNull("ID no debe ser nula", idBusqueda);
        assertEquals("El ID no coincide", id, idBusqueda.getId());

        int notID = -1;

        Director idNoExiste = dao.buscaPorID(notID);

        assertNull("No existe ID, por lo tanto es nulo", idNoExiste);





    }

    @Test
    public void testDameDirectorPorNombre() throws SQLException {

        DirectorDAO dao = new DirectorDAO("./soluciones.sqlite");

        String nombreExiste = "Nombre existe";
        Director directorExiste = dao.buscaPorNombre(nombreExiste);
        assertNotNull("El nombre no puede ser nulo", directorExiste);
        assertEquals("El nombre no coincide", nombreExiste, directorExiste.getNombre());

        String nombreNoExiste = "Nombre no existe";
        Director directorNoExiste = dao.buscaPorNombre(nombreNoExiste);

        assertNull ("No existe el director, resultado nulo", directorNoExiste);



    }

    @Test
    public void testDameTodasPeliculas() throws SQLException{


        PeliculaDAO dao = new PeliculaDAO("./soluciones.sqlite");

        ArrayList<Pelicula> listaPeliculas = dao.dameTodas();

        assertNotNull(listaPeliculas);
        assertFalse(listaPeliculas.isEmpty());
    
    }
    
}
