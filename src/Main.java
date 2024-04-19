import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Director;
import modelo.DirectorDAO;
import modelo.Pelicula;
import modelo.PeliculaDAO;

public class Main {

    
    /* 
        
    
    DirectorDAO dao = new DirectorDAO("./soluciones.sqlite");

    
    String nombreExiste = "Pedro Almodovar";
    Director directorExistente = dao.buscaPorNombre(nombreExiste);
    if (directorExistente != null) {
        System.out.println("Director encontrado:");
        System.out.println("Nombre: " + directorExistente.getNombre());
    } else {
        System.out.println("No se encontró ningún director con el nombre: " + nombreExiste);
    }

    
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

    
    Pelicula pelicula = peliculaDAO.buscaPorID(id);

    
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

    
    scanner.close();
}
    */

    // Para comprobar que me saca la lista de peliculas en una tabla a traves de mi consola.
    /* 
    String path = "./soluciones.sqlite";

        // Crear una instancia de PeliculaDAO
        PeliculaDAO peliculaDAO = new PeliculaDAO(path);

        try {
            // Obtener todas las películas
            ArrayList<Pelicula> peliculas = peliculaDAO.dameTodas();

            // Imprimir información de todas las películas
            System.out.println("Lista de películas:");
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }

        } catch (SQLException e) {
            System.out.println("Error al intentar obtener todas las películas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    */
    public static void main(String[] args) {
        
        String path = "./soluciones.sqlite";
    
        
        DirectorDAO modificacion = new DirectorDAO(path);
    
        try {
            
            int idDirector = 1; // ID de la película que deseas modificar
            Director directorAModificar = modificacion.buscaPorID(idDirector);
    
            
            if (directorAModificar != null) {
                // Realizar los cambios necesarios en la película
                directorAModificar.setId(123); // 
                directorAModificar.setNombre("Julian"); 
    
                
                modificacion.modifica(directorAModificar);
            } else {
                System.out.println("No se encontró ninguna película con el ID " + idDirector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    

        

    







