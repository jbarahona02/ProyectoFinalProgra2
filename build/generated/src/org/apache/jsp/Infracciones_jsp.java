package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import Modelos.*;

public final class Infracciones_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Infraccion</title>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">\r\n");
      out.write("        <style>\r\n");
      out.write("            body {\r\n");
      out.write("                margin: 0;\r\n");
      out.write("                padding: 50px;\r\n");
      out.write("                background-color: #2ECCFA;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            h1 {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                font-size: 50px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            p {\r\n");
      out.write("                font-size: 20px;  \r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .contenedorFormulario{\r\n");
      out.write("                position: relative;\r\n");
      out.write("                margin-top: 50px;\r\n");
      out.write("                background-color: #FFFFFF60;\r\n");
      out.write("                width: 700px;\r\n");
      out.write("                border-radius: 5px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .contenidoFormulario {\r\n");
      out.write("                padding: 20px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .filaParaInput {\r\n");
      out.write("                margin-top: 20px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .etiquetaDeInput {\r\n");
      out.write("                font-size: 18px;\r\n");
      out.write("                display: flex;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("                justify-content: end;\r\n");
      out.write("                padding: 0;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .contenedorBotonAgregar{\r\n");
      out.write("                display: flex;\r\n");
      out.write("                justify-content: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .botonAgregar {\r\n");
      out.write("                width: 120px;\r\n");
      out.write("                font-size: 17px;\r\n");
      out.write("                margin-top: 20px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .contenedorTabla {\r\n");
      out.write("                display: flex; \r\n");
      out.write("                justify-content: center;\r\n");
      out.write("                width: 100%\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .informacionDeTabla{\r\n");
      out.write("                margin-top: 20px;\r\n");
      out.write("                width: 1200px;\r\n");
      out.write("                display: flex;\r\n");
      out.write("                justify-content: center;\r\n");
      out.write("                font-size: 18px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .columnaDeBotones {\r\n");
      out.write("                width: 230px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .contenedorBotones {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .botones {\r\n");
      out.write("                width: 90px;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Infraccion</h1>\r\n");
      out.write("        <div class=\"contenedorFormulario\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"contenidoFormulario\">\r\n");
      out.write("                ");

                    String error = request.getParameter("error");
                    if (error != null) {
                        out.println("<h1 class=" + "tituloAdvertencia" + ">Debe completar todos los campos</h1>");
                    }
                
      out.write("\r\n");
      out.write("                <p>Ingrese la información solicitada para registrar una infraccion: </p>\r\n");
      out.write("                <form action=\"ControladorInfraccion\" method=\"POST\">\r\n");
      out.write("                    ");

                        Infraccion infraccionEnSession = (Infraccion) request.getSession().getAttribute("infraccion");
                        String id = request.getParameter("id");
                        if (infraccionEnSession != null && infraccionEnSession.getId() != 0) {
                            id = String.valueOf(infraccionEnSession.getId());
                        }
                        out.println("<input hidden name=" + "txtId" + " value=" + id + ">");
                        Integer agenteId = request.getParameter("Agente") != null ? Integer.valueOf(request.getParameter("Agente")) : 0;
                        Integer vehiculoId = request.getParameter("Vehiculo") != null ? Integer.valueOf(request.getParameter("Vehiculo")) : 0;
                        Integer sancionId = request.getParameter("Sancion") != null ? Integer.valueOf(request.getParameter("Sancion")) : 0;
                        List<Sancion> sancionesEnSession = (ArrayList<Sancion>) request.getSession().getAttribute("sanciones-infraccion");
                        String addSancion = request.getParameter("AddSancion") != null ? request.getParameter("AddSancion") : "";
                        String conductor = (String) request.getSession().getAttribute("conductor");
                    
      out.write("\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <div class=\"row filaParaInput\">\r\n");
      out.write("                            <div class=\"col-2 col-form-label etiquetaDeInput\">\r\n");
      out.write("                                <label class=\"form-label\">Sancion: </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input hidden />\r\n");
      out.write("                            <div class=\"col-6\">\r\n");
      out.write("                                <select name=\"Sancion\" value=\"");
      out.print(sancionId);
      out.write("\"  id=\"cmbSancion\" class=\"form-control\">\r\n");
      out.write("                                    <option value=\"0\"> Seleccione una sancion</option>\r\n");
      out.write("                                    ");


                                        SancionDAO sancionDAO = new SancionDAO();
                                        List<Sancion> sanciones = sancionDAO.buscarSanciones();
                                        for (Sancion sancion : sanciones) {
                                            out.println("<option value=" + sancion.getId() + ">" + sancion.getDescripcion() + " - " + "Q" + sancion.getAmount() + "</option>");
                                        }
                                    
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");

                                if (conductor == null) {
                                    if (infraccionEnSession != null && infraccionEnSession.getId() != 0) {
                                        out.println("<button type='submit' name='btnAccion' value='btnActualizarSancion' class='btn btn-danger botones'>Agregar</button>");
                                    } else {
                                        out.println("<button type='submit' name='btnAccion' value='btnAgregarSancion' class='btn btn-danger botones'>Agregar</button>");
                                    }
                                }

                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"row filaParaInput\">\r\n");
      out.write("                            <div class=\"col-2 col-form-label etiquetaDeInput\">\r\n");
      out.write("                                <label class=\"form-label\">Agente: </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-8\">\r\n");
      out.write("                                <select name=\"Agente\" value=\"");
      out.print(agenteId);
      out.write("\" id=\"cmbAgente\" class=\"form-control\">\r\n");
      out.write("                                    <option value=\"0\" disabled> Seleccione un agente</option>\r\n");
      out.write("                                    ");

                                        AgenteDAO agenteDAO = new AgenteDAO();
                                        List<Agente> agentes = agenteDAO.buscarAgentes();
                                        String selectedEmpty = (agenteId == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + ">Seleccione un vehiculo</option>");
                                        for (Agente agente : agentes) {
                                            String selected = (agenteId == agente.getId()) ? "selected" : "";
                                            out.println("<option value=" + agente.getId() + " " + selected + ">" + agente.getNombre() + " " + agente.getApellidos() + "</option>");
                                        }
                                    
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"row filaParaInput\">\r\n");
      out.write("                            <div class=\"col-2 col-form-label etiquetaDeInput\">\r\n");
      out.write("                                <label class=\"form-label\">Vehiculo: </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-8\">\r\n");
      out.write("                                <select name=\"Vehiculo\"  id=\"cmbVehiculo\" class=\"form-control\">\r\n");
      out.write("                                    ");

                                        VehiculoDAO vehiculoDAO = new VehiculoDAO();
                                        List<Vehiculo> vehiculos = vehiculoDAO.buscarVehiculos();
                                        selectedEmpty = (vehiculoId == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + ">Seleccione un vehiculo</option>");
                                        for (Vehiculo vehiculo : vehiculos) {
                                            String selected = (vehiculoId == vehiculo.getId()) ? "selected" : "";
                                            out.println("<option value=" + vehiculo.getId() + " " + selected + ">" + vehiculo.getPlaca() + "</option>");
                                        }
                                    
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"contenedorBotonAgregar\">\r\n");
      out.write("                        ");

                            if (id != null && id != "" && conductor == null) {
                                if (infraccionEnSession != null && !infraccionEnSession.isEstado()) {
                                    out.println("<input type=" + "'submit'" + "name=" + "'btnAccion'" + " value=" + "'Actualizar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                                }

                                out.println("<input type=" + "'submit'" + "name=" + "'btnAccion'" + " value=" + "'Limpiar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                                out.println("<input type=" + "'submit'" + "name=" + "'btnAccion'" + " value=" + "'Reporte'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                            } else if (conductor == null) {
                                out.println("<input type=" + "'submit'" + "  name=" + "'btnAccion'" + " value=" + "'Agregar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                            }
                        
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"contenedorTabla\">\r\n");
      out.write("            <div class=\"informacionDeTabla\">\r\n");
      out.write("                <table class=\"table table-striped-columns\">\r\n");
      out.write("                    <tr class=\"table-dark\" style=\"text-align: center\">\r\n");
      out.write("                        ");

                            infraccionEnSession = (Infraccion) request.getSession().getAttribute("infraccion");
                            if (id != null && !id.equals("") && !addSancion.equals("1")) {
                                out.println("<th>Id</th>");
                                out.println("<th>Infraccion</th>");
                                out.println("<th>Sancion</th>");
                                if (infraccionEnSession != null && !infraccionEnSession.isEstado()) {
                                    out.println("<th>Acciones</th>");
                                }
                            } else if (sancionesEnSession != null && !sancionesEnSession.isEmpty() && addSancion.equals("1")) {
                                out.println("<th>Id</th>");
                                out.println("<th>Descripcion Sancion</th>");
                                out.println("<th>Monto</th>");
                            } else {
                                out.println("<th>Id</th>");
                                out.println("<th>Fecha de Creación</th>");
                                out.println("<th>Estado</th>");
                                out.println("<th>Total</th>");
                                out.println("<th>Agente</th>");
                                out.println("<th>Vehiculos</th>");
                                out.println("<th>Acciones</th>");
                            }

                        
      out.write(" \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
                            if (id != null && !id.equals("") && !addSancion.equals("1")) {
                            infraccionEnSession = (Infraccion) request.getSession().getAttribute("infraccion");
                            if (infraccionEnSession != null) {
                                for (InfraccionDetalle detalle : infraccionEnSession.getDetalle()) {
                                    out.println("<tr class=" + "'table-dark'" + ">");
                                    out.println("<td>" + detalle.getId() + "</td>");
                                    out.println("<td>" + detalle.getInfraccion() + "</td>");
                                    out.println("<td>" + detalle.getSancion() + "</td>");
                                    out.println("<div class=" + "'d-grid gap-2 d-md-block contenedorBotones'" + ">");
                                    out.println("<td class=" + "'columnaDeBotones'" + ">");
                                    if (!infraccionEnSession.isEstado()) {
                                        out.println("<a href='ControladorInfraccion?registro=" + detalle.getInfraccion() + "&btnAccion=EliminarDetalle&registroDetalle=" + detalle.getId() + "'  class='btn btn-danger' >Eliminar</a>");
                                    }
                                    out.println("</div>");
                                    out.println("</td>");
                                    out.println("<tr>");
                                    out.println("</tr>");
                                }
                            }
                        } else if (sancionesEnSession != null && !sancionesEnSession.isEmpty() && addSancion.equals("1")) {
                            sancionesEnSession = (ArrayList<Sancion>) request.getSession().getAttribute("sanciones-infraccion");
                            for (Sancion sancionEnSession : sancionesEnSession) {
                                out.println("<tr class=" + "'table-dark'" + ">");
                                out.println("<td>" + sancionEnSession.getId() + "</td>");
                                out.println("<td>" + sancionEnSession.getDescripcion() + "</td>");
                                out.println("<td>" + sancionEnSession.getAmount() + "</td>");
                                if (infraccionEnSession != null && infraccionEnSession.getId() != 0 && !infraccionEnSession.isEstado()) {

                                }
                                out.println("<tr>");
                                out.println("</tr>");
                            }
                        } else {
                            InfraccionDAO infraccionDAO = new InfraccionDAO();
                            List<Infraccion> infracciones = new ArrayList();
                            if (conductor != null) {
                                int conductorInt = Integer.valueOf(conductor);
                                infracciones = infraccionDAO.infraccionesPorConductor(conductorInt);
                            } else {
                                infracciones = infraccionDAO.listarInfracciones();
                            }

                            if (!infracciones.isEmpty()) {
                                out.println("<form action=" + "'ControladorInfraccion'" + "method=" + "'POST'" + ">");
                                for (Infraccion infraccion : infracciones) {
                                    out.println("<tr class=" + "'table-dark'" + ">");

                                    out.println("<td>" + infraccion.getId() + "</td>");
                                    out.println("<td>" + infraccion.getFechaCreacion() + "</td>");
                                    out.println("<td>" + infraccion.isEstado() + "</td>");
                                    out.println("<td>" + infraccion.getTotal() + "</td>");
                                    out.println("<td>" + infraccion.getAgente() + "</td>");
                                    out.println("<td>" + infraccion.getVehiculo() + "</td>");
                                    out.println("<td class=" + "'columnaDeBotones'" + ">");
                                    out.println("<div class=" + "'d-grid gap-2 d-md-block contenedorBotones'" + ">");
                                    out.println(" <a href='ControladorInfraccion?registro=" + infraccion.getId() + "&btnAccion=Seleccionar' class='btn btn-warning estiloEnlace' >Seleccionar</a>");
                                    if (!infraccion.isEstado()) {
                                        out.println("<a href='ControladorInfraccion?registro=" + infraccion.getId() + "&btnAccion=Eliminar' class='btn btn-danger estiloEnlace2' >Eliminar</a>");
                                    }
                                    out.println("</div>");
                                    out.println("</td>");
                                    out.println("</tr>");
                                }
                                out.println("</form>");
                            }

                        }
                    
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
