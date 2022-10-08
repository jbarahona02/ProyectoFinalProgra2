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
public class VehiculoDAO {

    Conexion conexionDB = new Conexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public List<Vehiculo> listVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String query = "SELECT *FROM vehiculo";
        try {
            cn = conexionDB.getConexion();
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setColor(rs.getString("color"));
                vehiculo.setLinea(rs.getString("linea"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setConductor(rs.getInt("conductor"));
                vehiculos.add(vehiculo);
            }

            return vehiculos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
