package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Prueba {
    
    public static void main(String[] args) throws SQLException, Exception {
        DaoConexion cn = new DaoConexion();
        cn.Conectar();
        cn.Cerrar();
        }
        
    
}
