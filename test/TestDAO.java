package test;

import static org.junit.Assert.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import modelo.Conexion;
import modelo.Director;
import modelo.DirectorDAO;

public class TestDAO {

    @Test
    public void testDameTodosDirectores() throws SQLException{


        DirectorDAO dao = new DirectorDAO("./soluciones.sqlite");

        ArrayList<Director> nombresDirectores = dao.dameTodos();

        assertNotNull(nombresDirectores);
        assertFalse(nombresDirectores.isEmpty());

    }
    
}
