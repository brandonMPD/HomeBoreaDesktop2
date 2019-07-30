package controlador;

import dao.RegionDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Regiones;

@ManagedBean
@ViewScoped 
public class RegionesControlador {
    private Regiones reg = new Regiones();
    private List<Regiones> lstRegiones;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    
    public List<Regiones> getLstRegiones() {
        return lstRegiones;
    }

    public void setLstRegiones(List<Regiones> lstRegiones) {
        this.lstRegiones = lstRegiones;
    }
    
    

    public Regiones getReg() {
        return reg;
    }

    public void setReg(Regiones reg) {
        this.reg = reg;
    }
    
    public void operar() throws Exception{
        switch(accion){
            case "Registrar":
                this.registrar();
                this.limpiar();
            break;
            case "Modificar":
                this.modificar();
                this.limpiar();
            break;
        }
    }
    
    private void registrar() throws Exception{
        RegionDao dao;
        
        try {
            dao = new RegionDao();
            dao.registrar(reg);
            this.limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void limpiar(){
        this.reg.setCod_region(0);
        this.reg.setNombre("");
        this.reg.setDescripcion("");
    }
    
    private void modificar() throws Exception{
        RegionDao dao;
        
        try {
            dao = new RegionDao();
            dao.modificar(reg);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
        
    public void listar() throws Exception{
        
        RegionDao dao;
        try {
            dao = new RegionDao();
            lstRegiones = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void leerID(Regiones reg) throws Exception{
        RegionDao dao;
        Regiones temp;
        try {
            dao = new RegionDao();
            temp = dao.leerID(reg);
            if (temp != null ) {
                this.reg = temp;
                this.accion = "Modificar";
            }
             
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(Regiones reg) throws Exception{
        RegionDao dao;
        try {
            dao = new RegionDao();
            dao.eliminar(reg);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
