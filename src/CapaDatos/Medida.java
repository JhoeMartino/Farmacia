
package CapaDatos;
public class Medida {
   
    private int idmedida;
    private String mePresentacion;
    private String meEquivalencia;

    public Medida() {
    }

    public Medida(int idmedida, String mePresentacion, String meEquivalencia) {
        this.idmedida = idmedida;
        this.mePresentacion = mePresentacion;
        this.meEquivalencia = meEquivalencia;
    }

    public int getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(int idmedida) {
        this.idmedida = idmedida;
    }

    public String getMePresentacion() {
        return mePresentacion;
    }

    public void setMePresentacion(String mePresentacion) {
        this.mePresentacion = mePresentacion;
    }

    public String getMeEquivalencia() {
        return meEquivalencia;
    }

    public void setMeEquivalencia(String meEquivalencia) {
        this.meEquivalencia = meEquivalencia;
    }
    
    
    
}
