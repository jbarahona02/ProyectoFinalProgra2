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
import Modelos.Conductor;
import Modelos.ConductorDAO;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Javier Barahona
 */
@WebServlet(name = "ControladorConductor", urlPatterns = {"/ControladorConductor"})
public class ControladorConductor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Conductor conductor = new Conductor();
    ConductorDAO conductorDAO = new ConductorDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("Agregar")) {

            String licencia = request.getParameter("txtLicencia");
            String nombres = request.getParameter("txtNombres");
            String apellidos = request.getParameter("txtApellidos");
            String telefono = request.getParameter("txtTelefono");
            String fechaNacimiento = request.getParameter("txtFechaNacimiento");

            String error = "";
            boolean valida = (nombres != null && !nombres.trim().equals(""))
                    && (apellidos != null && !apellidos.trim().equals(""))
                    && (licencia != null && !licencia.trim().equals(""))
                    && (fechaNacimiento != null && !fechaNacimiento.trim().equals(""))
                    && (telefono != null && !telefono.trim().equals(""));

            if (!valida) {
                List<Conductor> listaConductores = conductorDAO.listarConductores();
                request.setAttribute("conductores", listaConductores);
                request.getRequestDispatcher("Conductores.jsp?licencia=" + licencia + "&nombres=" + nombres + "&apellidos=" + apellidos + "&telefono=" + telefono + "&fechaNac=" + fechaNacimiento + "&error=campos").forward(request, response);
                return;
            }

            error = conductorDAO.validarLicencia(licencia);
            if (error != "") {
                List<Conductor> listaConductores = conductorDAO.listarConductores();
                request.setAttribute("conductores", listaConductores);
                request.getRequestDispatcher("Conductores.jsp?licencia=" + licencia + "&nombres=" + nombres + "&apellidos=" + apellidos + "&telefono=" + telefono + "&fechaNac=" + fechaNacimiento + "&error=licenciaRepetida").forward(request, response);
                return;
            }

            int resp = conductorDAO.crearConductor(licencia, nombres, apellidos, fechaNacimiento, telefono);
            List<Conductor> listaConductores = conductorDAO.listarConductores();
            request.setAttribute("conductores", listaConductores);
            request.getRequestDispatcher("Conductores.jsp").forward(request, response);

        } else if (accion.equals("Seleccionar")) {

            Conductor conductorSeleccionado = conductorDAO.obtenerConductorPorId(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("conductor", conductorSeleccionado);

            List<Conductor> listaConductores = conductorDAO.listarConductores();
            request.setAttribute("conductores", listaConductores);

            request.getRequestDispatcher("Conductores.jsp").forward(request, response);
        } else if (accion.equals("Actualizar")) {

            int id = request.getParameter("txtId") != null && request.getParameter("txtId") != "" ? Integer.parseInt(request.getParameter("txtId")) : 0;
            Conductor conductorSeleccionado;
            
            String licencia = request.getParameter("txtLicencia");
            String nombres = request.getParameter("txtNombres");
            String apellidos = request.getParameter("txtApellidos");
            String telefono = request.getParameter("txtTelefono");
            String fechaNacimiento = request.getParameter("txtFechaNacimiento");

            String error = "";
            boolean valida = (nombres != null && !nombres.trim().equals(""))
                    && (apellidos != null && !apellidos.trim().equals(""))
                    && (licencia != null && !licencia.trim().equals(""))
                    && (fechaNacimiento != null && !fechaNacimiento.trim().equals(""))
                    && (telefono != null && !telefono.trim().equals(""));

            if (!valida) {

                List<Conductor> listaConductores = conductorDAO.listarConductores();
                request.setAttribute("conductores", listaConductores);
                request.getRequestDispatcher("Conductores.jsp?licencia=" + licencia + "&nombres=" + nombres + "&apellidos=" + apellidos + "&telefono=" + telefono + "&fechaNac=" + fechaNacimiento + "&idC=" + id + "&error=campos").forward(request, response);
                return;
            }

            conductorSeleccionado = conductorDAO.obtenerConductorPorId(id);
            boolean licenciaDelUsuario = licencia.equals(conductorSeleccionado.getLicencia());

            if (!licenciaDelUsuario) {
                error = conductorDAO.validarLicencia(licencia);
                if (error != "") {
                    List<Conductor> listaConductores = conductorDAO.listarConductores();
                    request.setAttribute("conductores", listaConductores);
                    request.getRequestDispatcher("Conductores.jsp?licencia=" + licencia + "&nombres=" + nombres + "&apellidos=" + apellidos + "&telefono=" + telefono + "&fechaNac=" + fechaNacimiento + "&idC=" + id + "&error=licenciaRepetida").forward(request, response);
                    return;
                }
            }
            
            Conductor conductorActualizar = new Conductor();
                
            conductorActualizar.setId(id);
            conductorActualizar.setLicencia(licencia);
            conductorActualizar.setNombres(nombres);
            conductorActualizar.setApellidos(apellidos);
            conductorActualizar.setTelefono(telefono);
            conductorActualizar.setFechaNacimiento(Date.valueOf(fechaNacimiento));

            int resp = conductorDAO.actualizarConductor(conductorActualizar);
            List<Conductor> listaConductores = conductorDAO.listarConductores();
            request.setAttribute("conductores", listaConductores);
            request.getRequestDispatcher("Conductores.jsp").forward(request, response);
        } else if (accion.equals("Eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            conductorDAO.eliminarConductor(id);
            List<Conductor> listaConductores = conductorDAO.listarConductores();
            request.setAttribute("conductores", listaConductores);
            request.getRequestDispatcher("Conductores.jsp").forward(request, response);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorConductor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorConductor at " + request.getContextPath() + "</h1>");
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
