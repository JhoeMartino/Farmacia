
package CapaDatos;
public class Categoria {
    
    
    private int idcategoria;
    private String catNombre;

    public Categoria() {
    }

    public Categoria(int idcategoria, String catNombre) {
        this.idcategoria = idcategoria;
        this.catNombre = catNombre;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }
    
    
}
