//PAQUETE
package com.mycompany.gestionferia;

//IMPORTS

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


//CLASE
public class Persona{
    //VARIABLES DE INSTANCIA
    protected String cedula;
    protected String nombre;
    protected String telefono;
    protected String email;
    protected String direccion;
    protected String web;
    protected String owner;
    protected ArrayList<CuentaRedSocial> lstRedes;
    protected ArrayList<Stand> lstStands;
    
    public ArrayList getLstStands(){
        return this.lstStands;
    }

    //CONSTRUCTORES
    //Constructor default
  public Persona(){  
  }
  //Cosntructor 1
public Persona(String cedula, String nombre, String telefono,
               String email, String direccion, String web, String owner,
               ArrayList<CuentaRedSocial> lstRedes) {
    this.cedula = cedula;
    this.nombre = nombre;
    this.telefono = telefono;
    this.email = email;
    this.direccion = direccion;
    this.web = web;
    this.owner = owner;
    this.lstRedes = lstRedes;
}
//Constructor 2
    public Persona(String cedula, String nombre, String telefono, String email, String direccion, String web, String owner){
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.web = web;
        this.owner = owner;  
    }
    //getters y setters
    public String getCedula() {
        return cedula;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public ArrayList<CuentaRedSocial> getLstRedes() {
        return lstRedes;
    }

// SETTER DE LST REDES PARA QUE EL USUARIO INGERESE LOS DATOS DE LAS REDES SOCIALES DISPONIBLES
    
    public void setLstRedes(int cR) {
      ArrayList<CuentaRedSocial> lstRedes = new ArrayList<>();        
      Scanner scanner = new Scanner(System.in);
      for (int i = 0; i < cR; i++) {
    
              System.out.println("Elija la red social TWITTER, FACEBOOK, INSTAGRAM, LINKEDIN, PINTEREST, YOUTUBE");
              System.out.println("Tendrá que escribir correctamente el nombre de la red social: ");

              String redString = scanner.nextLine();

              try {
                  RedSocial red = RedSocial.valueOf(redString.toUpperCase());

                  System.out.print("Ingrese su usuario en " + red + ": ");
                  String usuario = scanner.nextLine();

                  CuentaRedSocial nuevaRed = new CuentaRedSocial(red, usuario);
                  lstRedes.add(nuevaRed);

              } catch (IllegalArgumentException e) {
                  System.out.println("Red social no válida. Intente de nuevo.");
                  i--;
              }
          }
          scanner.close();
    }

  public void setLstStands(ArrayList<Stand> lstStands) {
      this.lstStands = lstStands;
  }
//------------------------------------------------------------------------------------------------------------
  //METODOS
    // VALIDAR CEDULA PERSONA
  public static boolean validarCedula(String cedula, ArrayList<? extends Persona> listaPersonas) {
      for (Persona p : listaPersonas) {
          if (p.getCedula().equals(cedula)) {
            System.out.println("La cédula ya está registrada.");
              return false;
          }
      }
      return true; 
  }

   // ------------------------------------------------------------------------------------
    //TOSTRING DE PERSONA
    public String toString() {
        return "-----------------------------------------" + "\n" +
               "Nombre: " + nombre + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Email: " + email + "\n" +
               "Direccion: " + direccion + "\n" +
               "Sitio web: " + web + "\n" +
               "Persona responsable: " + owner + "\n" +
               "Redes sociales: " + lstRedes + "\n";
    }
 // ------------------------------------------------------------------------------------
 //METODO EDITAR PERSONA GENERAL
    public void editarPersona(int opcion){
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
        case 1 -> {
            System.out.println("Ingrese el nuevo nombre:");
            setNombre(scanner.nextLine());
            }
        case 2 -> {
            System.out.println("Ingrese el nuevo teléfono:");
            setTelefono(scanner.nextLine());
            }
        case 3 -> {
            System.out.println("Ingrese el nuevo email:");
            setEmail(scanner.nextLine());
            }
        case 4 -> {
            System.out.println("Ingrese la nueva dirección:");
            setDireccion(scanner.nextLine());
            }
        case 5 -> {
            System.out.println("Ingrese el nuevo sitio web:");
            setWeb(scanner.nextLine());
            }
        case 6 -> {
            System.out.println("Ingrese la nueva persona responsable:");
            setOwner(scanner.nextLine());
            }
        case 7 -> {
            System.out.println("Ingrese las nuevas redes sociales:");
          int valor = scanner.nextInt();
            setLstRedes(valor);
            }       
    }scanner.close();

    }
//-----------------------------------------------------------------------------------------
//METODOS AUXILIARES   -- SOLO PARA GUARDAR E IMPRIMIRN INFORMACION
public void minimetodo(){
    System.out.println("-----------------------------------------");
    System.out.println("¿Qué campo desea editar? ");
    System.out.println("1. Nombre ");
    System.out.println("2. Teléfono ");
    System.out.println("3. Email ");
    System.out.println("4. Dirección ");
    System.out.println("5. Sitio web ");
    System.out.println("6. Persona responsable ");
    System.out.println("7. Redes sociales ");
  }

  //---------------------------------------------------
    
public Persona minimetodo2(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese la cedula: ");
    String c = sc.nextLine();
    System.out.println("Ingrese el nombre:");
    String n = sc.nextLine();
    System.out.println("Ingrese el teléfono:");
    String t = sc.nextLine();
    System.out.println("Ingrese el email:");
    String e = sc.nextLine();
    System.out.println("Ingrese la dirección (puede dejar en blanco):");
    String d = sc.nextLine();
    System.out.println("Ingrese el sitio web (puede dejar en blanco):");
    String w = sc.nextLine();
    System.out.println("Ingrese el nombre de la persona responsable:");
    String o = sc.nextLine();
    Persona p = new Persona(c,n,t,e,d,w,o);
    
    return p;
  }
  
}
