package Dao;

import Modelo.Empleados;
import interfaces.EmpleadosInterface;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class EmpleadosDao implements EmpleadosInterface {

    ConexionBorea conexion = new ConexionBorea();
    private String mensaje;
    Empleados empleado = new Empleados();
    private String sql;
    private PreparedStatement ejecutar;
    

    @Override
    public Empleados buscarEmpleados(String usuario, String contraseña) {
        try {
            conexion.abrirConexion();
            
            
        } catch (Exception e) {
        }
        return empleado;
    }

    @Override
    public ArrayList<Empleados> listarEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarEmpleados(Empleados empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarEmpleado(Empleados empleado) {
        try {
            conexion.abrirConexion();
            sql="Insert into Empleados values(?,?,?,?)";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, empleado.getEmpleado_id());
            ejecutar.setString(2, empleado.getUsuario());
            ejecutar.setString(3,empleado.getContraseña());
            ejecutar.setInt(4,empleado.getTipoempleado_id());
            ejecutar.executeUpdate();
            mensaje="Datos Almacenados";
            
            
        } catch (Exception e) {
            mensaje="Datos no almacenados";
        }
        return mensaje;
    }

}
