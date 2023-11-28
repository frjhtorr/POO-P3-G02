/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionferia;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Arturo
 */
public class Seccion {
    private int cantStands;
    private String id;
    private List<Stand> ListStands;

    public String getId() {
        return id;
    }
    public int getCantStands(){
        return cantStands;
    }

    public void setCantStands(int cantStands) {
        this.cantStands = cantStands;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Stand> getListStands() {
        return ListStands;
    }

    public void setListStands(List<Stand> ListStands) {
        this.ListStands = ListStands;
    }
}
