/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.ImagenesServicio;
import interfaces.ImageServiceInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ImgServiceDao implements ImageServiceInterface {
    
    private String mensaje;
    private String mysql;
    private PreparedStatement ejecutar;
    private ResultSet seleccionar;
    private int registrosAfectados=0;
    
    ConexionBorea conex = new ConexionBorea();

    @Override
    public String saveImgService(ImagenesServicio img) {
        try {
                conex.abrirConexion();
                
                mysql= "insert into imageners_servicios values(?,?,?)";
                
                ejecutar = conex.getMiConexion().prepareStatement(mysql);
                
                ejecutar.setInt(1, img.getImagenservicio_id());
                ejecutar.setInt(2, img.getServicio_id());
                ejecutar.setString(3, img.getImagen());
                
               registrosAfectados =  ejecutar.executeUpdate();
               
               if(registrosAfectados==0){
                   mensaje="NO SE ENCONTRO BASE_DATOS ";
               }
               else{
                   mensaje="IMGAGEN ALMACENADA";
               }   
        } 
        catch (Exception e) {
            mensaje="ERROR EN DAO_IMAGE_SERVICE_DAO : "+e;
        }
        finally{
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String updateService(ImagenesServicio img) {
        try {
            conex.abrirConexion();
            
            mysql="update imagenes_servicios set servicos_id=?, imagene=? where imagenservicio=?";
            
            ejecutar = conex.getMiConexion().prepareStatement(mysql);
            
            ejecutar.setInt(1, img.getServicio_id());
            ejecutar.setString(2, img.getImagen());
            ejecutar.setInt(3, img.getImagenservicio_id());
            
            registrosAfectados = ejecutar.executeUpdate();
            
            if(registrosAfectados==0){
                mensaje="NO SE ENCONTRO EL REGISTRO ";
            }
            else{
                mensaje="REGISTRO MODIFICADO ";
            }
        } 
        catch (Exception e) {
            mensaje="ERORR EN DAO_IMAGE_SERVICE : " +e;
        }
        finally{
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String deleteService(ImagenesServicio img) {
        
        try {
            conex.abrirConexion();
            
            mysql="delete from imagenes_servicios where imagenservicio=?";
            
            ejecutar = conex.getMiConexion().prepareStatement(mysql);
            
            ejecutar.setInt(1, img.getImagenservicio_id());
            
            registrosAfectados = ejecutar.executeUpdate();
            
            if(registrosAfectados == 0){
                mensaje="NO SE ENCONTRO EL REGISTRO";
            }
            else{
                mensaje="REGISTRO ELIMINADO";
            }
        } 
        catch (Exception e) {
            mensaje="REGISTRO ELIMINADO "+e;
        }
        finally{
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public ImagenesServicio buscarImgService(int img_service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ImagenesServicio> listarImgServices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
