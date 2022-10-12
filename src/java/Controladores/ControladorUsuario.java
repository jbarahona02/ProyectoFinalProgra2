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
@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("btnAccion");
        int registro = (request.getParameter("registro") != null && !request.getParameter("registro").equals("")) ? Integer.valueOf(request.getParameter("registro")) : 0;
        int id =  (request.getParameter("txtId") != null && !request.getParameter("txtId").equals("")) ? Integer.valueOf(request.getParameter("txtId")) : 0;

        if (accion.equals("Seleccionar")) {
            Usuario usuario = usuarioDAO.getUsuario(registro);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        }

        if (accion.equals("Actualizar")) {
            String txtEmail = request.getParameter("txtEmail");
            boolean validar = txtEmail != null && !txtEmail.trim().equals("");

            if (validar) {
                Usuario validaUser = usuarioDAO.validarUsuarioConEmail(txtEmail);
                if (validaUser.getEmail() != null) {
                    request.setAttribute("usuario", validaUser);
                    request.getRequestDispatcher("Usuarios.jsp?error=emailRepetido").forward(request, response);
                    return;
                }

                
                usuarioDAO.updateUsuario(txtEmail, id);
                Usuario usuario = usuarioDAO.getUsuario(id);
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                return;
            }
            
            
             request.getRequestDispatcher("Usuarios.jsp?error=error").forward(request, response);
        }
        
        if (accion.equals("Eliminar")) {
             String error = usuarioDAO.deleteUsuario(registro);
             request.getRequestDispatcher("Usuarios.jsp?errorEliminar="+error).forward(request, response);
        }
        

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuario at " + request.getContextPath() + "</h1>");
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
