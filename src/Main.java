import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Director;
import modelo.DirectorDAO;

public class Main {

    public static void main(String[] args) {
        try {
            // Crear una instancia de DirectorDAO
            DirectorDAO dao = new DirectorDAO("./soluciones.sqlite");

            // Obtener la lista de nombres de directores
            ArrayList<Director> nombresDirectores = dao.dameTodos();

            // Imprimir los nombres de los directores en la consola
            System.out.println("Lista de directores:");
            for (Director nombreDirector : nombresDirectores) {
                System.out.println(nombreDirector.getNombre());
            }
        } catch (SQLException err) {
            System.out.println("Se produjo un error al obtener la lista de directores: " + err.getMessage());
        }
    }
}