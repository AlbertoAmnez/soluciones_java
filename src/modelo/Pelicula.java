package modelo;



public class Pelicula {
    private String titulo;

    private Director director;
    
    

    private int año;


    private String url_caratula;

   
    private Genero genero;


    private boolean animacion;


    private int id;


    public Pelicula (String titulo, Director director, int año, String url_caratula, Genero genero, boolean animacion) {
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.url_caratula = url_caratula;
        this.genero = genero;
        this.animacion = animacion;
        

    
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getAño() {
        return año;
    }
    public void setAño(Integer año) {
        this.año = año;
    }

    public String getUrl_caratula() {
        return url_caratula;
    }


    public void setUrl_Caratula(String url_caratula) {
        this.url_caratula = url_caratula;
    }


    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public boolean esAnimacion() {
        return animacion;
    }

    public void setAnimacion(boolean animacion) {
        this.animacion = animacion;
    }

    
}
