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
@WebServlet(name = "ControladorVehiculo", urlPatterns = {"/ControladorVehiculo"})
public class ControladorVehiculo extends HttpServlet{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    Vehiculo vehiculo = new Vehiculo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        int id = request.getParameter("txtId") != null && request.getParameter("txtId") != "" ? Integer.parseInt(request.getParameter("txtId")) : 0;
      
        Integer conductorId = request.getParameter("Conductor") != null ? Integer.valueOf(request.getParameter("Conductor")) : 0;
        
        if (accion.equals("Agregar")) {

            String placa = request.getParameter("txtPlaca");
            String color = request.getParameter("txtColor");
            String linea = request.getParameter("txtLinea");
            String marca = request.getParameter("txtMarca");

            String error = "";
            boolean valida = (placa != null && !placa.trim().equals(""))
                    && (color != null && !color.trim().equals(""))
                    && (linea != null && !linea.trim().equals(""))
                    && (marca != null && !marca.trim().equals(""));

            if (!valida) {
                List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
                request.setAttribute("vehiculos", listaVehiculos);
                request.getRequestDispatcher("Vehiculos.jsp?placa=" + placa + "&color=" + color + "&linea=" + linea + "&marca=" + marca + "&conductor" + conductorId + "&error=campos").forward(request, response);
                return;
            }

            Vehiculo validaVehiculo = vehiculoDAO.validarVehiculoConPlaca(placa);
            if (validaVehiculo.getPlaca() != null) {
                error = "Placa repetida";
                request.setAttribute("vehiculo", validaVehiculo);
                request.getRequestDispatcher("Vehiculos.jsp?error=placaRepetida").forward(request, response);
                return;
            }
            
            if (error != "") {
                List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
                request.setAttribute("vehiculos", listaVehiculos);
                request.getRequestDispatcher("Vehiculos.jsp?placa=" + placa + "&color=" + color + "&linea=" + linea + "&marca=" + marca + "&conductor" + conductorId + "&error=campos").forward(request, response);
                return;
            }

            int resp = vehiculoDAO.crearVehiculo(placa, color, linea, marca, conductorId);
            List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
            request.setAttribute("vehiculos", listaVehiculos);
            request.getRequestDispatcher("Vehiculos.jsp").forward(request, response);

        }
        
        if (accion.equals("Seleccionar")) {
            Vehiculo vehiculoSeleccionado = vehiculoDAO.buscarVehiculo(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("vehiculo", vehiculoSeleccionado);
            request.setAttribute("vehiculoSeleccionado", vehiculoSeleccionado);

            List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
                request.setAttribute("vehiculos", listaVehiculos);

            request.getRequestDispatcher("Vehiculos.jsp").forward(request, response);
        }
        
        if (accion.equals("Limpiar")) {
             List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
                request.setAttribute("vehiculos", listaVehiculos);
            request.getRequestDispatcher("Vehiculos.jsp").forward(request, response);
        }

        if (accion.equals("Actualizar")) {
            
            Vehiculo vehiculoSeleccionado2 = vehiculoDAO.buscarVehiculo(id);
            request.setAttribute("vehiculoSeleccionado", vehiculoSeleccionado2);

            String placa = request.getParameter("txtPlaca");
            String color = request.getParameter("txtColor");
            String linea = request.getParameter("txtLinea");
            String marca = request.getParameter("txtMarca");
            
            String error = "";
            boolean valida = (placa != null && !placa.trim().equals(""))
                    && (color != null && !color.trim().equals(""))
                    && (linea != null && !linea.trim().equals(""))
                    && (marca != null && !marca.trim().equals(""));

            if (!valida) {
                List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
                request.setAttribute("vehiculos", listaVehiculos);
                request.getRequestDispatcher("Vehiculos.jsp?placa=" + placa + "&color=" + color + "&linea=" + linea + "&marca=" + marca + "&conductor" + conductorId + "&idV=" + id +"&error=campos").forward(request, response);
                return;
            }

            Vehiculo vehiculoSeleccionado = vehiculoDAO.validarVehiculoConPlaca(placa);
            boolean placaDelVehiculo = placa.equals(vehiculoSeleccionado.getPlaca());
            if (!placaDelVehiculo) {
                error = "Placa no es igual a la del vehiculo seleccionado";
                if (error != "") {
                    List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
                    request.setAttribute("vehiculos", listaVehiculos);
                    request.getRequestDispatcher("Vehiculos.jsp?placa=" + placa + "&color=" + color + "&linea=" + linea + "&marca=" + marca + "&conductor" + conductorId + "&idV=" + id +"&error=placaNoIgual").forward(request, response);
                    return;
                }
            }
            
            if (error != "") {
                List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
                request.setAttribute("vehiculos", listaVehiculos);
                request.getRequestDispatcher("Vehiculos.jsp?placa=" + placa + "&color=" + color + "&linea=" + linea + "&marca=" + marca + "&conductor" + conductorId + "&idV=" + id +"&error=campos").forward(request, response);
                return;
            }

            int resp = vehiculoDAO.actualizarVehiculo(id, placa, color, linea, marca, conductorId);
            List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
            request.setAttribute("vehiculos", listaVehiculos);
            request.getRequestDispatcher("Vehiculos.jsp").forward(request, response);

        }
        if (accion.equals("Eliminar")){
            int idDelete = Integer.parseInt(request.getParameter("id"));
            vehiculoDAO.eliminarVehiculo(idDelete);
            List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
            request.setAttribute("vehiculos", listaVehiculos);
            request.getRequestDispatcher("Vehiculos.jsp").forward(request, response);
        }
         
        if (accion.equals("Reporte")){
            List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculoConInfraciones(id);
            if(listaVehiculos == null){

                request.getRequestDispatcher("ReporteSolvente.jsp?id=" + id).forward(request, response);
            }else{
                request.getRequestDispatcher("ReporteSolvencia.jsp?id=" + id).forward(request, response);
            }
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
