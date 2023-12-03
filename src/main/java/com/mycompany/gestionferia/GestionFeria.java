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
import java.util.Random;

class Main{
//VARIABLES ESTATICAS
    static ArrayList<Feria> ferias = new ArrayList<>();
    static ArrayList<Auspiciante> auspiciantesGenerales = new ArrayList<>();


    //METODOS
  //ESTATICOS
  
   //GENERAR CODIGO FERIA
    public static String generarCod(){
        int n = ferias.size();
        return "FE00"+(n+1);
    }   
  
    //BUSCAR FERIA
  public static Feria buscarFeria(String codFeria){
    Feria feriaBuscada = new Feria();
      for(Feria f: ferias){
       if(f.getCodFeria().equals(codFeria)){
        feriaBuscada=f;
        } 
    }
    return feriaBuscada;
  }
//VER FERIA
  //METODO INTERNO DE ADMINISTRACION FERIA
  public static void mostrarFerias(ArrayList<Feria> ferias){
    System.out.println("------LISTADO DE FERIAS QUE EXISTEN------ ");
    for(Feria f: ferias){
      System.out.println(f.getCodFeria()+" - "+f.getNombre()+" - "+f.getFechaIni()+" - "+f.getLugar()+" - "+f.cantidadAus());
  }
  }
  
  //POR INDICE
    public static void verFeria(int i){
        System.out.println(ferias.get(i).toString());
    }
  //POR CODIGO DE FERIA
    public static void verFeria(String cod){
      Feria feriaBuscada = buscarFeria(cod);
      int i = ferias.indexOf(feriaBuscada);
      verFeria(i);
    }
  //Registrar Auspiciante
    public static void registrarAuspiciante(){ 
      System.out.println("INGRESE LOS DATOS DEL AUSPICIANTE");
        Scanner sc = new Scanner(System.in);
        String c;
        boolean cedulaValida;
        Auspiciante nuevoAuspiciante = new Auspiciante();
        do {    
            System.out.println("Ingrese el número de cédula o RUC:");
            c = sc.nextLine();
            cedulaValida = Persona.validarCedula(c, auspiciantesGenerales);
            if (!cedulaValida) {
                System.out.println("Ya existe un auspiciante con ese número de cédula o RUC. Intente de nuevo.");
            }else{ System.out.println("Cedula válida");}
        } while (!cedulaValida);

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
      System.out.println(
          "Ingrese el sector cubierto (separadas por coma, por ejemplo, ALIMENTACIÓN, EDUCACIÓN, SALUD, VESTIMENTA): ");
      String sC = sc.nextLine().toUpperCase();
      
      SectorCubierto sectorCubierto = SectorCubierto.valueOf(sC);
      System.out.println("Ingrese el número de redes sociales (separadas por coma, por ejemplo");
      sc.nextLine();
      
      int cR = sc.nextInt();

      Persona p = new Persona(c, n, t, e, d, w, o);
      
      p.setLstRedes(cR);
      if (p instanceof Auspiciante ) {
        nuevoAuspiciante = (Auspiciante) p;
      }
      nuevoAuspiciante.setSector(sectorCubierto);
      auspiciantesGenerales.add(nuevoAuspiciante);
      sc.close();
    }
  
  //REGISTRAR FERIA
    public static void registrarFeria(){
        Scanner sc = new Scanner(System.in);
        System.out.println("NUEVO REGISTRO DE FERIA"
        + "\n--------------------------------------");
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Descripción: ");
        String descripcion = sc.nextLine();

        System.out.println("Lugar: ");
        String lugar = sc.nextLine();
      
        System.out.println("Fecha de incio (YYYY-MM-DD): ");
        String fechaIni= sc.nextLine();

        System.out.println("Fecha de fin (YYYY-MM-DD): ");
        String fechaFin = sc.nextLine();

        System.out.println("Horario: ");
        String horario = sc.nextLine();

        String cod = generarCod();
        Feria feriaNueva = new Feria(cod, nombre, descripcion, lugar, fechaIni, fechaFin, horario);
        feriaNueva.fijarStands();
        ferias.add(feriaNueva);
        sc.close();
    }

  //ASIGNAR AUSPICIANTES GENERALES
    public static void asignarAuspiciante(String cod, String ci){
        Scanner sc = new Scanner(System.in);
        Auspiciante auspicianteNuevo = new Auspiciante();
        Feria feriaBuscada = buscarFeria(cod);
      
        for(Auspiciante a: auspiciantesGenerales){
            if(a.getCedula().equals(ci)){
                auspicianteNuevo=a;
            }
        }
        if(!(feriaBuscada==null) && !(auspicianteNuevo==null)){
            System.out.println("Descripción de lo que cubre el auspicio: ");
            String descripcion = sc.nextLine();
            System.out.println("Incluye stand en la feria (Si/No): ");
            String respuesta = sc.nextLine();
            if(respuesta.equals("Si")){
                System.out.println("Escriba el código del stand");
                String ln = sc.nextLine();
                feriaBuscada.reservarStand(ln);
            }
            AuspicianteEnFeria auspicianteEnFeriaNuevo = new AuspicianteEnFeria(auspicianteNuevo, descripcion);
          

            feriaBuscada.getLstAuspiciantes().add(auspicianteEnFeriaNuevo);
        }
        sc.close();
    }

  ///editar auspiciante
  
  public static void editarAuspiciante(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el número de cédula del aspirante: ");
    String cedula = sc.nextLine();
    Auspiciante aus = new Auspiciante();
    for(Auspiciante a: auspiciantesGenerales){
      if(a.getCedula().equals(cedula)){
        aus = a;
      }
    }
    System.out.println("DATOS ACTUALES DEL AUSPICIANTE:");
    System.out.println(aus.toString());

    aus.minimetodo();
    System.out.println("8. Sectores cubiertos");

    
    int option = sc.nextInt();
    sc.nextLine();

    if (option < 0 || option > 8) {
        aus.editarPersona(option);
    }

    switch (option) {
        case 8:
            System.out.println("Ingrese los sectores cubiertos:");
            String sector = sc.nextLine();
            SectorCubierto sectorCubierto = SectorCubierto.valueOf(sector);
            aus.setSector(sectorCubierto);
            break;  // Agrega la instrucción break para evitar caer al caso default

        default:
            System.out.println("No hubo cambios");
    }

    sc.close();
  }

// MINI METODOS QUE IMPRIMEN COSAS
    
    public static void menuPrincipal(){ 
        System.out.println("Menú Principal_______________________" + 
               "\n 1. Administración de Ferias " + 
               "\n 2. Administración de Emprendedores " + 
               "\n 3. Administración de Auspiciantes " + 
               "\n 4. Administración de Stands " + 
               "\n 5. Salir");
   
    }
  
    public static void adminFerias(){
        System.out.println("ADMINISTRACIÓN DE FERIAS_________________" + 
                           "\n 1. Ver información de feria " + 
                           "\n 2. Registrar feria " + 
                           "\n 3. Editar feria " + 
                           "\n 4. Consultar emprendedores en feria " + 
                           "\n 5. Regresar");
        System.out.println("Seleccion: ");
    }
    public static void adminEmprendedores(){
        System.out.println("ADMINISTRACIÓN DE EMPRENDEDORES___________" + 
                           "\n 1. Registrar emprendedor " + 
                           "\n 2. Editar emprendedor " + 
                           "\n 3. Regresar ");
        System.out.print("Seleccion: ");
    }
    public static void adminAuspiciantes(){
        System.out.println("ADMINISTRACIÓN DE AUSPICIANTE___________" + 
                           "\n 1. Registrar auspiciante " + 
                           "\n 2. Editar auspiciante " + 
                           "\n 3. Asignar auspiciante a feria " + 
                           "\n 4. Regresar ");
        System.out.print("Seleccion: ");
    }
    public static void adminStands(){
        System.out.println("ADMINISTRACIÓN DE AUSPICIANTE___________" + 
                           "\n 1. Reservar Stand " + 
                           "\n 2. Mostrar la información de Stand " + 
                           "\n 3. Regresar");
        System.out.print("Seleccion: ");
    }


// INICIALIZACION DE UNA FERIA 
   public static Feria generarDatos(){
      Feria fe1 = new Feria("FE001","Feria 1","Navidad y Año nuevo productos","Santiago", "2024-3-12", "2025-3-15", "7:00 - 9:00");
       Seccion[] seccionesFe1 = new Seccion[4];
       /*String[] letras = {"A","B","C","D"};
       int i = 0 ;

       for(int j=0;j<seccionesFe1.length;j++){
         Seccion s = new Seccion();
         s.setId(letras[i]);
         s.setCantStands(1);
         ArrayList<Stand> stands = new ArrayList<Stand>(4);
         Stand stand1 = new Stand();
         stand1.setNum(1);
         stand1.setReservado(false);
         stands.add(stand1);
         s.setArrayStands(stands);
         i++;*/
        
       fe1.setSecciones(seccionesFe1);
       fe1.fijarStands();

// INICIALIZACION DEL AUSPICIANTE
     ArrayList<CuentaRedSocial> rA = new ArrayList<>();
     rA.add(new CuentaRedSocial(RedSocial.TWITTER, "@AuspicianteCorp"));
     rA.add(new CuentaRedSocial(RedSocial.LINKEDIN, "linkedin.com/company/auspiciante"));

     // Crear instancia de Auspiciante
     Auspiciante ausp1 = new Auspiciante("987654321", "Auspiciante Corp", "1234567890",
             "auspiciante@example.com", "Calle Auspicio, Ciudad Patrocinio", "auspiciante.com", "Auspiciante CEO", rA, SectorCubierto.SALUD);

     auspiciantesGenerales.add(ausp1);
     AuspicianteEnFeria auspF = new AuspicianteEnFeria(ausp1,"Comida para los invitados");
     ArrayList<AuspicianteEnFeria> auspiciantesEF = new ArrayList<>();
     auspiciantesEF.add(auspF);
     fe1.setLstAuspiciantes(auspiciantesEF);
     
     // INCIALIZACION DE LOS 4 EMPRENDEDORES

     // Creando listas de redes sociales para cada emprendedor
       ArrayList<CuentaRedSocial> redEmp1 = new ArrayList<>();
       redEmp1.add(new CuentaRedSocial(RedSocial.TWITTER, "@CodeInnovator"));
       redEmp1.add(new CuentaRedSocial(RedSocial.LINKEDIN, "linkedin.com/in/codeinnovator"));

       ArrayList<CuentaRedSocial> redEmp2 = new ArrayList<>();
       redEmp2.add(new CuentaRedSocial(RedSocial.FACEBOOK, "facebook.com/ByteGenius"));
       redEmp2.add(new CuentaRedSocial(RedSocial.TWITTER, "@TechTrailblaze"));

       ArrayList<CuentaRedSocial> redEmp3 = new ArrayList<>();
       redEmp3.add(new CuentaRedSocial(RedSocial.INSTAGRAM, "@QuantumCoder"));
       redEmp3.add(new CuentaRedSocial(RedSocial.LINKEDIN, "linkedin.com/in/quantumcoder"));

       ArrayList<CuentaRedSocial> redEmp4 = new ArrayList<>();
       redEmp4.add(new CuentaRedSocial(RedSocial.TWITTER, "@InnoVisionary"));
       redEmp4.add(new CuentaRedSocial(RedSocial.LINKEDIN, "linkedin.com/in/innovisionary"));

       // Creando instancias de Emprendedor
       Emprendedor emp1 = new Emprendedor("123456789", "Alice", "1234567890",
               "alice@example.com", "Tech Street, Silicon Valley", "codeinnovator.com", "Alice", redEmp1, "Software Development");

       Emprendedor emp2 = new Emprendedor("987654321", "Bob", "9876543210",
               "bob@example.com", "Innovation Lane, Tech City", "bytegenius.com", "Bob", redEmp2, "Tech Solutions");

       Emprendedor emp3 = new Emprendedor("456789012", "Charlie", "4567890123",
               "charlie@example.com", "Algorithm Avenue, Digital District", "quantumcoder.com", "Charlie", redEmp3, "Quantum Computing");

       Emprendedor emp4 = new Emprendedor("789012345", "Diana", "7890123456",
               "diana@example.com", "Innovation Alley, Future Street", "innovisionary.com", "Diana", redEmp4, "Innovation Consulting");
     
     //ASIG
     
       ArrayList<Emprendedor> lstEmprendedoresFe1 = new ArrayList<Emprendedor>();
     
       lstEmprendedoresFe1.add(emp1);
       lstEmprendedoresFe1.add(emp2);
       lstEmprendedoresFe1.add(emp3);
       lstEmprendedoresFe1.add(emp4);

      fe1.setLstEmprendedores(lstEmprendedoresFe1);
       /*
       Persona[] arregloP = new Persona[4];
       int j=0;
       for(Emprendedor emp : lstEmprendedoresFe1){
         Persona p = new Persona();
         p = emp;
         arregloP[j] = p;
         j+=1;
       }
      fe1.setLstEmprendedores(lstEmprendedoresFe1);
       int k = 0;
     Seccion[] se = new Seccion[4]; 
       for(Seccion se : fe1.getSecciones()){
         
         for(Stand st : se.getListStands()){
           st.setOwner(arregloP[k]);
           st.setReservado(true);
         }
         k+=1;
      }*/
     return fe1;
   } 

// MAIN 
    
    public static void main(String[] args) {
      Feria f1 = generarDatos();
      ferias.add(f1);
      System.out.println("GESTION DE FERIAS");
      Scanner sc = new Scanner(System.in);
      int opcion; 
      Feria f = new Feria();
      String ln;
      String codFeria="";
      do{
        menuPrincipal();
        System.out.print("Selección: ");
        opcion = sc.nextInt();
        sc.nextLine();
        switch(opcion){
          case 1://Administración de Ferias
            mostrarFerias(ferias);
            adminFerias();
            int opcionF = sc.nextInt();
            while(opcionF != 5){
            //opcionF = sc.nextInt();
            sc.nextLine();
            switch(opcionF){
              case 1:
                System.out.println("-> Ver información de feria");
                System.out.println("Selecciona el codigo de una feria: ");
                codFeria = sc.nextLine();
                verFeria(codFeria);
                break;
              case 2:
                System.out.println("-> Registrar nueva feria");
                registrarFeria();
                break;
              case 3:
                System.out.println("-> Editar feria");
                System.out.println("Selecciona una Feria: ");
                codFeria = sc.nextLine();
                f = buscarFeria(codFeria);
                f.editarFeria();
                break;
              case 4:
                System.out.println("-> Consultar emprendedores en feria");
                System.out.println("Selecciona una Feria: ");
                codFeria = sc.nextLine();
                f = buscarFeria(codFeria);
                f.consultarEmprendedores();
                break;}
              opcionF=5;
            } 
            break;
          case 2://Administracion de emprendedores
            adminEmprendedores();
            int opcionE = sc.nextInt();
            while(opcionE!=3){           
            sc.nextLine();
            switch(opcionE){
              case 1://registrar emprendedor
                System.out.println("-> Registrar emprendedor");
                System.out.println("Selecciona una Feria: ");
                codFeria = sc.nextLine();
                f= buscarFeria(codFeria);
                Emprendedor emp = new Emprendedor();
                Emprendedor emp2 = new Emprendedor();
                emp2 = emp.crearEmprendedor(f.getLstEmprendedores());
                f.registrarEmprendedor(emp2); 
                break;
              case 2: //editar emprendedor
                System.out.println("-> Editar emprendedor");
                System.out.println("Selecciona una Feria: ");
                codFeria = sc.nextLine();
                f = buscarFeria(codFeria);
                System.out.println("Ingrese la cédula de un emprendedor: ");
                String ced = sc.nextLine();
                f.editarEmprendedor(ced,f.getLstEmprendedores()); 
               break;}
              opcionE =3;
            }
            break;
          case 3: //Administración de auspiciantes
            adminAuspiciantes();
            int opcionA = sc.nextInt();
            while(opcionA!=4){
            sc.nextLine();
            switch(opcionA){
              case 1://registrar aupsiciante
                System.out.println("-> Registrar auspiciante");
                registrarAuspiciante();
                break;
              case 2: //editar auspiciante
                System.out.println("-> Editar auspiciante");
                editarAuspiciante();
                break;
              case 3: //asignar auspiciante
                System.out.println("-> Asignar auspiciante");
                System.out.println("Selecciona una Feria: ");
                codFeria = sc.nextLine();
                System.out.println("Escriba la cédula del auspiciante: ");
                String ci = sc.nextLine();
                asignarAuspiciante(codFeria, ci);
                break;}  
              opcionA = 4;
            }
            break;
          case 4: //Administración de Stands
            System.out.println("Selecciona una Feria: ");
            codFeria = sc.nextLine();
            f = buscarFeria(codFeria);
            String nombre = f.getNombre();
            System.out.println("-> " +nombre);
            f.mostrarDistribucion();
            adminStands();
            int opcionS = sc.nextInt();
            while(opcionS!=3){
            switch(opcionS){
              case 1://Reservar stand
                //System.out.println("Selecciona una Feria: ");
                sc.nextLine();
                //codFeria = sc.nextLine();
                //Feria fe = buscarFeria(codFeria);
                System.out.println("Selecciona un Stand: ");
                ln = sc.nextLine();
                f.reservarStand(ln);
                break;
            
              case 2://Mostrar informacion del stand
                //System.out.println("Selecciona una Feria: ");
                //codFeria = sc.nextLine();
                sc.nextLine();
                //Feria fd = buscarFeria(codFeria);
                System.out.println("Selecciona un Stand: ");
                ln = sc.nextLine();
                Stand std = f.buscarStand(ln);
                System.out.println("Se encontró stand");
                f.infoStand(std);
                break;
            }
              opcionS = 3;
            }
            break;
            default:
              System.out.println("Ingrese una opción válida");
              opcion = sc.nextInt();
        }
        System.out.println("");
        
      } while(opcion != 5); 

       sc.close();
    } 



    
   }