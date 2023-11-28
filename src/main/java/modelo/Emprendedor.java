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
public Emprendedor(String cedula, String nombre, String telefono,
        String email, String direccion, String web, String owner,
        List<RedSocial> lstRedes, String servicios) {
    
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

        // VALIDAR CEDULA
public static boolean validarCedulaUnica(String cedula, ArrayList<Emprendedor> listaEmprendedores) {
    for (Emprendedor emprendedor : listaEmprendedores) {
        if (emprendedor.getCedula().equals(cedula)) {
            return false;
        }
    }
    return true; 
    
    //REVISAR HERENCIA
    }

        //REGISTRAR EMPRENDEDOR
public Emprendedor registrarEmprendedor(ArrayList<Emprendedor> listaEmprendedores){
    System.out.println("INGRESE LOS DATOS DEL EMPRENDIMIENTO");
    Scanner sc = new Scanner(System.in);
    String c;
    boolean cedulaValida;
    do {    

        System.out.println("Ingrese el número de cédula o RUC:");
        c = sc.nextLine();
        cedulaValida = validarCedulaUnica(c, listaEmprendedores);
        if (!cedulaValida) {
            System.out.println("Ya existe un emprendedor con ese número de cédula o RUC. Intente de nuevo.");
        }
    } while (!cedulaValida);//REVISAR SI ES NECESARIO ITETAR HASTA Q INGRESE UNO CORRECTO O VOLVER AL MENU.


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
    System.out.println("Ingrese la descripción de los servicios que ofrece:");
    String s = sc.nextLine();
    Emprendedor nuevoEmprendedor = new Emprendedor(c, n, t, e, d, w, o, new ArrayList<>(),s);
        nuevoEmprendedor.setLstRedes();
    // VOLVER AL MENU EMPRENDIMIENTO
   
    sc.close();
    return nuevoEmprendedor;
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
               "Servicio: " + servicios+ "\n";
    }
    
        // EDITAR EMPRENDEDOR
public void editarEmprendedor() {
    System.out.println("DATOS ACTUALES DEL EMPRENDEDOR:");
    System.out.println(toString());
    System.out.println("-----------------------------------------");
    System.out.println("¿Qué campo desea editar?");
    System.out.println("1. Nombre");
    System.out.println("2. Teléfono");
    System.out.println("3. Email");
    System.out.println("4. Dirección");
    System.out.println("5. Sitio web");
    System.out.println("6. Persona responsable");
    System.out.println("7. Servicios");
    System.out.println("8. Redes sociales");

    Scanner scanner = new Scanner(System.in);
    int opcion = scanner.nextInt();
    scanner.nextLine();

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
            System.out.println("Ingrese los nuevos servicios:");
            setServicios(scanner.nextLine());
            }
        case 8 -> {
            System.out.println("Ingrese las nuevas redes sociales:");
            setLstRedes();
            }
        default -> System.out.println("Opción no válida");
    
        // VOLVER AL MENU EMPRENDIMIENTO
    
    }
}
}