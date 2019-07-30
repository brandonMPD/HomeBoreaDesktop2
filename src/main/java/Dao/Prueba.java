/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in tsehe editor.
 */
package Dao;

import Modelo.Empleados;
import java.util.Scanner;

/**
 *
 * @author javam2019
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empleados empleado = new Empleados();
        EmpleadosDao dao = new EmpleadosDao();
       
        empleado=dao.buscarEmpleados("admin","123");
        
        if (empleado.getUsuario()==null) {
            System.out.println("Datos incorrectos no puede ingresar al sistema");
            
        }else{
            System.out.println("Bienvenido");
            System.out.println(empleado.toString());
        }

    }

}
