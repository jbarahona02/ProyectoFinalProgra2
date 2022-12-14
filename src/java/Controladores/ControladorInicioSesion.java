/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelos.UsuarioDAO;
import Modelos.Usuario;

/**
 *
 * @author Javier Barahona
 */
@WebServlet(name = "ControladorInicioSesion", urlPatterns = {"/ControladorInicioSesion"})
public class ControladorInicioSesion extends HttpServlet {

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
    Usuario usuarioIngresado = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("btnIniciarSesion") != null ? request.getParameter("btnIniciarSesion") : request.getParameter("btnCerrarSesion");

        if (accion.equals("Ingresar")) {
            String email = request.getParameter("txtCorreo");
            String contrasenia = request.getParameter("txtContrasenia");

            boolean validar = (email != null && !email.trim().equals(""))
                    && (contrasenia != null && !contrasenia.trim().equals(""));

            if (!validar) {
                request.getRequestDispatcher("index.jsp?error=campos").forward(request, response);
                return;
            }

            usuarioIngresado = usuarioDAO.validarUsuario(email, contrasenia);
            request.getSession().setAttribute("userId", usuarioIngresado.getId());
            if (usuarioIngresado.getEmail() != null) {
                request.setAttribute("usuario", usuarioIngresado);

                if (usuarioIngresado.getAgente() != 0) {
                    request.getRequestDispatcher("ControladorMenuPrincipal?menu=PrincipalAgente&conductorId=" + String.valueOf(usuarioIngresado.getAgente())).forward(request, response);
                } else {
                       System.out.println("USER INICIAL " + request.getSession().getAttribute("userId"));
                    request.getRequestDispatcher("ControladorMenuPrincipal?menu=PrincipalConductor&conductorId=" + String.valueOf(usuarioIngresado.getConductor())).forward(request, response);
                }
            } else {
                request.getRequestDispatcher("index.jsp?error=usuario").forward(request, response);
            }
        } else if (accion.equals("Registrarse")) {
            request.getRequestDispatcher("Registrar.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorInicioSesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorInicioSesion at " + request.getContextPath() + "</h1>");
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
