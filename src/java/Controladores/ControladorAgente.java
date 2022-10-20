/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "ControladorAgente", urlPatterns = {"/ControladorAgente"})
public class ControladorAgente extends HttpServlet{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    AgenteDAO agenteDAO = new AgenteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        int registro = (request.getParameter("registro") != null && !request.getParameter("registro").equals("")) ? Integer.valueOf(request.getParameter("registro")) : 0;
        int id =  (request.getParameter("txtId") != null && !request.getParameter("txtId").equals("")) ? Integer.valueOf(request.getParameter("txtId")) : 0;
        Integer conductorId = request.getParameter("Conductor") != null ? Integer.valueOf(request.getParameter("Conductor")) : 0;
        
        if (accion.equals("Agregar")) {

            String nombre = request.getParameter("txtNombre");
            String apellidos = request.getParameter("txtApellidos");
            String dpi = request.getParameter("txtDpi");
            String fechaNacimiento = request.getParameter("txtFechaNacimiento");
            String telefono = request.getParameter("txtTelefono");

            String error = "";
            boolean valida = (nombre != null && !nombre.trim().equals(""))
                    && (apellidos != null && !apellidos.trim().equals(""))
                    && (dpi != null && !dpi.trim().equals(""))
                    && (fechaNacimiento != null && !fechaNacimiento.trim().equals(""))
                    && (telefono != null && !telefono.trim().equals(""));

            if (!valida) {
                List<Agente> listaAgente = agenteDAO.buscarAgentes();
                request.setAttribute("agentes", listaAgente);
                request.getRequestDispatcher("Agentes.jsp?nombre=" + nombre + "&apellidos=" + apellidos + "&dpi=" + dpi + "&fechaNacimiento=" + fechaNacimiento + "&telefono=" + telefono + "&error=campos").forward(request, response);
                return;
            }

            Agente validaAgente = agenteDAO.validarAgenteConDPI(dpi);
            if (validaAgente.getDpi() != null) {
                error = "DPI repetido";
                request.setAttribute("agente", validaAgente);
                List<Agente> listaAgente = agenteDAO.buscarAgentes();
                request.setAttribute("agentes", listaAgente);
                request.getRequestDispatcher("Agentes.jsp?nombre=" + nombre + "&apellidos=" + apellidos + "&dpi=" + dpi + "&fechaNacimiento=" + fechaNacimiento + "&telefono=" + telefono + "&error=dpiRepetido").forward(request, response);
                return;
            }
            
            if (error != "") {
                List<Agente> listaAgente = agenteDAO.buscarAgentes();
                request.setAttribute("agentes", listaAgente);
                request.getRequestDispatcher("Agentes.jsp?nombre=" + nombre + "&apellidos=" + apellidos + "&dpi=" + dpi + "&fechaNacimiento=" + fechaNacimiento + "&telefono=" + telefono + "&error=campos").forward(request, response);
                return;
            }

            int resp = agenteDAO.crearAgente(nombre, apellidos, dpi, fechaNacimiento, telefono);
            List<Agente> listaAgente = agenteDAO.buscarAgentes();
            request.setAttribute("agentes", listaAgente);
            request.getRequestDispatcher("Agentes.jsp").forward(request, response);

        }
        
        if (accion.equals("Seleccionar")) {
            Agente agenteSeleccionado = agenteDAO.buscarAgente(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("agente", agenteSeleccionado);

            List<Agente> listaAgente = agenteDAO.buscarAgentes();
                request.setAttribute("agentes", listaAgente);

            request.getRequestDispatcher("Agentes.jsp").forward(request, response);
        }

        if (accion.equals("Actualizar")) {
            
            String nombre = request.getParameter("txtNombre");
            String apellidos = request.getParameter("txtApellidos");
            String dpi = request.getParameter("txtDpi");
            String fechaNacimiento = request.getParameter("txtFechaNacimiento");
            String telefono = request.getParameter("txtTelefono");

            String error = "";
             boolean valida = (nombre != null && !nombre.trim().equals(""))
                    && (apellidos != null && !apellidos.trim().equals(""))
                    && (dpi != null && !dpi.trim().equals(""))
                    && (fechaNacimiento != null && !fechaNacimiento.trim().equals(""))
                    && (telefono != null && !telefono.trim().equals(""));

            if (!valida) {
                List<Agente> listaAgente = agenteDAO.buscarAgentes();
                request.setAttribute("agentes", listaAgente);
                request.getRequestDispatcher("Agentes.jsp?nombre=" + nombre + "&apellidos=" + apellidos + "&dpi=" + dpi + "&fechaNacimiento=" + fechaNacimiento + "&telefono=" + telefono + "&error=campos").forward(request, response);
                return;
            }

            Agente agenteSeleccionado = agenteDAO.validarAgenteConDPI(dpi);
            boolean dpiDelAgente = dpi.equals(agenteSeleccionado.getDpi());

            if (!dpiDelAgente) {
                error = "DPI no es igual a la del agente seleccionado";
                if (error != "") {
                    List<Agente> listaAgente = agenteDAO.buscarAgentes();
                    request.setAttribute("agentes", listaAgente);
                request.getRequestDispatcher("Agentes.jsp?nombre=" + nombre + "&apellidos=" + apellidos + "&dpi=" + dpi + "&fechaNacimiento=" + fechaNacimiento + "&telefono=" + telefono + "&error=dpiNoIgual").forward(request, response);
                    return;
                }
            }
            
            if (error != "") {
                List<Agente> listaAgente = agenteDAO.buscarAgentes();
                request.setAttribute("agentes", listaAgente);
                request.getRequestDispatcher("Agentes.jsp?nombre=" + nombre + "&apellidos=" + apellidos + "&dpi=" + dpi + "&fechaNacimiento=" + fechaNacimiento + "&telefono=" + telefono + "&error=campos").forward(request, response);
                return;
            }
            
            Agente agenteActualizar = new Agente();
                
            agenteActualizar.setId(id);
            agenteActualizar.setDpi(dpi);
            agenteActualizar.setNombre(nombre);
            agenteActualizar.setApellidos(apellidos);
            agenteActualizar.setTelefono(telefono);
            agenteActualizar.setFechaNacimiento(Date.valueOf(fechaNacimiento));

            int resp = agenteDAO.actualizarAgente(agenteActualizar);
            List<Agente> listaAgente = agenteDAO.buscarAgentes();
            request.setAttribute("agentes", listaAgente);
            request.getRequestDispatcher("Agentes.jsp").forward(request, response);

        }
        
        if (accion.equals("Eliminar")){
            String error = agenteDAO.eliminarAgente(id);
            List<Agente> listaAgente = agenteDAO.buscarAgentes();
            request.setAttribute("agentes", listaAgente);
            request.getRequestDispatcher("Agentes.jsp?errorEliminar="+error).forward(request, response);
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
