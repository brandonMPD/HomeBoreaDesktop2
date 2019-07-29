package com.dao.vehiculos;

import com.modelo.vehiculos.Empleados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDao extends ConexionDao{
    
    public void registrar(Empleados emp) throws Exception{ 
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO empleados (emp_codigo, nombre, apellido, telmovil, contrasenia, direccion, correo) values(?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, emp.getEmp_codigo());
            st.setString(2, emp.getNombre());
            st.setString(3, emp.getApellido());
            st.setInt(4, emp.getTelmovil());
            st.setString(5, emp.getContrasenia());
            st.setString(6, emp.getDireccion());
            st.setString(7, emp.getCorreo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    public List<Empleados> listar() throws Exception{
        List<Empleados> listar;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT emp_codigo, nombre, apellido, telmovil, contrasenia, direccion, correo FROM empleados");
            rs = st.executeQuery();
            listar = new ArrayList();
            while(rs.next()){
                Empleados emp = new Empleados();
                emp.setEmp_codigo(rs.getInt("emp_codigo"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setTelmovil(rs.getInt("telmovil"));
                emp.setContrasenia(rs.getString("contrasenia"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setCorreo(rs.getString("correo"));
                listar.add(emp);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        
        return listar;
    }
    
    public Empleados leerID(Empleados emp) throws Exception{
        ResultSet rs;
    
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT emp_codigo, nombre, apellido, telmovil, contrasenia, direccion, correo FROM empleados");
            st.setInt(1, emp.getEmp_codigo());
            rs = st.executeQuery();
            while(rs.next()){
                emp = new Empleados();
                emp.setEmp_codigo(rs.getInt("emp_codigo"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setTelmovil(rs.getInt("telmovil"));
                emp.setContrasenia(rs.getString("contrasenia"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setCorreo(rs.getString("correo"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return emp;
    }
    public void modificar(Empleados emp) throws Exception{ 
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE empleados SET nombre=?, apellido=?, telmovil=?, contrasenia=?, direccion=?, correo=? WHERE emp_codigo=?");
            st.setString(1, emp.getNombre());
            st.setString(2, emp.getApellido());
            st.setInt(3, emp.getTelmovil());
            st.setString(4, emp.getContrasenia());
            st.setString(5, emp.getDireccion());
            st.setString(6, emp.getCorreo());
            st.setInt(7, emp.getEmp_codigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public void eliminar(Empleados emp) throws Exception{ 
        PreparedStatement ejecutar;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM empleados WHERE emp_codigo=?" );
            st.setInt(1, emp.getEmp_codigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
            
        }finally{
            this.Cerrar();
        }
    }
    
    
}
