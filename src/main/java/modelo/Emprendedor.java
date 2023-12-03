//PAQUETE
package modelo;

//IMPORTS
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//CLASE
public class Emprendedor extends Persona {
    //VARIABLES DE INSTANCIA
    private String servicios;
  

    //CONSTRUCTORES
  public Emprendedor(){
    super();
  }
public Emprendedor(String cedula, String nombre, String telefono,
        String email, String direccion, String web, String owner,
        ArrayList<CuentaRedSocial> lstRedes, String servicios) {

    super(cedula, nombre,telefono,email,direccion,web,owner,lstRedes);
    this.servicios = servicios;
    }

    //METODOS
    //getters and setters
    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;}


        //CREAR EMPRENDEDOR
public Emprendedor crearEmprendedor(ArrayList<Emprendedor> listaEmprendedores){
    System.out.println("INGRESE LOS DATOS DEL EMPRENDIMIENTO");
    Scanner sc = new Scanner(System.in);
    String c;
    boolean cedulaValida;
    Emprendedor emp = new Emprendedor();
    do {    
        System.out.println("Ingrese el número de cédula o RUC:");
        c = sc.nextLine();
        cedulaValida = validarCedula(c, listaEmprendedores);
        if (!cedulaValida) {
            System.out.println("Ya existe un emprendedor con ese número de cédula o RUC. Intente de nuevo.");
        }else{ System.out.println("Cedula válida");}
    } while (!cedulaValida);
    Persona p = minimetodo2();
    System.out.println("Ingrese la descripción de los servicios que ofrece:");
    String descripcion = sc.nextLine();
    System.out.println("Ingrese el numero de redes que tiene: ");
    int valor = sc.nextInt();
    p.setLstRedes(valor);
  if (p instanceof Emprendedor ) {
    Emprendedor nuevoEmprendedor = (Emprendedor) p;
      nuevoEmprendedor.setServicios(descripcion);
      
      emp = nuevoEmprendedor;
      sc.close();
  }
    //nuevoEmprendedor.setServicios(descripcion); 

      
    sc.close();
    return emp;
}
        //MOSTRAR INFORMACION
    public void mostrarInformacion() {
        System.out.println("-----------------------------------------");
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
    }

        //TOSTRING
    @Override
    public String toString() {
        return super.toString() +
               "Servicio: " + servicios+ "\n"+
               "Stands asignados"+ this.lstStands;
    }

        // EDITAR EMPRENDEDOR --------------------------------------
public void editarEmprendedor() {
    System.out.println("DATOS ACTUALES DEL EMPRENDEDOR:");
    System.out.println(toString());
    
    this.minimetodo();
    System.out.println("8. Servicios ");

    Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();
  
    scanner.nextLine();
    
    if (option > 0 && option < 8){
        this.editarPersona(option);
    }
    switch (option) {
        case 8 :
            System.out.println("Ingrese los nuevos servicios:");
            String servicios = scanner.nextLine();
            setServicios(servicios);

        }
    
  toString();
}

    
}
}
