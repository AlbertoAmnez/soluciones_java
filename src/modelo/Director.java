package modelo;

public class Director {
    private String nombre;

    private int id;

    public Director(String nombre) {
        this.nombre = nombre;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
