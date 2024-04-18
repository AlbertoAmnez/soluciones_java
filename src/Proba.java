import java.sql.SQLException;
import java.util.Scanner;

import modelo.PeliculaDAO;

public class Proba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Establecer la ruta de la base de datos
        String path = "./soluciones.sqlite";

        // Crear una instancia de PeliculaDAO
        PeliculaDAO peliculaDAO = new PeliculaDAO(path);

        try {
            // Solicitar al usuario que ingrese el ID de la película a eliminar
            System.out.print("Ingrese el ID de la película a eliminar: ");
            int idPelicula = scanner.nextInt();

            // Eliminar la película por su ID
            peliculaDAO.eliminarID(idPelicula);

            System.out.println("La película ha sido eliminada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar la película: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar el scanner
            scanner.close();
        }
    }
}