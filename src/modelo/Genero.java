package modelo;

public enum Genero {

    ACCION(1),
    AVENTURA(2),
    COMEDA(3),
    DRAMA(4),
    FANTASIA(5),
    TERROR(6),
    CFICCION(7),
    MUSICAL(8),
    SUSPENSE(9),
    WESTERN(10),
    DOCUMENTAL(11),
    BIOPIC(12),
    ROMANCE(13);

    

    private int id;

    private Genero(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    
}
