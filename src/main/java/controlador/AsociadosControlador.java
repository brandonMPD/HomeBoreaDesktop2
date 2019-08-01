package controlador;

import Dao.AsociadosDao;
import Modelo.Asociados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.VistaAsociados;

public class AsociadosControlador implements ActionListener{
    VistaAsociados vista = new VistaAsociados();
    AsociadosDao dao = new AsociadosDao();
    Asociados modelo = new Asociados();

    public AsociadosControlador(VistaAsociados vistaAsociados) {
        this.vista = vista;

        vista.jBtnAgregar.addActionListener(this);
        vista.jBtnBuscar.addActionListener(this);
        vista.jBtnEliminar.addActionListener(this);
        vista.jBtnModificar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnAgregar) {
            
        }
        
    }
    
}
