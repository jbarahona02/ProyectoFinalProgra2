/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author joseb
 */
public class Infraccion {
    private int id;
    private Date fechaCreacion;
    private boolean estado;
    private Double total;
    private Integer agente;
    private Integer vehiculo;
    private List<InfraccionDetalle> detalle;
    private String nombreAgente;
    private String placa;
    private String estadoDescripcion;

  
    

    public Infraccion() {
    }
    
    public Infraccion(int id, Date fechaCreacion, boolean estado, Double total, Integer agente, Integer vehiculo) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.total = total;
        this.agente = agente;
        this.vehiculo = vehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getAgente() {
        return agente;
    }

    public void setAgente(Integer agente) {
        this.agente = agente;
    }

    public Integer getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Integer vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public List<InfraccionDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<InfraccionDetalle> detalle) {
        this.detalle = detalle;
    }

    public String getNombreAgente() {
        return nombreAgente;
    }

    public void setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
    }
    
    
    
}
