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
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultadoSentencia;
    int respuestaDeOperaciones;

    public int crearVehiculo(String placa, String color, String linea, String marca, int conductor) {
        String sql = "INSERT INTO vehiculo (placa, color, linea, marca, conductor) VALUES (?, ?, ?, ?, ?)";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, placa);
            preparedStatement.setString(2, color);
            preparedStatement.setString(3, linea);
            preparedStatement.setString(4, marca);
            preparedStatement.setInt(5, conductor);
            preparedStatement.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public List<Vehiculo> buscarVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String query = "SELECT v.id as id,\n" +
"		v.placa as placa,\n" +
"        v.color as color,\n" +
"        v.linea as linea,\n" +
"        v.marca as marca,\n" +
"        v.conductor as conductor,\n" +
"        c.nombres as conductorNombre\n" +
"From vehiculo v\n" +
"Left join conductor c on v.conductor = c.id;";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(resultadoSentencia.getInt("id"));
                vehiculo.setPlaca(resultadoSentencia.getString("placa"));
                vehiculo.setColor(resultadoSentencia.getString("color"));
                vehiculo.setLinea(resultadoSentencia.getString("linea"));
                vehiculo.setMarca(resultadoSentencia.getString("marca"));
                vehiculo.setConductor(resultadoSentencia.getInt("conductor"));
                vehiculo.setNombreConductor(resultadoSentencia.getString("conductorNombre"));
                vehiculos.add(vehiculo);
            }

            return vehiculos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
        public List<Vehiculo> buscarVehiculosPorConductor(int id) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String query = "SELECT v.id as id,\n" +
"		v.placa as placa,\n" +
"        v.color as color,\n" +
"        v.linea as linea,\n" +
"        v.marca as marca,\n" +
"        v.conductor as conductor,\n" +
"        c.nombres as conductorNombre\n" +
"From vehiculo v\n" +
"Left join conductor c on v.conductor = c.id\n" +
"Where conductor = ?;";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(resultadoSentencia.getInt("id"));
                vehiculo.setPlaca(resultadoSentencia.getString("placa"));
                vehiculo.setColor(resultadoSentencia.getString("color"));
                vehiculo.setLinea(resultadoSentencia.getString("linea"));
                vehiculo.setMarca(resultadoSentencia.getString("marca"));
                vehiculo.setConductor(resultadoSentencia.getInt("conductor"));
                vehiculo.setNombreConductor(resultadoSentencia.getString("conductorNombre"));

                vehiculos.add(vehiculo);
            }

            return vehiculos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Vehiculo buscarVehiculo(int id) {
        Vehiculo vehiculo = new Vehiculo();
        String sql = "SELECT *FROM vehiculo where id = ?";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultadoSentencia = preparedStatement.executeQuery();
            
            while (resultadoSentencia.next()) {
                vehiculo.setId(resultadoSentencia.getInt("id"));
                vehiculo.setPlaca(resultadoSentencia.getString("placa"));
                vehiculo.setColor(resultadoSentencia.getString("color"));
                vehiculo.setLinea(resultadoSentencia.getString("linea"));
                vehiculo.setMarca(resultadoSentencia.getString("marca"));
                vehiculo.setConductor(resultadoSentencia.getInt("conductor"));
            }
            
            return vehiculo;
        } catch (Exception e) {
            return null;
        }
    }
        
    public Vehiculo validarVehiculoConPlaca(String placa) {
        Vehiculo vehiculo = new Vehiculo();
        String query = "SELECT * FROM vehiculo where placa = ?";

        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, placa);

            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                vehiculo.setId(resultadoSentencia.getInt("id"));
                vehiculo.setPlaca(resultadoSentencia.getString("placa"));
                vehiculo.setColor(resultadoSentencia.getString("color"));
                vehiculo.setLinea(resultadoSentencia.getString("linea"));
                vehiculo.setMarca(resultadoSentencia.getString("marca"));
                vehiculo.setConductor(resultadoSentencia.getInt("conductor"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return vehiculo;
    }
    
    public int actualizarVehiculo(int id, String placa, String color, String linea, String marca, int conductor) {
        String sql = "UPDATE vehiculo set placa=?, color=?,linea=?,marca=?,conductor=? where id=?";

         try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, placa);
            preparedStatement.setString(2, color);
            preparedStatement.setString(3, linea);
            preparedStatement.setString(4, marca);
            preparedStatement.setInt(5, conductor);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            
            return 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    public String eliminarVehiculo(int id){
        String sql = "DELETE FROM vehiculo WHERE id = ?";
        
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
    
    public List<Vehiculo> buscarVehiculoConInfraciones(int id) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String query = "SELECT\n" +
"		 vehiculo.id AS Id\n" +
"	FROM\n" +
"		 vehiculo vehiculo \n" +
"         INNER JOIN infraccion infraccion ON vehiculo.id = infraccion.vehiculo \n" +
"          Where vehiculo.id = ? && infraccion.estado = 0;";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(resultadoSentencia.getInt("id"));
                vehiculos.add(vehiculo);
            }
            System.out.print(vehiculos);
            if(vehiculos.isEmpty()){
                return null;
            }

            return vehiculos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
