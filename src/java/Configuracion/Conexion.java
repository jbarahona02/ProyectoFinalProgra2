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
    private static Connection connection = null;
    
    public Connection getConexion() {
       try {
            if (connection != null) return connection;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaInfraccionVehicular","root","Password!234");
            System.out.println("Conexión con éxito");
            
            return connection;
        } catch(Exception e) {
            System.err.println("Error de conexión " + e.getMessage());
            return null;
        } 
    }
}
