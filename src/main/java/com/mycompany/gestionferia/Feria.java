/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionferia;

/**
 *
 * @author Josh
 */
import java.util.*;

public class Feria{
    private String nombre;
    private String descripcion;
    private String fechaIni;
    private String fechaFin;
    private String lugar;
    private String horario;
    private String codFeria;
    private ArrayList<Emprededores> lstEmprendedores;
    /*private ArrayList<AuspicianteEnFeria> auspiciantes;
  private Seccion[] secciones;
  private ArrayList<Emprendedor> listEmprendores;
*/

    public String getCodFeria() {
        return codFeria;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

  
  
  public Feria( String codFeria, String nombre, String descripcion, String lugar, String fechaIni, String fechaFin, String horario){
    this.codFeria=codFeria;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechaIni = fechaIni;
    this.fechaFin = fechaFin;
    this.lugar = lugar;
    this.horario = horario;
    //this.auspiciantes = auspiciantes;
  }
   
  
  
  
  public String toString(){//verFeria()
    return "Hola";
  }


  /*public void asignarAuspiciante(Auspiciante a){
    
  }*/

 /* public ArrayList<Emprendedor> consultarEmprendedores(){
    ArrayList<Emprendedor> emprendedores = new ArrayList<>();
    return emprendedores;
  }*/

  public void mostrarDistribucion(){
        
  }

  public void reservarStand(){
    
  }
  
  
} 

