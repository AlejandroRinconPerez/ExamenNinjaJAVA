/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenninjaalejo.Percistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class ConexionDB {
    
    private static final String url = "jdbc:mysql://localhost:3306/CamininoNinja";
    private static final String user = "campus2023";
    private static final String password = "campus2023";
    private static Connection con = null;
    
   

     public static Connection getConexion() {
       
            try {
                con = DriverManager.getConnection(url, user, password);
                if (con != null && con.isValid(2)) {
                    System.out.println("Conexión exitosa Mi Ninja!!");
                } else {
                    System.out.println("Conexión fallida o no válida.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al establecer la conexión: " + ex.getMessage());
                ex.printStackTrace();
            }
        
        return con;
    }
    
    
     public static void closeConecction() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}

//
// <dependencies>
//        <dependency>
//            <groupId>com.mysql</groupId>
//            <artifactId>mysql-connector-j</artifactId>
//            <version>8.2.0</version> <!-- Versión del conector JDBC de MySQL -->
//        </dependency>
//    </dependencies>




