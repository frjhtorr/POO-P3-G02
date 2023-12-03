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


