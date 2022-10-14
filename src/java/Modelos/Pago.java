/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.sql.Date;
/**
 *
 * @author Javier Barahona
 */
public class Pago {
    private int id;
    private double monto;
    private Date fechaDePago;
    private int infraccionId;

    public Pago(int id, double monto, Date fechaDePago, int infraccionId) {
        this.id = id;
        this.monto = monto;
        this.fechaDePago = fechaDePago;
        this.infraccionId = infraccionId;
    }

    public Pago() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public int getInfraccionId() {
        return infraccionId;
    }

    public void setInfraccionId(int infraccionId) {
        this.infraccionId = infraccionId;
    }
}
