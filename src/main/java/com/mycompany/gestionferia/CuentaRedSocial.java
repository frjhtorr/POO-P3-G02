/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionferia;

/**
 *
 * @author Arturo
 */
public class CuentaRedSocial {
    private String cuenta;
    private RedSocial red;

    public CuentaRedSocial(RedSocial r, String c ){
        this.red = r;
        this.cuenta = c;
    }
    public String toString(){
        return "Cuenta de: " +this.cuenta +"usurio: " +this.red ;
    } 
}

