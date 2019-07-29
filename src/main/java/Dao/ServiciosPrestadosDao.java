/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.ServiciosPrestados;
import interfaces.ServiciosPrestadosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServiciosPrestadosDao implements ServiciosPrestadosInterface{
    ConexionBorea conex = new ConexionBorea();
           private PreparedStatement ejecutar;
    private ResultSet resultadoSelect;

    private String mensaje;
    private String sql;
    private int contarRegistros = 0;

    @Override
    public String insertServiciosPrestados(ServiciosPrestados serviciosPrestados) {
         try {
            conex.abrirConexion();
            sql="INSERT INTO servicios_prestados  values(?,?,?,?,?,?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(sql);
            
            ejecutar.setInt(1, serviciosPrestados.getServicioprestado_id());
            ejecutar.setInt(2, serviciosPrestados.getCliente_id());
            ejecutar.setInt(3, serviciosPrestados.getServicio_id());
            ejecutar.setInt(4, serviciosPrestados.getCalificacion_cliente());
            ejecutar.setString(5, serviciosPrestados.getDescripcion_cliente());
            ejecutar.setInt(6, serviciosPrestados.getCalificacion_asociado());
            ejecutar.setString(7, serviciosPrestados.getDescripcion_asociado());
            
            contarRegistros = ejecutar.executeUpdate();
            
            if(contarRegistros==0){
                mensaje="No se puede registrar";
            }else{
                mensaje = "Registro realizado con exito";
            }
              
        } 
        catch (Exception e) {
            mensaje ="LOS DATOS NO FUERON GUARDARON"+e;
        }
        finally{
            conex.cerrarConexion();
        }
        return mensaje;

              
        } 

    @Override
    public String updateServiciosPrestados(ServiciosPrestados serviciosPrestados) {
         try {
            conex.abrirConexion();
            sql="update servicios_prestados  set servicioprestado_id=?, cliente_id=?, servicio_id=?, calificacion_cliente=?, descripcion_cliente=?, descripcion_cliente=?, descripcion_asociado=? where servicios_prestados=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);
            
           ejecutar.setInt(1, serviciosPrestados.getServicioprestado_id());
            ejecutar.setInt(2, serviciosPrestados.getCliente_id());
            ejecutar.setInt(3, serviciosPrestados.getServicio_id());
            ejecutar.setInt(4, serviciosPrestados.getCalificacion_cliente());
            ejecutar.setString(5, serviciosPrestados.getDescripcion_cliente());
            ejecutar.setInt(6, serviciosPrestados.getCalificacion_asociado());
            ejecutar.setString(7, serviciosPrestados.getDescripcion_asociado());
            
            contarRegistros = ejecutar.executeUpdate();
            
            if(contarRegistros==0){
                mensaje="No se puede registrar";
            }else{
                mensaje = "Registro realizado con exito";
            }
              
        } 
        catch (Exception e) {
            mensaje ="LOS DATOS NO FUERON MODIFICARON"+e;
        }
        finally{
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String deleteServiciosPrestados(ServiciosPrestados serviciosPrestados) {
              try {
            conex.abrirConexion();
            sql="DELETE FROM servicios_prestados  where servicios_prestados=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);
            
          
           ejecutar.setInt(1, serviciosPrestados.getServicioprestado_id());
            
            contarRegistros = ejecutar.executeUpdate();
            
            if(contarRegistros==0){
                mensaje="NO SE ENCONTRO EL REGISTRO";
            }else{
                mensaje = "DATOS ELIMINADOS";
            }
              
        } 
        catch (Exception e) {
            mensaje ="LOS DATOS NO SE ELIMINARON"+e;
        }
        finally{
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public ServiciosPrestados buscarServiciosPrestados(int servicioprestado_id) {
         ServiciosPrestados serviciosp = new ServiciosPrestados();
        try {
            conex.abrirConexion();
            sql = "select * from servicios where sevicio_id=" ;
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            resultadoSelect.next();

            serviciosp.setServicioprestado_id(resultadoSelect.getInt("servicioprestado_id"));
            serviciosp.setCliente_id(resultadoSelect.getInt("cliente_id"));
            serviciosp.setServicio_id(resultadoSelect.getInt("servicio_id"));
            serviciosp.setCalificacion_cliente((byte) resultadoSelect.getInt("calificacion_cliente"));
             serviciosp.setDescripcion_cliente(resultadoSelect.getString("descripcion_cliente"));
            serviciosp.setCalificacion_asociado((byte) resultadoSelect.getInt("calificacion_asociado"));
             serviciosp.setDescripcion_asociado(resultadoSelect.getString("descripcion_asociado"));
             
            
        } catch (Exception e) {
            System.out.println("ERROR EN BUSQUEDA" + e);

        } finally {
            conex.cerrarConexion();
        }
        return serviciosp;
    }

    @Override
    public ArrayList<ServiciosPrestados> listarServiciosPrestados() {
         ServiciosPrestados serp ;
        ArrayList<ServiciosPrestados> lista = new ArrayList();

        try {
            conex.abrirConexion();
            sql = "select * from servicios";

            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            while (resultadoSelect.next()) {
                serp = new ServiciosPrestados();

            serp.setServicioprestado_id(resultadoSelect.getInt("servicioprestado_id"));
            serp.setCliente_id(resultadoSelect.getInt("cliente_id"));
            serp.setServicio_id(resultadoSelect.getInt("servicio_id"));
            serp.setCalificacion_cliente((byte) resultadoSelect.getInt("calificacion_cliente"));
             serp.setDescripcion_cliente(resultadoSelect.getString("descripcion_cliente"));
            serp.setCalificacion_asociado((byte) resultadoSelect.getInt("calificacion_asociado"));
             serp.setDescripcion_asociado(resultadoSelect.getString("descripcion_asociado"));
             


                lista.add(serp);
            }

            ejecutar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN DAO_LISTA_SUBCATEGORIAS" + e);
        } finally {
            conex.cerrarConexion();
        }

        return lista;
    }
    }



