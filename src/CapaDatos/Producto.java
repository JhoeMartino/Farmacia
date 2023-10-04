package CapaDatos;

public class Producto {

    private String pSerie;
    private String pDescripcion;
    private String pObsevacion;
    private String digemi;
    private String pCondicion;
    private int idcategoria;
    private int idmarca;
    private int idmedida;

    public Producto() {
    }

    public Producto(String pSerie, String pDescripcion, String pObsevacion, String digemi, String pCondicion, int idcategoria, int idmarca, int idmedida) {
        this.pSerie = pSerie;
        this.pDescripcion = pDescripcion;
        this.pObsevacion = pObsevacion;
        this.digemi = digemi;
        this.pCondicion = pCondicion;
        this.idcategoria = idcategoria;
        this.idmarca = idmarca;
        this.idmedida = idmedida;
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }

    public String getpDescripcion() {
        return pDescripcion;
    }

    public void setpDescripcion(String pDescripcion) {
        this.pDescripcion = pDescripcion;
    }

    public String getpObsevacion() {
        return pObsevacion;
    }

    public void setpObsevacion(String pObsevacion) {
        this.pObsevacion = pObsevacion;
    }

    public String getDigemi() {
        return digemi;
    }

    public void setDigemi(String digemi) {
        this.digemi = digemi;
    }

    public String getpCondicion() {
        return pCondicion;
    }

    public void setpCondicion(String pCondicion) {
        this.pCondicion = pCondicion;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(int idmedida) {
        this.idmedida = idmedida;
    }
    
    
    

}
