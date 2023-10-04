
package CapaDatos;
public class Composicion {
    
private int idcomposicion;
private String coNombre;
private String pSerie;

    public Composicion() {
    }

    public Composicion(int idcomposicion, String coNombre, String pSerie) {
        this.idcomposicion = idcomposicion;
        this.coNombre = coNombre;
        this.pSerie = pSerie;
    }

    public int getIdcomposicion() {
        return idcomposicion;
    }

    public void setIdcomposicion(int idcomposicion) {
        this.idcomposicion = idcomposicion;
    }

    public String getCoNombre() {
        return coNombre;
    }

    public void setCoNombre(String coNombre) {
        this.coNombre = coNombre;
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }


        
    
    
    
}
