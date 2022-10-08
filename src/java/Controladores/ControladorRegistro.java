/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joseb
 */
@WebServlet(name = "ControladorRegistro", urlPatterns = {"/ControladorRegistro"})
public class ControladorRegistro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    ConductorDAO conductorDAO = new ConductorDAO(); 
    AgenteDAO agenteDAO = new AgenteDAO();
    Usuario usuarioIngresado = new Usuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("btnAccion");
        String email = request.getParameter("txtCorreo");
        String password = request.getParameter("txtContrasenia");
        
        if (accion.equals("Crear cuenta")) {
            usuarioIngresado = usuarioDAO.validarUsuarioConEmail(email);
            if (usuarioIngresado.getEmail() != null && usuarioIngresado.getEmail().trim() != "") {
                 request.getRequestDispatcher("RegistrarPage.jsp?emailRepetido="+usuarioIngresado.getEmail()).forward(request, response);
            } else if (email != null && email != "" && password != "" && password != null) {
                request.getRequestDispatcher("CompleteRegistro.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("RegistrarPage.jsp").forward(request, response);
            }
        }
       
        if (accion.equals("Regresar")) {
             request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        if (accion.equals("Completar registro")) {
            String tipo = request.getParameter("Tipo");
            String nombres = request.getParameter("txtNombre");
            String apellidos = request.getParameter("txtApellido");
            String licenciaOrDpi = request.getParameter("txtLicenciaODpi");
            String fecha = request.getParameter("txtFechaNacimiento");
            String telefono = request.getParameter("txtTelefono");
            
            String error = "";
            boolean valida = (nombres != null || nombres.trim() != "") || 
                    (apellidos != null ||  apellidos.trim() != "") ||
                    (licenciaOrDpi != null || licenciaOrDpi.trim() != "") ||
                    (fecha != null || fecha.trim() != "") ||
                    (telefono != null ||  telefono.trim() != "");
            
            if (!valida) {
               request.getRequestDispatcher("CompleteRegistro.jsp?Tipo="+tipo+"&txtCorreo="+email+"&txtContrasenia="+password).forward(request, response);
            }
            
            if (tipo.equals("1")) {
                error = conductorDAO.validarLicencia(licenciaOrDpi);
                if (error != "") {
                    request.getRequestDispatcher("CompleteRegistro.jsp?Tipo="+tipo+"&txtCorreo="+email+"&txtContrasenia="+password+"&licenciaRepetida=" + error).forward(request, response);
                }
                
                int resp = conductorDAO.crearConductor(licenciaOrDpi, nombres, apellidos, fecha, telefono);
                if (resp == 1) {
                    usuarioDAO.crearUsuario(email, password);
                    int id = conductorDAO.obtenerIdConLicencia(licenciaOrDpi);
                    usuarioDAO.actualizarUsuario(email, 1, id);
                     request.getRequestDispatcher("ControladorMenuPrincipal?menu=Principal").forward(request, response);
                }
            } else {
                error = agenteDAO.validarDpi(licenciaOrDpi);
                if (error != "") {
                    request.getRequestDispatcher("CompleteRegistro.jsp?Tipo="+tipo+"&txtCorreo="+email+"&txtContrasenia="+password+"&dpiRepetido=" +error).forward(request, response);
                }
                int resp = agenteDAO.crearAgente(nombres, apellidos, licenciaOrDpi, fecha, telefono);
                if (resp == 1) {
                    usuarioDAO.crearUsuario(email, password);
                    int id = agenteDAO.getIdConDPI(licenciaOrDpi);
                    usuarioDAO.actualizarUsuario(email, 2, id);
                     request.getRequestDispatcher("ControladorMenuPrincipal?menu=Principal").forward(request, response);
                }
            }
        }
        

        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorRegistro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRegistro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
