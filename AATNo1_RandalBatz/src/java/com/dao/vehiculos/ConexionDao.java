package com.dao.vehiculos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDao {
    private Connection cn;
    private static final String URL= "jdbc:mysql://localhost/java19_vehiculos";
    private static final String USER= "adminborea";
    private static final String PASSWORD= "";

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
