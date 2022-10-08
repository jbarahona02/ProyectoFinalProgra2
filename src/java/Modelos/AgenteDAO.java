/*
 * To change this license header, choose License Headers in Project Properties.
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
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    
   public int crearAgente(String nombre, String apellidos, String dpi, String fechaNacimiento, String telefono) {
       String sql = "INSERT INTO agente(nombre, apellidos, dpi, fecha_nacimiento, telefono) values (?, ?, ?, ?, ?)";
       try {
           cn = conexionDB.getConexion();
           ps = cn.prepareStatement(sql);
           ps.setString(1, nombre);
           ps.setString(2, apellidos);
           ps.setString(3, dpi);
           ps.setString(4, fechaNacimiento);
           ps.setString(5, telefono);
           ps.executeUpdate();
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
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(query);
            ps.setString(1, dpi);
            rs = ps.executeQuery();
            agente.setId(0);
            while (rs.next()){
                agente.setId(rs.getInt("id"));
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
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(query);
            System.out.println(dpi);
            ps.setString(1, dpi);
            rs = ps.executeQuery();
            agente.setId(0);
            while (rs.next()){
                System.out.println(rs.getInt("id"));
                agente.setId(rs.getInt("id"));
            }
            
             if (agente.getId() == 0) return 0;
             return agente.getId();
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return 0;
       }
   }
   
   public List<Agente> listAgentes() {
       List<Agente> agentes = new ArrayList<>();
       String query = "SELECT *FROM agente";
       try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()){
                Agente agente = new Agente();
                agente.setId(rs.getInt("id"));
                agente.setNombre(rs.getString("nombre"));
                agente.setApellidos(rs.getString("apellidos"));
                agente.setDpi(rs.getString("dpi"));
                agente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                agente.setTelefono(rs.getString("telefono"));
                agentes.add(agente);
            }
            
             return agentes;
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return null;
       }
   }
    
}
