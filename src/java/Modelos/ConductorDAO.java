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
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author joseb
 */
public class ConductorDAO {
 
    Conexion conexionDB = new Conexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    public int crearConductor(String licencia, String nombres, String apellidos, String fechaNacimiento, String telefono) {
        String sql = "INSERT INTO conductor (licencia, nombres, apellidos, fecha_nacimiento, telefono) VALUES (?, ?, ?, ?, ?)";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareCall(sql);
            ps.setString(1, licencia);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, fechaNacimiento);
            ps.setString(5, telefono);
            ps.executeUpdate();
            
            return 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public String validarLicencia(String licencia) {
        Conductor conductor = new Conductor();
        String sql = "SELECT *FROM conductor where licencia = ?";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareCall(sql);
            ps.setString(1, licencia);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                conductor.setLicencia(rs.getString("licencia"));
            }
            
            System.out.println(conductor.getLicencia());
            if (conductor.getLicencia() == null) return "";
            return "Licencia ya existe en el sistema";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
    
    public int obtenerIdConLicencia(String licencia) {
        Conductor conductor = new Conductor();
        String sql = "SELECT *FROM conductor where licencia = ?";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareCall(sql);
            ps.setString(1, licencia);
            rs = ps.executeQuery();
            
            conductor.setId(0);
            while (rs.next()) {
                conductor.setId(rs.getInt("id"));
            }
            
            if (conductor.getId() == 0) return 0;
            return conductor.getId();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public List<Conductor> listarConductores(){
        String sql = "SELECT * FROM conductor";
        ArrayList<Conductor> listaConductores = new ArrayList<Conductor>();
        
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Conductor conductor = new Conductor();
                conductor.setId(rs.getInt("id"));
                conductor.setLicencia(rs.getString("licencia"));
                conductor.setNombres(rs.getString("nombres"));
                conductor.setApellidos(rs.getString("apellidos"));
                conductor.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                
                listaConductores.add(conductor);
            }
        } catch (Exception ex){
            
        }
        
        return listaConductores;
    }
    
}
