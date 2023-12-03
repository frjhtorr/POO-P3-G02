/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionferia;

/**
 *
 * @author Arturo
 */
public class Stand {
    private int num;
    private boolean reservado; 
    private Persona owner;
    private String fechaAsigna;


    //CONSTRUCTORES -----------------------------------------
  public Stand(){
  }
  
    
  public Stand(int num, boolean reservado, Persona owner, String fechaAsigna){
        this.num = num;
        this.reservado = reservado;
        this.owner = owner;
        this.fechaAsigna = fechaAsigna;
    } 

    // TOSTRING -------------------------------------
public String toString() {
      return "Stand{" +
             "num=" + num +
             ", reservado=" + reservado +
             ", owner='" + owner + '\'' +
             ", fecha='" + fechaAsigna + '\'' +
             '}';
  }

    //GETTERS AND SETTERS ------------------------------------------------
    
      // Getter y Setter para 'num'
      public int getNum() {
          return num;
      }

      public void setNum(int num) {
          this.num = num;
      }

      // Getter y Setter para 'reservado'
      public boolean getReservado() {
          return reservado;
      }

      public void setReservado(boolean reservado) {
          this.reservado = reservado;
      }

      public Persona getOwner() {
          return owner;
      }

      public String getFechaAsigna() {
          return fechaAsigna;
      }

      public void setFechaAsigna(String fechaAsigna) {
          this.fechaAsigna = fechaAsigna;
      }

    public void setOwner(Persona owner){
        this.owner = owner;
    }
}