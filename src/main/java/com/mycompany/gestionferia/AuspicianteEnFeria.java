//PAQUETE
package com.mycompany.gestionferia;

//IMPORTS


//CLASE
public class AuspicianteEnFeria {
    //VARIABLES DE INSTANCIA
    private Auspiciante auspiciante;
    private String auspicio;

    //CONSTRUCTOR
    public AuspicianteEnFeria() {
    }
    public AuspicianteEnFeria(Auspiciante auspiciante) {
        this.auspiciante = auspiciante;
    }
    public AuspicianteEnFeria(Auspiciante auspiciante, String auspicio){
      this.auspiciante = auspiciante;
      this.auspicio = auspicio;
    }

    //getters and setters
    
    public Auspiciante getAuspiciante() {
        return auspiciante;
    }

    public String getAuspicio() {
        return auspicio;
    }


    public void setAuspiciante(Auspiciante auspiciante) {
        this.auspiciante = auspiciante;
    }

    public void setAuspicio(String auspicio) {
        this.auspicio = auspicio;
    }


}
    
