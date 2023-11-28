//PAQUETE
package modelo;

//IMPORTS
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//CLASE
public class Persona{
    //VARIABLES DE INSTANCIA
    protected final String cedula;
    protected String nombre;
    protected String telefono;
    protected String email;
    protected String direccion;
    protected String web;
    protected String owner;
    protected List<RedSocial> lstRedes;
    

    //CONSTRUCTORES
public Persona(String cedula, String nombre, String telefono,
               String email, String direccion, String web, String owner,
               List<RedSocial> lstRedes) {
    this.cedula = cedula;
    this.nombre = nombre;
    this.telefono = telefono;
    this.email = email;
    this.direccion = direccion;
    this.web = web;
    this.owner = owner;
    this.lstRedes = lstRedes;
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
        

    public List<RedSocial> getLstRedes() {
        return lstRedes;
    }

    public void setLstRedes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántas redes sociales tiene? ");
        int cR = scanner.nextInt();

        scanner.nextLine();
        
        for (int i = 0; i < cR; i++) {
            System.out.println("Elija la red social TWITTER, FACEBOOK, INSTAGRAM, LINKEDIN, PINTEREST, YOUTUBE");
            System.out.println("Tendrá que ser escribir correctamente el nombre de la red social: ");
            String redString = scanner.nextLine().toUpperCase();
            try {
                RedSocial red = RedSocial.valueOf(redString);

                System.out.print("Ingrese su usuario en " + red + ": ");
                String usuario = scanner.nextLine();

                CuentaRedSocial nuevaRed = new CuentaRedSocial(red, usuario);
                lstRedes.add(nuevaRed);
                
                }catch (IllegalArgumentException e) {
                System.out.println("Red social no válida. Intente de nuevo.");
                i--;
                }
        }
    }
    
    //METODOS
    //TOSTRING
    @Override
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
 
}
