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
 * @author Javier Barahona
 */
public class PagoDAO {
    
    Conexion conexionDB = new Conexion();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public List<Pago> listarPagosDelConductor(int idCondutor) {
        String sql = "SELECT pago.id, pago.monto, pago.fecha_pago, pago.infraccion, vehiculo.placa as placa, "  
                + "conductor.licencia as licencia FROM pago "
                + "INNER JOIN infraccion ON infraccion.id = pago.infraccion "
                + "INNER JOIN vehiculo ON vehiculo.id = infraccion.vehiculo "
                + "INNER JOIN conductor ON conductor.id = vehiculo.conductor "
                + "WHERE conductor.id = ?";
        ArrayList<Pago> listaPagos = new ArrayList<Pago>();

        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCondutor);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pago pago = new Pago();
                pago.setId(resultSet.getInt("id"));
                pago.setMonto(resultSet.getDouble("monto"));
                pago.setFechaDePago(resultSet.getDate("fecha_pago"));
                pago.setInfraccionId(resultSet.getInt("infraccion"));
                pago.setPlacaVehiculo(resultSet.getString("placa"));
                pago.setLicenciaConductor(resultSet.getString("licencia"));
            
                listaPagos.add(pago);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return listaPagos;
    }
   
    public Pago obtenerPagoPorId(int id) {
        Pago pago = new Pago();
        String sql = "SELECT * FROM pago where id = ?";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pago.setId(resultSet.getInt("id"));
                pago.setMonto(resultSet.getDouble("monto"));
                pago.setFechaDePago(resultSet.getDate("fecha_pago"));
                pago.setInfraccionId(resultSet.getInt("infraccion")); 
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return pago;
    }
    
    public String validarQuePagoNoExista(int infraccionId){
        Pago pago = new Pago();
        String sql = "SELECT * FROM pago where infraccion = ?";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, infraccionId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pago.setId(resultSet.getInt("id"));
                pago.setMonto(resultSet.getDouble("monto"));
                pago.setFechaDePago(resultSet.getDate("fecha_pago"));
                pago.setInfraccionId(resultSet.getInt("infraccion")); 
            }

            if (pago.getInfraccionId() != 0) {
                return "Pago ya registrado";
            }
            
            return "";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Error";
        }
    }
    
    public int crearPago(Pago pago) {
        String sql = "INSERT INTO pago (monto, fecha_pago, infraccion) VALUES (?, ?, ?)";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setDouble(1, pago.getMonto());
            preparedStatement.setDate(2, pago.getFechaDePago());
            preparedStatement.setInt(3, pago.getInfraccionId());
            preparedStatement.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
    
    public int actualizarPago(Pago pago){
        String sql = "UPDATE pago set monto=? where id=?";
        
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, pago.getMonto());
            preparedStatement.setInt(2, pago.getId());
            
            preparedStatement.executeUpdate();
            
            return 1;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public void eliminarPago(int id){
        String sql = "DELETE FROM pago where id = ?";
        
        try{
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
