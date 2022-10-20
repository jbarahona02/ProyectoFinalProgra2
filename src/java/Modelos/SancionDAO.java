/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseb
 */
public class SancionDAO {

    Conexion conexionDB = new Conexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public int crearSancion(String descripcion, Double amount) {
        String sql = "INSERT INTO sancion (descripcion, amount) VALUES (?, ?)";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareCall(sql);
            ps.setString(1, descripcion);
            ps.setDouble(2, amount);
            ps.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public List<Sancion> buscarSanciones() {
        List<Sancion> sanciones = new ArrayList<>();
        String query = "SELECT *FROM sancion";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sancion sancion = new Sancion();
                sancion.setId(rs.getInt("id"));
                sancion.setDescripcion(rs.getString("descripcion"));
                sancion.setAmount(rs.getDouble("amount"));
                sanciones.add(sancion);
            }

            return sanciones;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Sancion buscarSancion(int id) {
        Sancion sancion = new Sancion();
        String query = "SELECT *FROM sancion where id = ?";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                sancion.setId(rs.getInt("id"));
                sancion.setDescripcion(rs.getString("descripcion"));
                sancion.setAmount(rs.getDouble("amount"));
            }

            return sancion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public int actualizarSancion(int id, String descripcion, double amount) {
        String sql = "UPDATE sancion set descripcion=?, amount=? where id=?";

         try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, descripcion);
            ps.setDouble(2, amount);
            ps.setInt(3, id);
            ps.executeUpdate();
            
            return 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
    
    public Sancion validarSancion(String descripcion) {
        Sancion sancion = new Sancion();
        String query = "SELECT * FROM sancion where descripcion= ?";

        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(query);
            ps.setString(1, descripcion);

            rs = ps.executeQuery();

            while (rs.next()) {
                sancion.setId(rs.getInt("id"));
                sancion.setDescripcion(rs.getString("descripcion"));
                sancion.setAmount(rs.getDouble("amount"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return sancion;
    }
    
    public String eliminarSancion(int id){
        String sql = "DELETE FROM sancion WHERE id = ?";
        
        try{
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
           
        } catch (Exception ex){
            System.err.println(ex.getMessage());
            return "Error";
        }
        return "";
    }
    
    

}
