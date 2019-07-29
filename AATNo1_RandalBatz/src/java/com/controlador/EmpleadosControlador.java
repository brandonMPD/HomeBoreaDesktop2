package com.controlador;

import com.dao.vehiculos.EmpleadosDao;
import com.modelo.vehiculos.Empleados;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped 
public class EmpleadosControlador {
    private Empleados emp = new Empleados();
    private List<Empleados> lstEmpleado;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<Empleados> getLstEmpleado() {
        return lstEmpleado;
    }

    public void setLstEmpleado(List<Empleados> lstEmpleado) {
        this.lstEmpleado = lstEmpleado;
    }

    public Empleados getEmp() {
        return emp;
    }

    public void setEmp(Empleados emp) {
        this.emp = emp;
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
        EmpleadosDao dao;
        
        try {
            dao = new EmpleadosDao();
            dao.registrar(emp);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
        
    private void modificar() throws Exception{
        EmpleadosDao dao;
        
        try {
            dao = new EmpleadosDao();
            dao.modificar(emp);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void limpiar(){
        this.emp.setEmp_codigo(0);
        this.emp.setNombre("");
        this.emp.setApellido("");
        this.emp.setTelmovil(0);
        this.emp.setContrasenia("");
        this.emp.setDireccion("");
        this.emp.setCorreo("");
    }
        
    public void listar() throws Exception{
        EmpleadosDao dao;
        try {
            dao = new EmpleadosDao();
            lstEmpleado = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void leerID(Empleados emp) throws Exception{
        EmpleadosDao dao;
        Empleados temp;
        try {
            dao = new EmpleadosDao();
            temp = dao.leerID(emp);
            this.limpiar();
            if (temp != null ) {
                this.emp = temp;
                this.accion = "Modificar";
            }
             
        } catch (Exception e) {
            throw e;
        }
    }   
    public void eliminar(Empleados emp) throws Exception{
        EmpleadosDao dao;
        try {
            dao = new EmpleadosDao();
            dao.eliminar(emp);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
