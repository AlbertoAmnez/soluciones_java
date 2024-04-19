package test;

import static org.junit.Assert.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import modelo.Conexion;
import modelo.Director;
import modelo.DirectorDAO;
import modelo.Genero;
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
    public void testDamedirectorID() throws SQLException {

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

        String nombreExiste = "Guy Ritchie";
        Director directorExiste = dao.buscaPorNombre(nombreExiste);
        assertNotNull("El nombre no puede ser nulo", directorExiste);
        assertEquals("El nombre no coincide", nombreExiste, directorExiste.getNombre());

        String nombreNoExiste = "Peter Jackson";
        Director directorNoExiste = dao.buscaPorNombre(nombreNoExiste);

        assertNull ("No existe el director, resultado nulo", directorNoExiste);

    }

    @Test
    public void testEliminarDirectorID() throws SQLException {

        DirectorDAO idDirector = new DirectorDAO("./soluciones.sqlite");
        
        int id = 1;
        idDirector.eliminarID(id);
        
    }

    @Test
public void testModificaDirector() throws SQLException {
    String path = "./soluciones.sqlite";
    
    // Crear una instancia de DirectorDAO
    DirectorDAO directorDAO = new DirectorDAO(path);
    
    // Crear un nuevo director
    int idDirector = 1;

    Director directorModificado = directorDAO.buscaPorID(idDirector);
    
    if (directorModificado != null) {
    
    directorModificado.setNombre("Nuevo Nombre");
    directorModificado.setUrlFoto("Nueva URL de Foto");
    directorModificado.setUrlWeb("Nueva URL Web");
        
    directorDAO.modifica(directorModificado);

    Director directorMod = directorDAO.buscaPorID(idDirector);

    assertEquals("Martin Scorsese", directorMod.getNombre());
    assertEquals("null", directorMod.getUrlFoto());
    assertEquals("null", directorMod.getUrlWeb());
    } else {
    System.out.println("No se encontró ningún director con el ID " + idDirector);
}
    
    
}


    @Test
    public void testDameTodasPeliculas() throws SQLException{


        PeliculaDAO dao = new PeliculaDAO("./soluciones.sqlite");

        ArrayList<Pelicula> listaPeliculas = dao.dameTodas();

        assertNotNull(listaPeliculas);
        assertFalse(listaPeliculas.isEmpty());
    
    }

    @Test
    public void testBuscaPorID() throws SQLException {

        PeliculaDAO peliculaDAO = new PeliculaDAO("./soluciones.sqlite");
        
        int id = 3;
        Pelicula pelicula = peliculaDAO.buscaPorID(id);
        
        assertNotNull(pelicula);
        assertEquals(id, pelicula.getId());
    }

    @Test
    public void testBuscaPorNombre() throws SQLException {

        PeliculaDAO peliculaDAO = new PeliculaDAO("./soluciones.sqlite");


        
        String nombre = "Grease";
        Pelicula pelicula = peliculaDAO.buscaPorNombre(nombre);
        
        assertNotNull(pelicula);
        assertEquals(nombre, pelicula.getTitulo());
    }

    @Test
    public void testEliminarID() throws SQLException {

        PeliculaDAO peliculaDAO = new PeliculaDAO("./soluciones.sqlite");
        
        int id = 1;
        peliculaDAO.eliminarID(id);
        
    }

    @Test
    public void testModifica() throws SQLException {

        PeliculaDAO peliculaDAO = new PeliculaDAO("./soluciones.sqlite");
        
        Pelicula pelicula = new Pelicula("Grease", new Director("Randal Kleiser"), 1978, "null", Genero.MUSICAL, false);
        
        int id = 3;

        
        pelicula.setAño(2023);
        
        
        peliculaDAO.modifica(pelicula);
        
        
        Pelicula peliculaModificada = peliculaDAO.buscaPorID(id);
       
        assertEquals(2023, peliculaModificada.getAño());
    }
}
    

