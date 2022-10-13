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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author joseb
 */
public class InfraccionDAO {
    
    Conexion conexionDB = new Conexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    public int createInfraccion(Double total, int agente, int vehiculo, List<Integer> sanciones) {
        String sql = "INSERT INTO infraccion(fecha_creacion, estado, total, agente, vehiculo) VALUES (?, ?, ?, ?, ?)";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            
            Calendar calendar = Calendar.getInstance();
            ps.setDate(1, new Date(calendar.getTime().getTime()));
            ps.setBoolean(2, false);
            ps.setDouble(3, total);
            ps.setInt(4, agente);
            ps.setInt(5, vehiculo);
            ps.executeUpdate();
            
            sql = "SELECT *FROM infraccion order by id limit 1";
            int id = 0;
            
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            
            System.out.println(sanciones.size());
            for (int sancion: sanciones) {
                System.out.println(id);
                crearInfraccionDetalle(id, sancion);
            }
           
            
            return 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public List<Infraccion> listarInfracciones() {
        List<Infraccion> result = new ArrayList<>();
        String sql = "SELECT *FROM infraccion";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Infraccion infraccion = new Infraccion();
                infraccion.setId(rs.getInt("id"));
                infraccion.setFechaCreacion(rs.getDate("fecha_creacion"));
                infraccion.setEstado(rs.getBoolean("estado"));
                infraccion.setTotal(rs.getDouble("total"));
                infraccion.setAgente(rs.getInt("agente"));
                infraccion.setVehiculo(rs.getInt("vehiculo"));
                result.add(infraccion);
            }
            
            return result;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Infraccion buscarInfraccion(int id) {
        Infraccion infraccion = new Infraccion();
        String sql = "SELECT *FROM infraccion where id = ?";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                infraccion.setId(rs.getInt("id"));
                infraccion.setFechaCreacion(rs.getDate("fecha_creacion"));
                infraccion.setEstado(rs.getBoolean("estado"));
                infraccion.setTotal(rs.getDouble("total"));
                infraccion.setAgente(rs.getInt("agente"));
                infraccion.setVehiculo(rs.getInt("vehiculo"));
                infraccion.setDetalle(buscarInfraccionDetallePorInfraccion(infraccion.getId()));
            }
            
            return infraccion;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public int actualizarInfraccion(int id, Double total, int agente, int vehiculo, List<Integer> sanciones) {
        String sql = "";
        if (sanciones.isEmpty()) {
            sql = "UPDATE infraccion SET agente = ?, vehiculo = ? where id = ?";
        } else { 
             sql = "UPDATE infraccion SET total = ?, agente = ?, vehiculo = ? where id = ?";
        }
       
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            
            if (!sanciones.isEmpty()) {
                ps.setDouble(1, total);
                ps.setInt(2, agente);
                ps.setInt(3, vehiculo);
                ps.setInt(4, id);
            } else {
                ps.setInt(1, agente);
                ps.setInt(2, vehiculo);
                ps.setInt(3, id);
            }
          
            
            ps.executeUpdate();
            
            List<InfraccionDetalle> detalle = buscarInfraccionDetallePorInfraccion(id);
            List<Integer> sancionesDetalle = new ArrayList<>();
            Map<Integer, Integer> mapDetalle = new HashMap<>();
            List<Integer> sancionesDetalleNuevas = new ArrayList<>();
            
            for(InfraccionDetalle infraccionDetalle: detalle) {
                sancionesDetalle.add(infraccionDetalle.getSancion());
            }
            
            for (Integer sancion: sancionesDetalle) {
                mapDetalle.put(sancion, sancion);
            }
            
            for (Integer sancion: sanciones) {
                if (mapDetalle.containsKey(sancion)) continue;
                sancionesDetalleNuevas.add(sancion);
            }
            
            for (Integer sancionNueva: sancionesDetalleNuevas) {
                crearInfraccionDetalle(id, sancionNueva);
            }
            
           return 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public void eliminarInfraccion(int id) {
        String sql = "DELETE FROM infraccion WHERE id = ?";
        try {
            eliminarInfraccionDetallePorInfraccoin(id);
            
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public int crearInfraccionDetalle(int infraccion, int sancion) {
        String sql = "INSERT INTO infraccion_detalle(infraccion, sancion) VALUES (?, ?)";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            System.out.println(sql);
            ps.setInt(1, infraccion);
            ps.setInt(2, sancion);
            ps.executeUpdate();
            
            return 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
        public void eliminarInfraccionDetalle(int id) {
        String sql = "DELETE FROM infraccion_detalle where id = ?";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarInfraccionDetallePorInfraccoin(int infraccion) {
        String sql = "DELETE FROM infraccion_detalle where infraccion = ?";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, infraccion);
            
            ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
       public void eliminarInfraccionDetallePorId(int id) {
        String sql = "DELETE FROM infraccion_detalle where id = ?";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public List<InfraccionDetalle> buscarInfraccionDetallePorInfraccion(int infraccion) {
        String sql = "SELECT *FROM infraccion_detalle where infraccion = ?";
        List<InfraccionDetalle> result = new ArrayList<>();
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, infraccion);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                InfraccionDetalle detalle = new InfraccionDetalle();
                detalle.setId(rs.getInt("id"));
                detalle.setInfraccion(rs.getInt("infraccion"));
                detalle.setSancion(rs.getInt("sancion"));
                result.add(detalle);
            }
            
            return result;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
