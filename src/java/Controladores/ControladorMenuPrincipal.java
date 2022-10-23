/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Agente;
import Modelos.AgenteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import Modelos.*;

/**
 *
 * @author Javier, José y Alejandro
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
    PagoDAO pagoDAO = new PagoDAO();
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    AgenteDAO agenteDAO = new AgenteDAO();
    SancionDAO sancionDAO = new SancionDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String conductorId = request.getParameter("conductorId");
        String vehiculoId = request.getParameter("vehiculoId");
        
        if(menu.equals("PrincipalAgente")){
            request.getRequestDispatcher("MenuAgente.jsp").forward(request, response);
        }

        if (menu.equals("PrincipalConductor")) {
            request.getRequestDispatcher("MenuConductor.jsp").forward(request, response);
        }
        
        if (menu.equals("Usuarios")) {
            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        }
        
        if(menu.equals("Conductores")){
            List<Conductor> listaConductores = conductorDAO.listarConductores();
            request.setAttribute("conductores", listaConductores);

            request.getRequestDispatcher("Conductores.jsp").forward(request, response);
        }

        if(menu.equals("Pagos")){
            List<Pago> listaPagos = pagoDAO.listarPagosDelConductor(Integer.parseInt(conductorId));
            request.setAttribute("conductorId",conductorId);
            request.setAttribute("pagos",listaPagos);
                
            request.getRequestDispatcher("Pagos.jsp").forward(request, response);
        }
        
        if (menu.equals("Infracciones")) {
            request.getSession().setAttribute("sanciones-infraccion", null);
            request.getSession().setAttribute("infraccion", null);
            request.getSession().setAttribute("conductor", null);
            
            String conductor = request.getParameter("conductorId");
            if (conductor != null) {
                request.getSession().setAttribute("conductor", conductor);
            }
            
            request.getRequestDispatcher("Infracciones.jsp").forward(request, response);
        }
        
        if (menu.equals("Vehiculos")) {
            List<Vehiculo> listaVehiculos = vehiculoDAO.buscarVehiculos();
            request.setAttribute("vehiculos", listaVehiculos);
            request.setAttribute("usuario", usuario);
                
            request.getRequestDispatcher("Vehiculos.jsp").forward(request, response);
        }
        
        if (menu.equals("Agentes")) {
            List<Agente> listaAgentes = agenteDAO.buscarAgentes();
            request.setAttribute("agentes", listaAgentes);
            request.setAttribute("usuario", usuario);
                
            request.getRequestDispatcher("Agentes.jsp").forward(request, response);
        }
        
        if (menu.equals("Sanciones")) {
            List<Sancion> listaSanciones = sancionDAO.buscarSanciones();
            request.setAttribute("sanciones", listaSanciones);
            request.setAttribute("usuario", usuario);
                
            request.getRequestDispatcher("Sancion.jsp").forward(request, response);
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
