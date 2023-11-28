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
private String owner;
private String fecha;

public String toString() {
      return "Stand{" +
             "num=" + num +
             ", reservado=" + reservado +
             ", owner='" + owner + '\'' +
             ", fecha='" + fecha + '\'' +
             '}';
  }
}
