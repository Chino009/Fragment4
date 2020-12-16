package mx.com.chino.fragment.model;

public class Categoria {

    private int idCategoria;
    private String imagen;
    private  String nomCategoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String imagen, String nomCategoria) {
        this.idCategoria = idCategoria;
        this.imagen = imagen;
        this.nomCategoria = nomCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }
}
