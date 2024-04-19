package modelo;

public class Director {
    private String nombre;

    private String urlFoto;

    private String urlWeb; 

    private int id;



    public Director(String nombre) {
        this.nombre = nombre;
        

    }
    
    public Director(String nombre, String urlFoto, String urlWeb) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.urlWeb = urlWeb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String url_foto) {
        this.urlFoto = url_foto;
    }
    
    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
