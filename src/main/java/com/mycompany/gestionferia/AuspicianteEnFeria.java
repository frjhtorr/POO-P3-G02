//PAQUETE
package com.mycompany.gestionferia;

//IMPORTS
import modelo.Auspiciante;
    
//CLASE
public class AuspicianteEnFeria {
    //VARIABLES DE INSTANCIA
    private Auspiciante aupiciante;
    private String auspicio;
    private boolean tieneStand;

    //CONSTRUCTOR
    public AuspicianteEnFeria(Auspiciante aupiciante, String auspicio, boolean tieneStand) {
        this.aupiciante = aupiciante;
        this.auspicio = auspicio;
        this.tieneStand = tieneStand;
    }
    
    //getters and setters

    public Auspiciante getAupiciante() {
        return aupiciante;
    }

    public String getAuspicio() {
        return auspicio;
    }

    public boolean isTieneStand() {
        return tieneStand;
    }

    public void setAupiciante(Auspiciante aupiciante) {
        this.aupiciante = aupiciante;
    }

    public void setAuspicio(String auspicio) {
        this.auspicio = auspicio;
    }

    public void setTieneStand(boolean tieneStand) {
        this.tieneStand = tieneStand;
    }
    
    
    
}
