import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Director;
import modelo.DirectorDAO;
import modelo.Pelicula;
import modelo.PeliculaDAO;

public class Main {

    public static void main(String[] args) {
    /* 
        
    // Crear una instancia de DirectorDAO
    DirectorDAO dao = new DirectorDAO("./soluciones.sqlite");

    // Buscar un director por ID existente
    String nombreExiste = "Pedro Almodovar";
    Director directorExistente = dao.buscaPorNombre(nombreExiste);
    if (directorExistente != null) {
        System.out.println("Director encontrado:");
        System.out.println("Nombre: " + directorExistente.getNombre());
    } else {
        System.out.println("No se encontró ningún director con el nombre: " + nombreExiste);
    }

    // Buscar un director por ID que no existe
    String nombreNoExiste = "Clint Eastwood";
    Director directorNoExistente = dao.buscaPorNombre(nombreNoExiste);
    if (directorNoExistente != null) {
        System.out.println("Director encontrado:");
        System.out.println("Nombre: " + directorNoExistente.getNombre());
    } else {
        System.out.println("No se encontró ningún director con el nombre: " + nombreNoExiste);
    }
    }
    */

    /* 
    PeliculaDAO peliculaDAO = new PeliculaDAO("./soluciones.sqlite");

    
    Scanner scanner = new Scanner(System.in);

    
    System.out.print("Ingrese el id de la película: ");
    int id = scanner.nextInt();

    // Buscar la película por nombre
    Pelicula pelicula = peliculaDAO.buscaPorID(id);

    // Verificar si se encontró la película
    if (pelicula != null) {
        // Imprimir los detalles de la película
        System.out.println("Película encontrada:");
        System.out.println("Título: " + pelicula.getTitulo());
        System.out.println("Director: " + (pelicula.getDirector() != null ? pelicula.getDirector().getNombre() : "Desconocido"));
        System.out.println("Año: " + pelicula.getAño());
        System.out.println("URL Carátula: " + pelicula.getUrl_caratula());
        System.out.println("Género: " + pelicula.getGenero());
        System.out.println("Es Animación: " + pelicula.esAnimacion());
    } else {
        System.out.println("No se encontró ninguna película con el nombre: " + id);
    }

    // Cerrar el scanner
    scanner.close();
}
    */


    Scanner scanner = new Scanner(System.in);

    // Establecer la ruta de la base de datos
    String path = "./soluciones.sqlite";

    // Crear una instancia de PeliculaDAO
    PeliculaDAO peliculaDAO = new PeliculaDAO(path);

    // Solicitar al usuario que ingrese el ID de la película a eliminar
    System.out.print("Ingrese el ID de la película a eliminar: ");
    int idPelicula = scanner.nextInt();

    // Eliminar la película por su ID
    peliculaDAO.eliminarID(idPelicula);

    System.out.println("La película ha sido eliminada correctamente.");

    // Cerrar el scanner
    scanner.close();
    }
}




