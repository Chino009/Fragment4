package mx.com.chino.fragment.model;

public class MyGame {
    private int idMyGame;
    private String imagen;
    private String titulo;
    private int clasificacion;
    private String Descripcion;

    public MyGame() {
    }

    public MyGame(int idMyGame, String imagen, String titulo, int clasificacion, String descripcion) {
        this.idMyGame = idMyGame;
        this.imagen = imagen;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        Descripcion = descripcion;
    }

    public int getIdMyGame() {
        return idMyGame;
    }

    public void setIdMyGame(int idMyGame) {
        this.idMyGame = idMyGame;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

}
