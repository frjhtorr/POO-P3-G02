import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Arturo
 */
public class Seccion {

    //ATRIBUTOS -----------------------------------------------
    
    private int cantStands;
    private String id;
    private ArrayList<Stand> ArrayStands;

    //GETTERS AND SETTERS ------------------------------------------------
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

    public ArrayList<Stand> getListStands() {
        return ArrayStands;
    }

    public void setArrayStands(ArrayList<Stand> ArrayStands) {
        this.ArrayStands = ArrayStands;
    }
}

 
