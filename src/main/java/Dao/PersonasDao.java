package Dao;

import Modelo.Empleados;
import Modelo.Personas;
import interfaces.PersonasInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonasDao implements PersonasInterface {

    ConexionBorea conexion = new ConexionBorea();
    private String mensaje;
    Personas personas;
    private String sql;
    private PreparedStatement ejecutar;
    ResultSet resultadoSelect;

    @Override
    public String insertarPersonas(Personas personas) {
        try {
            conexion.abrirConexion();
            sql="Insert into personas values(?,?,?,?,?,?,?,?,?)";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, personas.getPersona_id());
            ejecutar.setString(2, personas.getNombre());
            ejecutar.setString(3, personas.getApellido());
            ejecutar.setString(4, personas.getCorreo());
            ejecutar.setString(5,personas.getDireccion());
            ejecutar.setLong(6, personas.getDpi());
            ejecutar.setInt(7, personas.getTelefono());
            ejecutar.setInt(8, personas.getEstado_id());
            ejecutar.setInt(9, personas.getGenero_id());
            mensaje="La persona se Agrego Correctamente";
            
        } catch (Exception e) {
            mensaje="Datos no se pudieron agregar"+e;
        }finally{
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String eliminarPersonas(Personas personas) {
        try {
            conexion.abrirConexion();
            sql="delete from personas where persona_id=?";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, personas.getPersona_id());
            ejecutar.executeUpdate();
            mensaje="los datos se eliminaron correctamente";
        } catch (Exception e) {
            mensaje="no se pudo Eliminar: "+e;
        }finally{
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarPersona(Personas personas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personas buscarPersona(int persona_id) {
        try {
            conexion.abrirConexion();
            sql="select * from personas where persona_id=?";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, persona_id);
            resultadoSelect=ejecutar.executeQuery();
            personas.setPersona_id(resultadoSelect.getInt("persona_id"));
            personas.setNombre(resultadoSelect.getString("nombre"));
            personas.setApellido(resultadoSelect.getString("apellido"));
            personas.setCorreo(resultadoSelect.getString("correo"));
            personas.setDireccion(resultadoSelect.getString("direccion"));
            personas.setDpi(resultadoSelect.getLong("dpi"));
            personas.setTelefono(resultadoSelect.getInt("telefono"));
            personas.setEstado_id(resultadoSelect.getInt("estado_id"));
            personas.setGenero_id(resultadoSelect.getInt("genero_id"));
            resultadoSelect.close();
        } catch (Exception e) {
            mensaje="No se encontro ningun dato"+e;
        }finally{
            conexion.cerrarConexion();
        }
        return personas;
        
    }

    @Override
    public ArrayList<Personas> listarPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
