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
import Modelos.Pago;
import Modelos.PagoDAO;
import Modelos.Infraccion;
import Modelos.InfraccionDAO;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Javier Barahona
 */
@WebServlet(name = "ControladorPago", urlPatterns = {"/ControladorPago"})
public class ControladorPago extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Pago pago = new Pago();
    PagoDAO pagoDAO = new PagoDAO();
    InfraccionDAO infraccionDAO = new InfraccionDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        String conductorId = request.getParameter("txtConductorId");
        request.setAttribute("conductorId", conductorId);
       
        
        if (accion.equals("Realizar pago")) {
            String monto = request.getParameter("txtMonto");
            String fechaDePago = request.getParameter("txtFechaPago");
            String infraccionId = request.getParameter("cmbInfraccion");

            String error = "";
            boolean valida = (monto != null && !monto.trim().equals(""))
                    && (fechaDePago != null && !fechaDePago.trim().equals(""))
                    && (infraccionId != null && !infraccionId.trim().equals(""));

            if (!valida) {
                List<Pago> listaPagos = pagoDAO.listarPagosDelConductor(conductorId);
                request.setAttribute("pagos", listaPagos);

                request.getRequestDispatcher("Pagos.jsp?monto=" + monto + "&fechaPago=" + fechaDePago + "&infraccionId=" + infraccionId + "&error=campos").forward(request, response);
                return;
            }

            error = pagoDAO.validarQuePagoNoExista(Integer.parseInt(infraccionId));
            if (error != "") {
                List<Pago> listaPagos = pagoDAO.listarPagosDelConductor(conductorId);
                request.setAttribute("pagos", listaPagos);
                request.getRequestDispatcher("Pagos.jsp?monto=" + monto + "&fechaPago=" + fechaDePago + "&infraccionId=" + infraccionId + "&error=PagoExistente").forward(request, response);
                return;
            }

            Infraccion infraccion = infraccionDAO.getInfraccion(Integer.valueOf(infraccionId));
            String diaCreacionDeInfraccion = infraccion.getFechaCreacion().toString().split("-")[2];

            if (Integer.valueOf(fechaDePago.split("-")[2]) >= Integer.valueOf(diaCreacionDeInfraccion)
                    && Integer.valueOf(fechaDePago.split("-")[2]) <= (Integer.valueOf(diaCreacionDeInfraccion) + 4)) {
                List<Pago> listaPagos = pagoDAO.listarPagosDelConductor(conductorId);
                request.setAttribute("pagos", listaPagos);

                if (Double.parseDouble(monto) == (infraccion.getTotal() / 2)) {
                    pago.setMonto(Double.parseDouble(monto));
                    pago.setFechaDePago(Date.valueOf(fechaDePago));
                    pago.setInfraccionId(Integer.parseInt(infraccionId));
                         
                    int respuesta1 = infraccionDAO.actualizarInfraccionPorPagoRealizado(Integer.parseInt(infraccionId));
                    int respuesta2 = pagoDAO.crearPago(pago);
                    
                    listaPagos = pagoDAO.listarPagosDelConductor(conductorId);
                    request.setAttribute("pagos", listaPagos);
                    request.getRequestDispatcher("Pagos.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Pagos.jsp?monto=" + monto + "&fechaPago=" + fechaDePago + "&infraccionId=" + infraccionId + "&mensaje=Descuento").forward(request, response);
                }
            } else {
                List<Pago> listaPagos = pagoDAO.listarPagosDelConductor(conductorId);
                request.setAttribute("pagos", listaPagos);
                if (Double.parseDouble(monto) == infraccion.getTotal()) {
                    pago.setMonto(Double.parseDouble(monto));
                    pago.setFechaDePago(Date.valueOf(fechaDePago));
                    pago.setInfraccionId(Integer.parseInt(infraccionId));

                    
                    int respuesta1 = infraccionDAO.actualizarInfraccionPorPagoRealizado(Integer.parseInt(infraccionId));
                    int respuesta2 = pagoDAO.crearPago(pago);
                    
                    listaPagos = pagoDAO.listarPagosDelConductor(conductorId);
                    request.setAttribute("pagos", listaPagos);
                    request.getRequestDispatcher("Pagos.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Pagos.jsp?monto=" + monto + "&fechaPago=" + fechaDePago + "&infraccionId=" + infraccionId + "&mensaje=MontoIncompleto").forward(request, response);
                }
            }

        } else if(accion.equals("Eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            pagoDAO.eliminarPago(id);
         
            List<Pago> listaPagos = pagoDAO.listarPagosDelConductor(conductorId);
            request.setAttribute("pagos", listaPagos);
            request.getRequestDispatcher("Pagos.jsp").forward(request, response);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorPago</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPago at " + request.getContextPath() + "</h1>");
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
