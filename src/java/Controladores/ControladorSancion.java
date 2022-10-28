/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alera
 */
@WebServlet(name = "ControladorSancion", urlPatterns = {"/ControladorSancion"})
public class ControladorSancion extends HttpServlet{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    SancionDAO sancionDAO = new SancionDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        int id =  (request.getParameter("txtId") != null && !request.getParameter("txtId").equals("")) ? Integer.valueOf(request.getParameter("txtId")) : 0;
        
        if (accion.equals("Agregar")) {

            boolean validarAmount = (request.getParameter("txtAmount") != "");
            String descripcion = request.getParameter("txtDescripcion");

            if (!validarAmount) {
                List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
                request.setAttribute("sanciones", listaSanciones);
                request.getRequestDispatcher("Sancion.jsp?descripcion=" + descripcion + "&amount=" + 0 + "&error=campos").forward(request, response);
                return;
            }
            
            Double amount = Double.valueOf(request.getParameter("txtAmount"));

            String error = "";
            boolean valida = (descripcion != null && !descripcion.trim().equals(""))
                    && (amount != null && amount != 0);

            if (!valida) {
                List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
                request.setAttribute("sanciones", listaSanciones);
                request.getRequestDispatcher("Sancion.jsp?descripcion=" + descripcion + "&amount=" + amount + "&error=campos").forward(request, response);
                return;
            }

            Sancion validaSancion = sancionDAO.validarSancion(descripcion);
            if (validaSancion.getDescripcion() != null) {
                error = "Sancion repetida";
                request.setAttribute("sanciones", validaSancion);
                request.getRequestDispatcher("Sancion.jsp?descripcion=" + descripcion + "&amount=" + amount + "&error=sancionRepetida").forward(request, response);
                return;
            }
            
            if (error != "") {
                List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
                request.setAttribute("sanciones", listaSanciones);
                request.getRequestDispatcher("Sancion.jsp?descripcion=" + descripcion + "&amount=" + amount + "&error=campos").forward(request, response);
                return;
            }

            int resp = sancionDAO.crearSancion(descripcion, amount);
            List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
            request.setAttribute("sanciones", listaSanciones);
            request.getRequestDispatcher("Sancion.jsp").forward(request, response);

        }
        
        if (accion.equals("Seleccionar")) {
            Sancion sancionSeleccionado = sancionDAO.buscarSancion(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("sancion", sancionSeleccionado);

            List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
                request.setAttribute("sanciones", listaSanciones);

            request.getRequestDispatcher("Sancion.jsp").forward(request, response);
        }

        if (accion.equals("Actualizar")) {
            
            String descripcion = request.getParameter("txtDescripcion");
            Double amount = Double.valueOf(request.getParameter("txtAmount"));

            String error = "";
            boolean valida = (descripcion != null && !descripcion.trim().equals(""))
                    && (amount != null && amount != 0);

            if (!valida) {
                List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
                request.setAttribute("sanciones", listaSanciones);
                request.getRequestDispatcher("Sancion.jsp?descripcion=" + descripcion + "&amount=" + amount + "&idS=" + id + "&error=campos").forward(request, response);
                return;
            }

            
            if (error != "") {
                List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
                request.setAttribute("sanciones", listaSanciones);
                request.getRequestDispatcher("Sancion.jsp?descripcion=" + descripcion + "&amount=" + amount + "&idS=" + id +"&error=campos").forward(request, response);
                return;
            }

            int resp = sancionDAO.actualizarSancion(id, descripcion, amount);
            List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
            request.setAttribute("sanciones", listaSanciones);
            request.getRequestDispatcher("Sancion.jsp").forward(request, response);

        }
        
        if (accion.equals("Eliminar")){
            int idDelete = Integer.parseInt(request.getParameter("id"));
            sancionDAO.eliminarSancion(idDelete);
            List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
            request.setAttribute("sanciones", listaSanciones);
            request.getRequestDispatcher("Sancion.jsp").forward(request, response);
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
