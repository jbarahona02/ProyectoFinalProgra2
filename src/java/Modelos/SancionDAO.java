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

    public List<Sancion> listSancion() {
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

}
