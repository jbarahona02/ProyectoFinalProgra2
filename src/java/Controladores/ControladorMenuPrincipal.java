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
import java.util.List;
import Modelos.Usuario;
import Modelos.UsuarioDAO;
import Modelos.Conductor;
import Modelos.ConductorDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControladorMenuPrincipal", urlPatterns = {"/ControladorMenuPrincipal"})
public class ControladorMenuPrincipal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    ConductorDAO conductorDAO = new ConductorDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("PrincipalAgente")) {
            request.getRequestDispatcher("MenuAgente.jsp").forward(request, response);
        }

        if (menu.equals("PrincipalConductor")) {
            request.getRequestDispatcher("MenuConductor.jsp").forward(request, response);
        }

        if (menu.equals("Conductores")) {

            List<Conductor> listaConductores = conductorDAO.listarConductores();
            request.setAttribute("conductores", listaConductores);

            request.getRequestDispatcher("Conductores.jsp").forward(request, response);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorMenuPrincipal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorMenuPrincipal at " + request.getContextPath() + "</h1>");
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
