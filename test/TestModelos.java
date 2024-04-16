package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
    
}