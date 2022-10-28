/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Configuracion.Conexion;
import java.sql.*;
import Modelos.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UsuarioDAO {

    Conexion conexionDB = new Conexion();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultadoSentencia;
    int respuestaDeOperaciones;

    public Usuario validarUsuario(String email, String contrasenia) {
        Usuario usuarioIngresado = new Usuario();
        String consultaSql = "select * from usuario where email = ? and contrasenia = ?";

        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(consultaSql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, contrasenia);

            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                usuarioIngresado.setId(resultadoSentencia.getInt("id"));
                usuarioIngresado.setEmail(resultadoSentencia.getString("email"));
                usuarioIngresado.setContrasenia(resultadoSentencia.getString("contrasenia"));
                usuarioIngresado.setAgente(resultadoSentencia.getInt("agente"));
                usuarioIngresado.setConductor(resultadoSentencia.getInt("conductor"));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println(usuarioIngresado.getId());
        return usuarioIngresado;
    }

    public Usuario validarUsuarioConEmail(String email) {
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM usuario where email = ?";
        System.out.println("email " + email);

        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                usuario.setId(resultadoSentencia.getInt("id"));
                usuario.setEmail(resultadoSentencia.getString("email"));
                usuario.setContrasenia(resultadoSentencia.getString("contrasenia"));
                usuario.setAgente(resultadoSentencia.getInt("agente"));
                usuario.setConductor(resultadoSentencia.getInt("conductor"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return usuario;
    }

    public int crearUsuario(String email, String contrasenia) {
        String sql = "INSERT INTO usuario (email, contrasenia) values (?, ?)";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, contrasenia);
            preparedStatement.executeUpdate();

            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int crearUsuarioAsociado(String email, String contrasenia, int asociado, String tipo) {
        String sql =  "";
        if (tipo.equals("1")) {
            sql = "INSERT INTO usuario (email, contrasenia, conductor) values(?, ?, ?)";
        } else {
            sql = "INSERT INTO usuario (email, contrasenia, agente) values(?, ?, ?)";
        }
                
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, contrasenia);
            preparedStatement.setInt(3, asociado);
            preparedStatement.executeUpdate();
            
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int actualizarUsuario(String email, int type, int id) {
        String sql = "";
        if (type == 1) {
            sql = "UPDATE usuario SET conductor = ? WHERE email = ?";
        } else {
            sql = "UPDATE usuario SET agente = ? WHERE email = ?";
        }

        System.out.println(sql);
        System.out.println(email + " " + id);
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();

            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> result = new ArrayList<>();
        String sql = "SELECT\n"
                + "    u.id as id,\n"
                + "    u.email as email,\n"
                + "    u.contrasenia as contrasenia,\n"
                + "    u.conductor as conductor,\n"
                + "    u.agente as agente,\n"
                + "    c.nombres AS conductorNombre,\n"
                + "    a.nombre AS agenteNombre\n"
                + "FROM\n"
                + "    usuario u\n"
                + "LEFT JOIN conductor c ON u.conductor = c.id\n"
                + "LEFT JOIN agente a ON a.id = u.agente\n";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(resultadoSentencia.getInt("id"));
                usuario.setEmail(resultadoSentencia.getString("email"));
                usuario.setContrasenia(resultadoSentencia.getString("contrasenia"));
                usuario.setAgente(resultadoSentencia.getInt("agente"));
                usuario.setConductor(resultadoSentencia.getInt("conductor"));
                usuario.setConductorNombre(resultadoSentencia.getString("conductorNombre"));
                usuario.setAgenteNombre(resultadoSentencia.getString("agenteNombre"));
                result.add(usuario);
            }

            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario buscarUsuario(int id) {
        Usuario usuario = new Usuario();
        String sql = "SELECT\n"
                + "    u.id as id,\n"
                + "    u.email as email,\n"
                + "    u.contrasenia as contrasenia,\n"
                + "    u.conductor as conductor,\n"
                + "    u.agente as agente,\n"
                + "    c.nombres AS conductorNombre,\n"
                + "    a.nombre AS agenteNombre\n"
                + "FROM\n"
                + "    usuario u\n"
                + "LEFT JOIN conductor c ON u.conductor = c.id\n"
                + "LEFT JOIN agente a ON a.id = u.agente\n"
                + "WHERE u.id = ?;";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultadoSentencia = preparedStatement.executeQuery();

            while (resultadoSentencia.next()) {
                usuario.setId(resultadoSentencia.getInt("id"));
                usuario.setEmail(resultadoSentencia.getString("email"));
                usuario.setContrasenia(resultadoSentencia.getString("contrasenia"));
                usuario.setAgente(resultadoSentencia.getInt("agente"));
                usuario.setConductor(resultadoSentencia.getInt("conductor"));
                usuario.setConductorNombre(resultadoSentencia.getString("conductorNombre"));
                usuario.setAgenteNombre(resultadoSentencia.getString("agenteNombre"));
            }

            System.out.println(usuario.getEmail());
            return usuario;
        } catch (Exception e) {
            return null;
        }
    }

    public int actualizarUsuario(String email, int id) {
        String sql = "UPDATE usuario SET email = ? WHERE id = ?";
        try {
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println(id);

            return 1;
        } catch (Exception e) {
            return 0;
        }
    }


    public String eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            int type = 0;
            Usuario u = this.buscarUsuario(id);
            if (u != null) {
                type = u.getConductor() != 0 ? 1 : 2;
            }

            System.out.println(type);
            connection = conexionDB.getConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {

        }
        return "";
    }
}
