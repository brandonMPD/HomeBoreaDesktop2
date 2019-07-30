
package interfaces;

import Modelo.Personas;
import java.util.ArrayList;

public interface PersonasInterface {
    public String insertarPersonas(Personas personas);
    public String eliminarPersonas(Personas personas);
    public String modificarPersona(Personas personas);
    public Personas buscarPersona(int persona_id);
    public ArrayList<Personas> listarPersonas();
    
}
