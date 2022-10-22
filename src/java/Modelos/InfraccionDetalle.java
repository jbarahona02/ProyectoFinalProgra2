/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author joseb
 */
public class InfraccionDetalle {
    private int id;
    private int infraccion;
    private int sancion;
    private String sancionDescripcion;
    private double sancionMonto;

    public InfraccionDetalle() {
    }

    public InfraccionDetalle(int id, int infraccion, int sancion) {
        this.id = id;
        this.infraccion = infraccion;
        this.sancion = sancion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(int infraccion) {
        this.infraccion = infraccion;
    }

    public int getSancion() {
        return sancion;
    }

    public void setSancion(int sancion) {
        this.sancion = sancion;
    }

    public String getSancionDescripcion() {
        return sancionDescripcion;
    }

    public void setSancionDescripcion(String sancionDescripcion) {
        this.sancionDescripcion = sancionDescripcion;
    }

    public double getSancionMonto() {
        return sancionMonto;
    }

    public void setSancionMonto(double sancionMonto) {
        this.sancionMonto = sancionMonto;
    }
    
    
    
    
}
