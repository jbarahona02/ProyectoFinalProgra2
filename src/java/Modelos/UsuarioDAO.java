/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Configuracion.Conexion;
import java.sql.*;
import Modelos.Usuario;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class UsuarioDAO {
    Conexion conexionDB = new Conexion();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultadoSentencia;
    int respuestaDeOperaciones;
    
    public Usuario validarUsuario(String email, String contrasenia){
        Usuario usuarioIngresado = new Usuario();
        String consultaSql = "select * from usuario where email = ? and contrasenia = ?";
        
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(consultaSql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, contrasenia);
            
            resultadoSentencia = preparedStatement.executeQuery();
            
            while (resultadoSentencia.next()){
                usuarioIngresado.setId(resultadoSentencia.getInt("id"));
                usuarioIngresado.setEmail(resultadoSentencia.getString("email"));
                usuarioIngresado.setContrasenia(resultadoSentencia.getString("contrasenia"));
                usuarioIngresado.setAgente(resultadoSentencia.getInt("agente"));
                usuarioIngresado.setConductor(resultadoSentencia.getInt("conductor"));
            }
        } catch(Exception ex){       
        }
        
        return usuarioIngresado;
    }
}
