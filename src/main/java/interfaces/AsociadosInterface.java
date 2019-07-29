package interfaces;

import Modelo.Asociados;
import java.util.ArrayList;

public interface AsociadosInterface {
    public Asociados buscarAsociados(Asociados asociados);
    public ArrayList<Asociados> listarAsociados();
    public String eliminarAsociados(Asociados asociados);
    public String insertarAsociados(Asociados asociados);
    
}
