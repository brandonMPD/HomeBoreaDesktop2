package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoConexion {
    private static final String URL= "jdbc:mysql://127.0.0.1/java19";
    private static final String USER="RandalBatz";
    private static final String PASSWORD="";
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void Conectar() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado");
        } catch (Exception e) {
            throw e;
        }
    }
    public void Cerrar() throws Exception{
        try {
            if (cn != null) {
                if (cn.isClosed()==false) {
                    cn.close();
                    System.out.println("Desconectado");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}
