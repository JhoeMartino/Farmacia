package CapaDatos;

public class Marca {

    private int idmaraca;
    private String maNombre;

    public Marca() {
    }

    public Marca(int idmaraca, String maNombre) {
        this.idmaraca = idmaraca;
        this.maNombre = maNombre;
    }

    public int getIdmaraca() {
        return idmaraca;
    }

    public void setIdmaraca(int idmaraca) {
        this.idmaraca = idmaraca;
    }

    public String getMaNombre() {
        return maNombre;
    }

    public void setMaNombre(String maNombre) {
        this.maNombre = maNombre;
    }

    
    
}
