/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;
import java.sql.*;
/**
 *
 * @author Javier Barahona
 */
public class Conexion {
    /**
     * @param args the command line arguments
     */
    Connection connection;
    
    public Conexion() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinalprogra2","root","");
            System.out.println("Conexión con éxito");
        } catch(Exception e) {
            System.err.println("Error de conexión " + e.getMessage());
        } 
    }
    
    public Connection getConexion(){ 
        return connection;
    }
}
