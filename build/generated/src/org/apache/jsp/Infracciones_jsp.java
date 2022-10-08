package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Infraccion</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 50px;\n");
      out.write("                background-color: #2ECCFA;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            h1 {\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 50px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            p {\n");
      out.write("              font-size: 20px;  \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .contenedorFormulario{\n");
      out.write("                position: relative;\n");
      out.write("                margin-top: 50px;\n");
      out.write("                background-color: #FFFFFF60;\n");
      out.write("                width: 700px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .contenidoFormulario {\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .filaParaInput {\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .etiquetaDeInput {\n");
      out.write("                font-size: 18px;\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: end;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .contenedorBotonAgregar{\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .botonAgregar {\n");
      out.write("                width: 120px;\n");
      out.write("                font-size: 17px;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .contenedorTabla {\n");
      out.write("                display: flex; \n");
      out.write("                justify-content: center;\n");
      out.write("                width: 100%\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .informacionDeTabla{\n");
      out.write("                margin-top: 20px;\n");
      out.write("                width: 1200px;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .columnaDeBotones {\n");
      out.write("                width: 230px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .contenedorBotones {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .botones {\n");
      out.write("                width: 90px;\n");
      out.write("                margin: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Infraccion</h1>\n");
      out.write("        <div class=\"contenedorFormulario\">\n");
      out.write("            <div class=\"contenidoFormulario\">\n");
      out.write("                <p>Ingrese la información solicitada para registrar una infraccion: </p>\n");
      out.write("                <form action=\"ControladorInfraccion\" method=\"POST\">\n");
      out.write("                    ");
 
                        String id = request.getParameter("id");
                        out.println("<input hidden name=" + "txtId" + " value=" + id + ">");
                        Integer agenteId = request.getParameter("Agente") != null ? Integer.valueOf(request.getParameter("Agente")) : 0;
                        Integer vehiculoId = request.getParameter("Vehiculo") != null ? Integer.valueOf(request.getParameter("Vehiculo")) : 0;
                        Integer sancionId = request.getParameter("Sancion") != null ? Integer.valueOf(request.getParameter("Sancion")) : 0;
                        List<Sancion> sancionesEnSession = (ArrayList<Sancion>) request.getSession().getAttribute("sanciones-infraccion");
                        String addSancion = request.getParameter("AddSancion") != null ? request.getParameter("AddSancion") : "";
                    
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"row filaParaInput\">\n");
      out.write("                            <div class=\"col-2 col-form-label etiquetaDeInput\">\n");
      out.write("                                <label class=\"form-label\">Sancion: </label>\n");
      out.write("                            </div>\n");
      out.write("                            <input hidden />\n");
      out.write("                            <div class=\"col-6\">\n");
      out.write("                                <select name=\"Sancion\" value=\"");
      out.print(sancionId);
      out.write("\"  id=\"cmbSancion\" class=\"form-control\">\n");
      out.write("                                    <option value=\"0\"> Seleccione una sancion</option>\n");
      out.write("                                    ");
 
                                        SancionDAO sancionDAO = new SancionDAO();
                                        List<Sancion> sanciones = sancionDAO.listSancion();
                                        for (Sancion sancion: sanciones) {
                                            out.println("<option value=" + sancion.getId() +">" + sancion.getDescripcion() + " - " + "Q" + sancion.getAmount() +"</option>");
                                        }
                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <button type=\"submit\" name=\"btnAccion\" value=\"btnAgregarSancion\" class=\"btn btn-danger botones\">Agregar</button>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("\n");
      out.write("                        <div class=\"row filaParaInput\">\n");
      out.write("                            <div class=\"col-2 col-form-label etiquetaDeInput\">\n");
      out.write("                                <label class=\"form-label\">Agente: </label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-8\">\n");
      out.write("                                <select name=\"Agente\" value=\"");
      out.print(agenteId);
      out.write("\" id=\"cmbAgente\" class=\"form-control\">\n");
      out.write("                                   <option value=\"0\" disabled> Seleccione un agente</option>\n");
      out.write("                                  ");

                                    AgenteDAO agenteDAO = new AgenteDAO();
                                    List<Agente> agentes = agenteDAO.listAgentes();
                                    String selectedEmpty = (agenteId == 0) ? "selected" : "";
                                     out.println("<option value='0'" + selectedEmpty +  ">Seleccione un vehiculo</option>");
                                    for (Agente agente: agentes) {
                                            String selected = (agenteId == agente.getId()) ? "selected" : "";
                                            out.println("<option value=" + agente.getId() + " " + selected + ">" + agente.getNombre() + " " + agente.getApellidos()  +"</option>");
                                        }
                                  
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                        <div class=\"row filaParaInput\">\n");
      out.write("                            <div class=\"col-2 col-form-label etiquetaDeInput\">\n");
      out.write("                                <label class=\"form-label\">Vehiculo: </label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-8\">\n");
      out.write("                                <select name=\"Vehiculo\"  id=\"cmbVehiculo\" class=\"form-control\">\n");
      out.write("                                ");

                                    VehiculoDAO vehiculoDAO = new VehiculoDAO();
                                    List<Vehiculo> vehiculos = vehiculoDAO.listVehiculos();
                                    selectedEmpty = (vehiculoId == 0) ? "selected" : "";
                                     out.println("<option value='0'" + selectedEmpty +  ">Seleccione un vehiculo</option>");
                                    for (Vehiculo vehiculo: vehiculos) {
                                            String selected = (vehiculoId == vehiculo.getId()) ? "selected" : "";
                                            out.println("<option value=" + vehiculo.getId() + " " + selected +">" + vehiculo.getPlaca() +"</option>");
                                    }
                                  
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>    \n");
      out.write("                       \n");
      out.write("                     \n");
      out.write("                    <div class=\"contenedorBotonAgregar\">\n");
      out.write("                    ");
 
                        Infraccion infraccionEnSession = (Infraccion) request.getSession().getAttribute("infraccion");
                        if (id != null && id != "") {
                            if ( infraccionEnSession != null && !infraccionEnSession.isEstado()){
                                out.println("<input type="+ "'submit'" + "name=" + "'btnAccion'" +" value=" + "'Actualizar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                            }
                             
                             out.println("<input type="+ "'submit'" + "name=" + "'btnAccion'" +" value=" + "'Limpiar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                        } else {
                             out.println("<input type="+ "'submit'" +"  name=" + "'btnAccion'" +" value=" + "'Agregar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                        }
                    
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"contenedorTabla\">\n");
      out.write("            <div class=\"informacionDeTabla\">\n");
      out.write("                <table class=\"table table-striped-columns\">\n");
      out.write("                    <tr class=\"table-dark\" style=\"text-align: center\">\n");
      out.write("                        ");

                            infraccionEnSession = (Infraccion) request.getSession().getAttribute("infraccion");
                            if (id != null && id != "") {
                                    out.println("<th>Id</th>");
                                    out.println("<th>Infraccion</th>");
                                    out.println("<th>Sancion</th>");
                                    if (infraccionEnSession != null && !infraccionEnSession.isEstado()) {
                                    out.println("<th>Acciones</th>");
                                    }
                            } else if (sancionesEnSession != null && !sancionesEnSession.isEmpty() && addSancion.equals("1")){
                                    out.println("<th>Id</th>");
                                    out.println("<th>Descripcion Sancion</th>");
                                    out.println("<th>Monto</th>");
                            } else {
                                    out.println("<th>Seleccionar</th>");
                                    out.println("<th>Id</th>");
                                    out.println("<th>Fecha de Creación</th>");
                                    out.println("<th>Estado</th>");
                                    out.println("<th>Total</th>");
                                    out.println("<th>Agente</th>");
                                    out.println("<th>Vehiculos</th>");
                                    out.println("<th>Acciones</th>");
                            }
                        
                        
      out.write(" \n");
      out.write("                    </tr>\n");
      out.write("                        ");

                         if (id != null && id != "") {
                             infraccionEnSession = (Infraccion) request.getSession().getAttribute("infraccion");
                             if (infraccionEnSession != null) {
                                 for (InfraccionDetalle detalle : infraccionEnSession.getDetalle()) {
                                     out.println("<tr class="+ "'table-dark'" +">");
                                     out.println("<td>" + detalle.getId() + "</td>");
                                     out.println("<td>" + detalle.getInfraccion()+ "</td>");
                                     out.println("<td>" + detalle.getSancion()+ "</td>");
                                     if (!infraccionEnSession.isEstado()) {
                                         out.println("<td> <a href='ControladorInfraccion?registro="+ detalle.getInfraccion()+"&btnAccion=EliminarDetalle&registroDetalle="+detalle.getId()+"'  class='btn btn-danger botonAgregar' >Eliminar</a> </td>");
                                     }
                                     
                                     out.println("<tr>");
                                     out.println("</tr>");
                                 }  
                             }
                          } else if (sancionesEnSession != null && !sancionesEnSession.isEmpty() && addSancion.equals("1")){
                                for (Sancion sancionEnSession : sancionesEnSession) {
                                     out.println("<tr class="+ "'table-dark'" +">");
                                     out.println("<td>" + sancionEnSession.getId() + "</td>");
                                     out.println("<td>" + sancionEnSession.getDescripcion()+ "</td>");
                                     out.println("<td>" + sancionEnSession.getAmount()+ "</td>");
                                     out.println("<tr>");
                                     out.println("</tr>");
                                 }  
                          } else {
                             InfraccionDAO infraccionDAO = new InfraccionDAO();
                             List<Infraccion> infracciones = infraccionDAO.getInfracciones();
                             if (!infracciones.isEmpty()) {
                                out.println("<form action=" + "'ControladorInfraccion'" + "method="+ "'POST'" + ">");
                                for (Infraccion infraccion : infracciones) {
                                     out.println("<tr class="+ "'table-dark'" +">");
                                     out.println("<td> <a href='ControladorInfraccion?registro="+ infraccion.getId() +"&btnAccion=Seleccionar' class='btn btn-warning botonAgregar' >Seleccionar</a></td>");
                                     
                                     
                                     out.println("<td>" + infraccion.getId() + "</td>");
                                     out.println("<td>" + infraccion.getFechaCreacion()+ "</td>");
                                     out.println("<td>" + infraccion.isEstado() + "</td>");
                                     out.println("<td>" + infraccion.getTotal() + "</td>");
                                     out.println("<td>" + infraccion.getAgente()+ "</td>");
                                     out.println("<td>" + infraccion.getVehiculo()+ "</td>");
                                    out.println("<td class=" + "'columnaDeBotones'" + ">");
                                    out.println("<div class=" + "'d-grid gap-2 d-md-block contenedorBotones'" + ">");
                                    if (!infraccion.isEstado()) {
                                       out.println("<td> <a href='ControladorInfraccion?registro="+ infraccion.getId() +"&btnAccion=Eliminar' class='btn btn-danger botonAgregar' >Eliminar</a> </td>");
                                    }
                                    
                                    out.println("</tr>");
                                 }
                                 out.println("</form>");
                             }
                                
                         }
                        
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
