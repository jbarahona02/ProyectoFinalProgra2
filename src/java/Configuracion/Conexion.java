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
     
    public static Connection getConexion(){
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/NombreDB","root","");
            System.out.println("Conexión con éxito");
        } catch(Exception e) {
            System.err.println("Error de conexión " + e.getMessage());
        }
        
        return conexion;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion.getConexion();
    }
    
}
