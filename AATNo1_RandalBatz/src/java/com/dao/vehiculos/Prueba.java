/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.vehiculos;

/**
 *
 * @author javam2019
 */
public class Prueba {
    public static void main(String[] args) throws Exception {
        ConexionDao cd = new ConexionDao();
        cd.Conectar();
        cd.Cerrar();
    }
    
}
