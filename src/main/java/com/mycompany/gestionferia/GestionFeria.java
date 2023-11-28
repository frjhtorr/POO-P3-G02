/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionferia;

/**
 *
 * @author Josh
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;

public class GestionFeria {
    
    static ArrayList<Feria> ferias = new ArrayList<>();
    static ArrayList<Auspiciantes> auspiciantesGenerales = new ArrayList<>();
    public static String generarCod(){
        int n = ferias.size();
        return "FE00"+(n+1);
    }
    
    public static void verFeria(int i){
        System.out.println(ferias.get(i-1).toString());
    }
    
    public static void registrarFeria(){
        Scanner sc = new Scanner(System.in);
        System.out.println("NUEVO REGISTRO DE FERIA"
        + "\n--------------------------------------");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("");
        System.out.println("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.println("");
        System.out.println("Lugar: ");
        String lugar = sc.nextLine();
        System.out.println("");
        System.out.println("Fecha de incio (YYYY-MM-DD): ");
        String fechaIni= sc.nextLine();
        System.out.println("");
        System.out.println("Fecha de fin (YYYY-MM-DD): ");
        String fechaFin = sc.nextLine();
        System.out.println("");
        System.out.println("Horario: ");
        String horario = sc.nextLine();
        System.out.println("");
      
        String cod = generarCod();
        Feria feriaNueva = new Feria(cod, nombre, descripcion, lugar, fechaIni, fechaFin, horario);
        ferias.add(feriaNueva);
        sc.close();
    }
    
    public static void editarFeria(Feria f){
        Scanner sc = new Scanner(System.in);
        
        String fechaIni = f.getFechaIni();
        String[] fecha = fechaIni.split("-");
        int a = Integer.parseInt(fecha[0]);
        int m = Integer.parseInt(fecha[1]);
        int d = Integer.parseInt(fecha[2]);
        
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicio = LocalDate.of(a, m, d);
        
        if (!fechaInicio.isBefore(fechaActual)) {
            //La fecha no ha pasado
            System.out.println("Feria: " +f.getNombre());
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            if (!nombre.isEmpty()){
                f.setNombre(nombre);
            }
            System.out.println("");
            System.out.println("Descripción: ");
            String descripcion = sc.nextLine();
            if (!descripcion.isEmpty()){
                f.setNombre(descripcion);
            }
            System.out.println("");
            System.out.println("Lugar: ");
            String lugar = sc.nextLine();
            if (!lugar.isEmpty()){
                f.setNombre(lugar);
            }
            System.out.println("");
            System.out.println("Fecha de incio (YYYY-MM-DD): ");
            String fechaI= sc.nextLine();
            if (!fechaIni.isEmpty()){
                f.setNombre(fechaI);
            }
            System.out.println("");
            System.out.println("Fecha de fin (YYYY-MM-DD): ");
            String fechaFin = sc.nextLine();
            if (!fechaFin.isEmpty()){
                f.setNombre(fechaFin);
            }
            System.out.println("");
            System.out.println("Horario: ");
            String horario = sc.nextLine();
            if (!horario.isEmpty()){
                f.setNombre(horario);
            }
            System.out.println("");
        } else {
            //La fecha ha pasado
            System.out.println("Lo sentimos, la feria ya está en curso. No se puede editar");
        }
        sc.close();
    }
    
    public static void asignarAuspiciante(String cod, String ci){
        Scanner sc = new Scanner(System.in);
        Feria feriaBuscada;
        Auspiciante auspicianteNuevo;
        
        for(Feria f: ferias){
            if(f.getCodFeria().equals(cod)){
                feriaBuscada=f;
            }
        }
        for(Auspiciante a: auspiciantesGenerales){
            if(a.getCi().equals(ci)){
                auspicianteNuevo=a;
            }
        }
        if(!(feriaBuscada==null) && !(auspicianteNuevo==null)){
            System.out.println("Descripción de lo que cubre el auspicio: ");
            String descripcion = sc.nextLine();
            System.out.println("Incluye stand en la feria (Si/No): ");
            String respuesta = sc.nextLine();
            if(respuesta.equals("Si")){
                //Asinación de stand
            }
            AuspicianteEnFeria auspicianteEnFeriaNuevo = (AuspicianteEnFeria) auspicianteNuevo;
            auspicianteEnFeriaNuevo.setAuspicio=descripcion;
            
            f.getLstAuspiciantes().add(auspicianteEnFeriaNuevo);
        }
        sc.close();
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
}
