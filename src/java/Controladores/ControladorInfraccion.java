/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Infraccion;
import Modelos.InfraccionDAO;
import Modelos.InfraccionDetalle;
import Modelos.Sancion;
import Modelos.SancionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joseb
 */
@WebServlet(name = "ControladorInfraccion", urlPatterns = {"/ControladorInfraccion"})
public class ControladorInfraccion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    InfraccionDAO infraccionDAO = new InfraccionDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("btnAccion");
        String listSanciones = "sanciones-infraccion";
        Integer agenteId = request.getParameter("Agente") != null ? Integer.valueOf(request.getParameter("Agente")) : 0;
        Integer vehiculoId = request.getParameter("Vehiculo") != null ? Integer.valueOf(request.getParameter("Vehiculo")) : 0;

        if (accion.equals("btnAgregarSancion")) {
            SancionDAO sancionDAO = new SancionDAO();
            List<Sancion> sancionesEnSession = (ArrayList<Sancion>) request.getSession().getAttribute(listSanciones);
            Integer idSancion = Integer.valueOf(request.getParameter("Sancion"));
            Sancion sancion = sancionDAO.buscarSancion(idSancion);

            if (sancionesEnSession == null) {
                sancionesEnSession = new ArrayList<>();
                sancionesEnSession.add(sancion);
                request.getSession().setAttribute(listSanciones, sancionesEnSession);
                request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + vehiculoId + "&Agente=" + agenteId + "&AddSancion=1").forward(request, response);
            } else {
                Map<Integer, String> values = new HashMap<>();
                for (Sancion item : sancionesEnSession) {
                    values.put(item.getId(), item.getDescripcion());
                }

                if (values.containsKey(sancion.getId())) {
                    request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + vehiculoId + "&Agente=" + agenteId + "&AddSancion=1").forward(request, response);
                } else {
                    sancionesEnSession.add(sancion);
                    request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + vehiculoId + "&Agente=" + agenteId + "&AddSancion=1").forward(request, response);
                }

            }
        }

        if (accion.equals("Agregar")) {
            List<Sancion> sancionesEnSession = (ArrayList<Sancion>) request.getSession().getAttribute(listSanciones);
            if (sancionesEnSession == null || agenteId == null || agenteId == 0 || vehiculoId == null || vehiculoId == 0) {
                request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + vehiculoId + "&Agente=" + agenteId+"&error=error").forward(request, response);
            } else {
                Double total = 0.0;
                List<Integer> sancionesId = new ArrayList<>();
                for (Sancion item : sancionesEnSession) {
                    total += item.getAmount();
                    sancionesId.add(item.getId());
                }
                infraccionDAO.createInfraccion(total, agenteId, vehiculoId, sancionesId);
                request.getSession().setAttribute(listSanciones, null);
                request.getRequestDispatcher("Infracciones.jsp").forward(request, response);
            }

        }

        if (accion.equals("Eliminar")) {
            Integer id = Integer.valueOf(request.getParameter("registro"));
            infraccionDAO.eliminarInfraccion(id);
            request.getSession().setAttribute(listSanciones, null);
            request.getRequestDispatcher("Infracciones.jsp").forward(request, response);
        }

        if (accion.equals("Seleccionar")) {
            List<Sancion> sancionesEnSession = (ArrayList<Sancion>) request.getSession().getAttribute(listSanciones);
            sancionesEnSession = new ArrayList<>();
            Integer id = Integer.valueOf(request.getParameter("registro"));
            Infraccion infraccion = infraccionDAO.buscarInfraccion(id);
            SancionDAO sancionDAO = new SancionDAO();
            List<Sancion> sanciones = sancionDAO.listSancion();
            
            if (infraccion != null) {
                for (InfraccionDetalle item: infraccion.getDetalle()) {
                    Sancion sancionTem = new Sancion();
                    sancionTem = sanciones.stream().filter(predicate -> predicate.getId() == item.getSancion()).findFirst().orElse(null);
                    sancionesEnSession.add(sancionTem);
                }
                
                request.getSession().setAttribute("infraccion", infraccion);
                request.getSession().setAttribute(listSanciones, sancionesEnSession);
                request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + infraccion.getVehiculo() + "&Agente=" + infraccion.getAgente() + "&id=" + infraccion.getId()).forward(request, response);
            }
        }

        if (accion.equals("EliminarDetalle")) {
            Integer id = Integer.valueOf(request.getParameter("registro"));
            Integer idDetalle = Integer.valueOf(request.getParameter("registroDetalle"));
            infraccionDAO.eliminarInfraccionDetallePorId(idDetalle);
            Infraccion infraccion = infraccionDAO.buscarInfraccion(id);
            request.getSession().setAttribute("infraccion", infraccion);
            request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + infraccion.getVehiculo() + "&Agente=" + infraccion.getAgente() + "&id=" + infraccion.getId()).forward(request, response);
        }

        if (accion.equals("Limpiar")) {
             request.getSession().setAttribute("sanciones-infraccion", null);
            request.getSession().setAttribute("infraccion", null);
            request.getRequestDispatcher("Infracciones.jsp?Vehiculo=0&Agente=0").forward(request, response);
        }

        if (accion.equals("Actualizar")) {
            Integer id = Integer.valueOf(request.getParameter("txtId"));
            Double total = 0.0;
            List<Sancion> sancionesEnSession = (ArrayList<Sancion>) request.getSession().getAttribute(listSanciones);
            List<Integer> sancionesId = new ArrayList<>();
            if (sancionesEnSession != null) {
                for (Sancion item : sancionesEnSession) {
                    total += item.getAmount();
                    sancionesId.add(item.getId());
                }
            }

            infraccionDAO.actualizarInfraccion(id, total, agenteId, vehiculoId, sancionesId);
            Infraccion infraccion = infraccionDAO.buscarInfraccion(id);
            request.getSession().setAttribute("infraccion", infraccion);
            request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + infraccion.getVehiculo() + "&Agente=" + infraccion.getAgente() + "&id=" + infraccion.getId()).forward(request, response);
        }

        if (accion.equals("btnActualizarSancion")) {
            SancionDAO sancionDAO = new SancionDAO();
            String id = request.getParameter("txtId");
            Infraccion infraccion = infraccionDAO.buscarInfraccion(Integer.valueOf(id));
            request.getSession().setAttribute("infraccion", infraccion);
            
            List<Sancion> sancionesEnSession = (ArrayList<Sancion>) request.getSession().getAttribute(listSanciones);
            Integer idSancion = Integer.valueOf(request.getParameter("Sancion"));
            Sancion sancion = sancionDAO.buscarSancion(idSancion);

            if (sancionesEnSession == null) {
                sancionesEnSession = new ArrayList<>();
                sancionesEnSession.add(sancion);
                request.getSession().setAttribute(listSanciones, sancionesEnSession);
                request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + infraccion.getVehiculo() + "&Agente=" + infraccion.getAgente() + "&id=" + infraccion.getId() + "&AddSancion=1").forward(request, response);
            } else {
                Map<Integer, String> values = new HashMap<>();
                for (Sancion item : sancionesEnSession) {
                    values.put(item.getId(), item.getDescripcion());
                }

                if (values.containsKey(sancion.getId())) {
                    request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + infraccion.getVehiculo() + "&Agente=" + infraccion.getAgente() + "&id=" + infraccion.getId() + "&AddSancion=1").forward(request, response);
                } else {
                    sancionesEnSession.add(sancion);
                    request.getSession().setAttribute(listSanciones, sancionesEnSession);
                    System.out.println(sancionesEnSession.size());
                    request.getRequestDispatcher("Infracciones.jsp?Vehiculo=" + infraccion.getVehiculo() + "&Agente=" + infraccion.getAgente() + "&id=" + infraccion.getId() + "&AddSancion=1").forward(request, response);
                }

            }
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorInfraccion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorInfraccion at " + request.getContextPath() + "</h1>");
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
