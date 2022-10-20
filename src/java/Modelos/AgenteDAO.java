/*
 * To change this license header, choose License HeaderesultadoSentencia in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseb
 */
public class AgenteDAO {
    Conexion conexionDB = new Conexion();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultadoSentencia;
    int respuestaDeOperaciones;
    
    
   public int crearAgente(String nombre, String apellidos, String dpi, String fechaNacimiento, String telefono) {
       String sql = "INSERT INTO agente(nombre, apellidos, dpi, fecha_nacimiento, telefono) values (?, ?, ?, ?, ?)";
       try {
           connection = conexionDB.getConexion();
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, nombre);
           preparedStatement.setString(2, apellidos);
           preparedStatement.setString(3, dpi);
           preparedStatement.setString(4, fechaNacimiento);
           preparedStatement.setString(5, telefono);
           preparedStatement.executeUpdate();
          return 1;
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return 0;
   }
   
   public String validarDpi(String dpi) {
       Agente agente = new Agente();
       String query = "SELECT *FROM agente where dpi = ?";
       try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dpi);
            resultadoSentencia = preparedStatement.executeQuery();
            agente.setId(0);
            while (resultadoSentencia.next()){
                agente.setId(resultadoSentencia.getInt("id"));
            }
            
             if (agente.getId() == 0) return "";
             
             return "DPI ya existe en el sistema";
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return "Error";
       }
   }
   
   public int getIdConDPI(String dpi) {
       Agente agente = new Agente();
       String query = "SELECT *FROM agente where dpi = ?";
       try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            System.out.println(dpi);
            preparedStatement.setString(1, dpi);
            resultadoSentencia = preparedStatement.executeQuery();
            agente.setId(0);
            while (resultadoSentencia.next()){
                System.out.println(resultadoSentencia.getInt("id"));
                agente.setId(resultadoSentencia.getInt("id"));
            }
            
             if (agente.getId() == 0) return 0;
             return agente.getId();
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return 0;
       }
   }
   
   public List<Agente> buscarAgentes() {
        List<Agente> agentes = new ArrayList<>();
        String query = "SELECT *FROM agente";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                Agente agente = new Agente();
                agente.setId(resultadoSentencia.getInt("id"));
                agente.setNombre(resultadoSentencia.getString("nombre"));
                agente.setApellidos(resultadoSentencia.getString("apellidos"));
                agente.setDpi(resultadoSentencia.getString("dpi"));
                agente.setFechaNacimiento(resultadoSentencia.getDate("fecha_nacimiento"));
                agente.setTelefono(resultadoSentencia.getString("telefono"));
                agentes.add(agente);
            }

            return agentes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Agente buscarAgente(int id) {
        Agente agente = new Agente();
        String sql = "SELECT *FROM agente where id = ?";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultadoSentencia = preparedStatement.executeQuery();
            
            while (resultadoSentencia.next()) {
                agente.setId(resultadoSentencia.getInt("id"));
                agente.setNombre(resultadoSentencia.getString("nombre"));
                agente.setApellidos(resultadoSentencia.getString("apellidos"));
                agente.setDpi(resultadoSentencia.getString("dpi"));
                agente.setFechaNacimiento(resultadoSentencia.getDate("fecha_nacimiento"));
                agente.setTelefono(resultadoSentencia.getString("telefono"));
            }
            
            return agente;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Agente validarAgenteConDPI(String dpi) {
        Agente agente = new Agente();
        String query = "SELECT * FROM agente where dpi = ?";

        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dpi);

            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                agente.setId(resultadoSentencia.getInt("id"));
                agente.setNombre(resultadoSentencia.getString("nombre"));
                agente.setApellidos(resultadoSentencia.getString("apellidos"));
                agente.setDpi(resultadoSentencia.getString("dpi"));
                agente.setFechaNacimiento(resultadoSentencia.getDate("fecha_nacimiento"));
                agente.setTelefono(resultadoSentencia.getString("telefono"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return agente;
    }
    
    public int actualizarAgente(Agente agente) {
        String sql = "UPDATE agente set nombre=?, apellidos=?,dpi=?,fecha_nacimiento=?,telefono=? where id=?";

         try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, agente.getNombre());
            preparedStatement.setString(2, agente.getApellidos());
            preparedStatement.setString(3, agente.getDpi());
            preparedStatement.setDate(4, agente.getFechaNacimiento());
            preparedStatement.setString(5, agente.getTelefono());
            preparedStatement.setInt(6, agente.getId());
            preparedStatement.executeUpdate();
            
            return 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
    
    public String eliminarAgente(int id){
        String sql = "DELETE FROM agente WHERE id = ?";
        
        try{
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
           
        } catch (Exception ex){
            System.err.println(ex.getMessage());
            return "Error";
        }
        return "";
    }
    
}
