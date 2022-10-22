/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Admin
 */
public class Usuario {

    private int id;
    private String email;
    private String contrasenia;
    private int agente;
    private int conductor;
    private String agenteNombre;
    private String conductorNombre;

    public Usuario(int id, String email, String contrasenia, int agente, int conductor) {
        this.id = id;
        this.email = email;
        this.contrasenia = contrasenia;
        this.agente = agente;
        this.conductor = conductor;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public int getAgente() {
        return agente;
    }

    public int getConductor() {
        return conductor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setAgente(int agente) {
        this.agente = agente;
    }

    public void setConductor(int conductor) {
        this.conductor = conductor;
    }

    public String getAgenteNombre() {
        return agenteNombre;
    }

    public void setAgenteNombre(String agenteNombre) {
        this.agenteNombre = agenteNombre;
    }

    public String getConductorNombre() {
        return conductorNombre;
    }

    public void setConductorNombre(String conductorNombre) {
        this.conductorNombre = conductorNombre;
    }
    
    

}
