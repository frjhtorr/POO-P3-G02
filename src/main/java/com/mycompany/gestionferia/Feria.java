//PACKAGE
package com.mycompany.gestionferia;
//IMPORTS
import java.util.*;
import java.time.LocalDate;
import java.time.Month;


public class Feria{
  //VARIABLES DE INSTANCIA
    private String nombre;
    private String descripcion;
    private String fechaIni;
    private String fechaFin;
    private String lugar;
    private String horario;
    private String codFeria;
    private ArrayList<Emprendedor> lstEmprendedores;
    private ArrayList<AuspicianteEnFeria> lstAuspiciantes;
    private Seccion[] secciones = new Seccion[4];

  //CONSTRUCTORES
    public Feria(){
    
    }
  
    public Feria( String codFeria, String nombre, String descripcion, String lugar, String fechaIni, String fechaFin, String horario){
      this.codFeria=codFeria;
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.fechaIni = fechaIni;
      this.fechaFin = fechaFin;
      this.lugar = lugar;
      this.horario = horario;
    }

//METODOS ------------------------------------------------
  //GETTES AND SETTERS
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

  public ArrayList<Emprendedor> getLstEmprendedores() {
      return lstEmprendedores;
  }

  public void setLstEmprendedores(ArrayList<Emprendedor> lstEmprendedores) {
      this.lstEmprendedores = lstEmprendedores;
  }

  public ArrayList<AuspicianteEnFeria> getLstAuspiciantes() {
      return this.lstAuspiciantes;
  }

  public void setLstAuspiciantes(ArrayList<AuspicianteEnFeria> lstAuspiciantes) {
      this.lstAuspiciantes = lstAuspiciantes;
  }
  public Seccion[] getSecciones(){
    return secciones;
  }
  public void setSecciones(Seccion[] secciones){
    this.secciones = secciones;
  }
  
//toString-----------------------------------------------
  public String toString(){
    String m = "";
    for(int j =0; j<4; j++){
       Seccion s = new Seccion();
      //Id = Letra, Ej: A
      String letra = s.getId();
      int z = cantidadAus();
      ArrayList<Stand> stands = new ArrayList<>(z);
      stands = s.getListStands(); 

      for(int k = 0; k<stands.size() ; k++){//ITERA PARA MOSTAR LOS STANDS EN LAS SECCIONES
        Stand st = new Stand();
        int i=st.getNum();
        System.out.println("Seccion"+ i);
        if(st.getReservado()){
        m += "["+letra+i+"*]";
      }else{
        m += "["+letra+i+"]";
        } 
      }
      m += "\n";
    }
    return "-------------------------"+
      "\n Código: " + codFeria +
      "\n Nombre de la Feria: " + nombre +
      "\n Lugar: " + lugar +
      "\n Fecha de incio: " + fechaIni +
      "\n Fecha de fin: " + fechaFin +
      "\n Horario: " + horario +
      "\n Auspiciantes: " + lstAuspiciantes +
      "\n Distribucion: "+"\n"+m;


  }
//METODOS FERIA----------------------------------
  //CANTIDAD DE AUSPICIANTES DE LA FERIA
public int cantidadAus(){
  int cantidad=0;
  if (lstAuspiciantes==null){
    cantidad = 0;//NO HAY AUSPICIANTES EN LA FERIA
  }else{
    cantidad = lstAuspiciantes.size();
  }
  return cantidad;
}
  
  //EDITAR INFORMACION DE LA FERIA
  public void editarFeria(){
      Scanner sc = new Scanner(System.in);

      String fechaIni = this.getFechaIni();
      String[] fecha = fechaIni.split("-");
      int a = Integer.parseInt(fecha[0]);
      int m = Integer.parseInt(fecha[1]);
      int d = Integer.parseInt(fecha[2]);

      LocalDate fechaActual = LocalDate.now();
      LocalDate fechaInicio = LocalDate.of(a, m, d);
// SE COMPRUEBA LA FECHA DE INICIO 
      if (!fechaInicio.isBefore(fechaActual)) {
          //La fecha no ha pasado
          System.out.println("Feria: " +this.getNombre());
          System.out.print("Nombre: ");
          String nombre = sc.nextLine();
          if (!nombre.isEmpty()){
              this.setNombre(nombre);
          }
          System.out.println("");
          System.out.println("Descripción: ");
          String descripcion = sc.nextLine();
          if (!descripcion.isEmpty()){
              this.setNombre(descripcion);
          }
          System.out.println("");
          System.out.println("Lugar: ");
          String lugar = sc.nextLine();
          if (!lugar.isEmpty()){
              this.setNombre(lugar);
          }
          System.out.println("");
          System.out.println("Fecha de incio (YYYY-MM-DD): ");
          String fechaI= sc.nextLine();
          if (!fechaIni.isEmpty()){
              this.setNombre(fechaI);
          }
          System.out.println("");
          System.out.println("Fecha de fin (YYYY-MM-DD): ");
          String fechaFin = sc.nextLine();
          if (!fechaFin.isEmpty()){
              this.setNombre(fechaFin);
          }
          System.out.println("");
          System.out.println("Horario: ");
          String horario = sc.nextLine();
          if (!horario.isEmpty()){
              this.setNombre(horario);
          }
          System.out.println("");
      } else {
          //La fecha ha pasado
          System.out.println("Lo sentimos, la feria ya está en curso. No se puede editar");
      }
      sc.close();
  }

//METODOS DE STAND-----------------------------------------
  //INFORMACION DEL PROPIETARIO DEL STAND
  public void infoStand(Stand std){
      std.toString();
      Persona ausoemp = std.getOwner();
      if(ausoemp!=null){
      ausoemp.toString();   
      }else{
        System.out.println("");
      }
      
  }
  
  //FIJAR STAND
  public void fijarStands(){
    // Asigna valores a las secciones
    String[] letras = {"A","B","C","D"};
    Seccion[] seccionesFe1 = new Seccion[4];
    for(int i=0;i<seccionesFe1.length;i++){
      seccionesFe1[i] = new Seccion();
      seccionesFe1[i].setId(letras[i]);
      seccionesFe1[i].setCantStands(1);
    }
      // Asigna el arreglo de secciones a la feria
      this.setSecciones(seccionesFe1);
     //CAMBIO IMPORTANTE
      // Crea los stands
      for(int j=0;j<seccionesFe1.length;j++){
        //lista de stands
        //for(Stand stand1: this.getSecciones()[j].getListStands()){
        ArrayList<Stand> stands = new ArrayList<>();
        Stand stand1 = new Stand();
        stand1.setNum(1);
        stand1.setReservado(false);
        stands.add(stand1);
        this.getSecciones()[j].setArrayStands(stands);
        //}
      }
      //sc.close();
    }
  public void fijarStands(int rn){
    String[] letras = {"A", "B", "C", "D"};
        Seccion[] seccionesFe1 = new Seccion[4];
        Random random = new Random();

        // Crea las secciones y asigna el arreglo de secciones a la feria
        for (int i = 0; i < seccionesFe1.length; i++) {
            seccionesFe1[i] = new Seccion();
            seccionesFe1[i].setId(letras[i]);
            int k = random.nextInt(rn) + 1;
            seccionesFe1[i].setCantStands(k);

            // Crea los stands
            ArrayList<Stand> stands = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                Stand stand1 = new Stand();
                stand1.setNum(j + 1);
                stand1.setReservado(false);
                stands.add(stand1);
            }

            // Asigna la lista de stands a la sección
            seccionesFe1[i].setArrayStands(stands);
        }

        // Asigna el arreglo de secciones a la feria
        this.setSecciones(seccionesFe1);
  }
    public void fijarStandsFeria(){
        Scanner sc = new Scanner(System.in);
        // Asigna valores a las secciones
        String[] letras = {"A","B","C","D"};
        Seccion[] seccionesFe1 = new Seccion[4];
        for(int i=0;i<seccionesFe1.length;i++){
          seccionesFe1[i] = new Seccion();
          seccionesFe1[i].setId(letras[i]);
          int cant = sc.nextInt();
          seccionesFe1[i].setCantStands(cant);
        }
          // Asigna el arreglo de secciones a la feria
          this.setSecciones(seccionesFe1);

          // Crea los stands
          for(int j=0;j<seccionesFe1.length;j++){
            int cantidad = seccionesFe1[j].getCantStands();
            //lista de stands
            ArrayList<Stand> stands = new ArrayList<>();
              for(int k = 0; k<cantidad; k++){
            Stand stand1 = new Stand();
            stand1.setNum(k+1);
            stand1.setReservado(false);
            stands.add(stand1);
            this.getSecciones()[j].setArrayStands(stands);
              }
            
          }
          sc.close();
        }


  //MOSTRAR DISTRIBUCION DE LAS SECCIONES DE LOS STANDS
  public void mostrarDistribucion(){
      System.out.println("Feria: " +this.getNombre());
      System.out.println("Distribucion de Stands: ");
        secciones = this.getSecciones();
      for(Seccion s: secciones){
          String letra = s.getId();
          ArrayList<Stand> stands= s.getListStands();
        
          for(Stand st: stands){
            int i=st.getNum();
            if(st.getReservado()){
            System.out.print("["+letra+i+"*]");
          }else{
            System.out.print("["+letra+i+"]");
            } 
          }
          System.out.println(" ");
        }
  }
//BUSCAR STAND ----------------------------------------------------------
  public Stand buscarStand(String ln){
    Stand standBuscado = new Stand();
    char letra = ln.charAt(0);
    int numero = Character.getNumericValue(ln.charAt(1));
    for(Seccion s : secciones){
      if(s.getId().equals(letra)){
        ArrayList<Stand> stands = s.getListStands();
        for(Stand st: stands){
          if(!st.getReservado() && st.getNum()==numero){
            standBuscado=st;  
          }
        }
      }
    }
    return standBuscado;    
  }
//RESERVAR STAND --------------------------------------------
  public void reservarStand(String ln){ 
      //El formato del código es LetraNúmero Ej: A6, donde la letra es la sección y el número es del stand
      Scanner sc = new Scanner(System.in);
      //boolean estado;
      char letra = ln.charAt(0);
      String letraS = String.valueOf(letra);
      int numero = Character.getNumericValue(ln.charAt(1));
      Emprendedor coincidenciaE = new Emprendedor();
      AuspicianteEnFeria coincidenciaA = new AuspicianteEnFeria();
      Stand standBuscado = new Stand();
      for(Seccion s : this.secciones){
        if(s.getId().equals(letraS)){
          for(Stand st: s.getListStands()){
            if(!st.getReservado() && st.getNum()==numero){
              standBuscado = st;          
              System.out.println("El stand está disponible");
              System.out.println("Ingrese su cedula: ");
              String cedula = sc.nextLine();
              
              //Se itera lstEmprendedor para buscar coincidencia, si existe se albergará en una variable el emprendedor  e
              
              for(Emprendedor e: lstEmprendedores){
                 if(e.getCedula().equals(cedula)){
               
                   coincidenciaE = e;
                }
              }
              //for para evaluar auspiciantes, si existe coincidencia se albergará en una variable auspiciantes a
              if(this.lstAuspiciantes.size()>0){
              for(AuspicianteEnFeria a: lstAuspiciantes){
                if(a.getAuspiciante().getCedula().equals(cedula)){
                  coincidenciaA =a;
                }
                }
              }
              
              // Si e existe, validamos lo de los 2 stands, dependiendo se asigna el stand
              if(coincidenciaE!=null){
                ArrayList lstStandsE= coincidenciaE.getLstStands();
                lstAuspiciantes = new ArrayList<>();
                lstEmprendedores = new ArrayList<>();
                if(!lstStandsE.isEmpty()){
                int cantidad = lstStandsE.size();
                if(cantidad<2){
                  lstStandsE.add(st);
                  st.setOwner(coincidenciaE);
                }else{
                  coincidenciaE.getLstStands().add(st);
                  st.setOwner(coincidenciaE);
                }
                }else{
                  System.out.println("Lo sentimos, "+coincidenciaE.getNombre()+" ya posee el máximo de stands asignados posibles (2)");
                  
                }
              }
              if(coincidenciaA!=null){
                // Si a existe, validamos que no tenga stand
                ArrayList lstStandsA = coincidenciaA.getAuspiciante().getLstStands();
                int cantidad = lstStandsA.size();
                if(cantidad==0){
                  lstStandsA.add(ln);
                  standBuscado.setOwner(coincidenciaA.getAuspiciante());
                  
                }else{
                  System.out.println("Lo sentimos, "+coincidenciaA.getAuspiciante().getNombre()+" ya posee un stand asignado");
                  
                }
              }
              // si ni a ni e existen, se pide otro código
              if(coincidenciaA==null && coincidenciaE==null){
                System.out.println("Lo sentimos, ha ingresado un código inválido");
                
              }
            }
          }
        }
      }
    sc.close();
  }

  //METODOS DE EMPRENDEDORES-----------------------------
  //CONSULTAR EMPRENDEDORES
public void consultarEmprendedores(){
    for(Emprendedor emp: this.lstEmprendedores){
      if(emp.getLstStands().size() > 0){
                System.out.println(emp.toString());
        }
    }
}
//REGISTRAR EMPRENDEDORES
  public void registrarEmprendedor(Emprendedor emp){ 
    ArrayList<Emprendedor> lstEmprendedores = new ArrayList<Emprendedor>();
    lstEmprendedores.add(emp);
  }
    
// EDITAR EMPRENDEDORES 
  public void editarEmprendedor(String cedula,ArrayList<Emprendedor> lstEmprendedores){
    Emprendedor emp = new Emprendedor();
    for(Emprendedor e : lstEmprendedores){
      if(e.getCedula().equals(cedula)){
        emp = e;
      }
    } 
    emp.editarEmprendedor();
    emp.toString();
  }
} 



