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
public class Vehiculo {
    private int id;
    private String placa;
    private String color;
    private String linea;
    private String marca;
    private int conductor;

    public Vehiculo() {
    }

    public Vehiculo(int id, String placa, String color, String linea, String marca, int conductor) {
        this.id = id;
        this.placa = placa;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.conductor = conductor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getConductor() {
        return conductor;
    }

    public void setConductor(int conductor) {
        this.conductor = conductor;
    }
    
    
}
