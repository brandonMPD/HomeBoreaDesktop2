package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Regiones;

public class RegionDao extends DaoConexion{
    
    public void registrar(Regiones reg) throws Exception{ 
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO regiones (cod_region, nombre, descripcion) values(?, ?, ?)");
            st.setInt(1, reg.getCod_region());
            st.setString(2, reg.getNombre());
            st.setString(3, reg.getDescripcion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    public List<Regiones> listar() throws Exception{
        List<Regiones> listar;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT cod_region, nombre, descripcion FROM regiones");
            rs = st.executeQuery();
            listar = new ArrayList();
            while(rs.next()){
                Regiones reg = new Regiones();
                reg.setCod_region(rs.getInt("cod_region"));
                reg.setNombre(rs.getString("nombre"));
                reg.setDescripcion(rs.getString("descripcion"));
                listar.add(reg);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        
        return listar;
    }
    
    public Regiones leerID(Regiones reg) throws Exception{
        Regiones regi = null;
        ResultSet rs;
    
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT cod_region, nombre, descripcion FROM regiones WHERE cod_region=? ");
            st.setInt(1, reg.getCod_region());
            rs = st.executeQuery();
            while(rs.next()){
                regi = new Regiones();
                regi.setCod_region(rs.getInt("cod_region"));
                regi.setNombre(rs.getString("nombre"));
                regi.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return regi;
    }
    public void modificar(Regiones reg) throws Exception{ 
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE regiones SET nombre=?, descripcion=? WHERE cod_region=?");
            st.setString(1, reg.getNombre());
            st.setString(2, reg.getDescripcion());
            st.setInt(3, reg.getCod_region());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public void eliminar(Regiones reg) throws Exception{ 
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM regiones WHERE cod_region=?");
            st.setInt(1, reg.getCod_region());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    
}
