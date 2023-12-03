//PAQUETE
package modelo;

//IMPORTS
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


//CLASE
public class Auspiciante extends Persona {
    //VARIABLES DE INSTANCIA
    private SectorCubierto sector;
  

    //CONSTRUCTORES
 public Auspiciante(String cedula, String nombre, String telefono,
      String email, String direccion, String web, String owner,
      ArrayList<CuentaRedSocial> lstRedes, SectorCubierto sector) {

    super(cedula, nombre, telefono, email, direccion, web, owner, lstRedes);
    this.sector = sector;
  }
  public Auspiciante(){
    super(); 
  }
  // METODOS -----------------------------------------------------------------
  // getters and setters
  public SectorCubierto getSector() {
    return sector;
  }

  // STRING A LIST OBJETOS
  public void setSector(SectorCubierto sC){
    this.sector = sC;
    } 


  // EDITAR AUSPICIANTE ---------------------------------------------------
  public void editarAuspiciante() {
        System.out.println("DATOS ACTUALES DEL AUSPICIANTE:");
        System.out.println(this.toString());

        this.minimetodo();
        System.out.println("8. Sectores cubiertos");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option < 0 || option > 8) {
            this.editarPersona(option);
        }

        switch (option) {
            case 8:
                System.out.println("Ingrese los sectores cubiertos:");
                String sector = scanner.nextLine();
                SectorCubierto sectorCubierto = SectorCubierto.valueOf(sector);
                setSector(sectorCubierto);
                break;  // Agrega la instrucción break para evitar caer al caso default

            default:
                System.out.println("No hubo cambios");
        }

        scanner.close();
    }

    
}
