<%-- 
    Document   : Infraccion
    Created on : Oct 7, 2022, 2:18:02 PM
    Author     : joseb
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelos.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Infraccion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <style>
            body {
                margin: 0;
                padding: 50px;
                background-color: #2ECCFA;
            }

            h1 {
                text-align: center;
                font-size: 50px;
                font-weight: bold;
            }

            p {
                font-size: 20px;  
            }

            .contenedorFormulario{
                position: relative;
                margin-top: 50px;
                background-color: #FFFFFF60;
                width: 700px;
                border-radius: 5px;
            }

            .contenidoFormulario {
                padding: 20px;
            }

            .filaParaInput {
                margin-top: 20px;
            }

            .etiquetaDeInput {
                font-size: 18px;
                display: flex;
                align-items: center;
                justify-content: end;
                padding: 0;
            }

            .contenedorBotonAgregar{
                display: flex;
                justify-content: center;
            }

            .botonAgregar {
                width: 120px;
                font-size: 17px;
                margin-top: 20px;
            }

            .contenedorTabla {
                display: flex; 
                justify-content: center;
                width: 100%
            }

            .informacionDeTabla{
                margin-top: 20px;
                width: 1200px;
                display: flex;
                justify-content: center;
                font-size: 18px;
            }

            .columnaDeBotones {
                width: 230px;
            }

            .contenedorBotones {
                text-align: center;
            }

            .botones {
                width: 90px;
            }
        </style>
    </head>
    <body>
        
        <h1>Infraccion</h1>
        <div class="contenedorFormulario">

            <div class="contenidoFormulario">
                <%
                    String error = request.getParameter("error");
                    if (error != null) {
                        out.println("<h1 class=" + "tituloAdvertencia" + ">Debe completar todos los campos</h1>");
                    }
                %>
                <p>Ingrese la información solicitada para registrar una infraccion: </p>
                <form action="ControladorInfraccion" method="POST">
                    <%
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
                    %>
                    <div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label class="form-label">Sancion: </label>
                            </div>
                            <input hidden />
                            <div class="col-6">
                                <select name="Sancion" value="<%=sancionId%>"  id="cmbSancion" class="form-control">
                                    <option value="0"> Seleccione una sancion</option>
                                    <%

                                        SancionDAO sancionDAO = new SancionDAO();
                                        List<Sancion> sanciones = sancionDAO.buscarSanciones();
                                        for (Sancion sancion : sanciones) {
                                            out.println("<option value=" + sancion.getId() + ">" + sancion.getDescripcion() + " - " + "Q" + sancion.getAmount() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                            <%
                                if (conductor == null) {
                                    if (infraccionEnSession != null && infraccionEnSession.getId() != 0) {
                                        out.println("<button type='submit' name='btnAccion' value='btnActualizarSancion' class='btn btn-danger botones'>Agregar</button>");
                                    } else {
                                        out.println("<button type='submit' name='btnAccion' value='btnAgregarSancion' class='btn btn-danger botones'>Agregar</button>");
                                    }
                                }

                            %>

                        </div>


                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label class="form-label">Agente: </label>
                            </div>
                            <div class="col-8">
                                <select name="Agente" value="<%=agenteId%>" id="cmbAgente" class="form-control">
                                    <option value="0" disabled> Seleccione un agente</option>
                                    <%
                                        AgenteDAO agenteDAO = new AgenteDAO();
                                        List<Agente> agentes = agenteDAO.buscarAgentes();
                                        String selectedEmpty = (agenteId == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + ">Seleccione un vehiculo</option>");
                                        for (Agente agente : agentes) {
                                            String selected = (agenteId == agente.getId()) ? "selected" : "";
                                            out.println("<option value=" + agente.getId() + " " + selected + ">" + agente.getNombre() + " " + agente.getApellidos() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                        </div>


                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label class="form-label">Vehiculo: </label>
                            </div>
                            <div class="col-8">
                                <select name="Vehiculo"  id="cmbVehiculo" class="form-control">
                                    <%
                                        VehiculoDAO vehiculoDAO = new VehiculoDAO();
                                        List<Vehiculo> vehiculos = vehiculoDAO.buscarVehiculos();
                                        selectedEmpty = (vehiculoId == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + ">Seleccione un vehiculo</option>");
                                        for (Vehiculo vehiculo : vehiculos) {
                                            String selected = (vehiculoId == vehiculo.getId()) ? "selected" : "";
                                            out.println("<option value=" + vehiculo.getId() + " " + selected + ">" + vehiculo.getPlaca() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>    


                    <div class="contenedorBotonAgregar">
                        <%
                            if (id != null && id != "" && conductor == null) {
                                if (infraccionEnSession != null && !infraccionEnSession.isEstado()) {
                                    out.println("<input type=" + "'submit'" + "name=" + "'btnAccion'" + " value=" + "'Actualizar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                                }

                                out.println("<input type=" + "'submit'" + "name=" + "'btnAccion'" + " value=" + "'Limpiar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");

                                out.println("<a class='btn botonAgregar' href='ReporteInfraccion.jsp?id=" + id + "'>Infracciones</a>");
                            } else if (conductor == null) {
                                out.println("<input type=" + "'submit'" + "  name=" + "'btnAccion'" + " value=" + "'Agregar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                            }
                        %>
                         
                    </div>
                </form>
            </div>
        </div>


        <div class="contenedorTabla">
            <div class="informacionDeTabla">
                <table class="table table-striped-columns">
                    <tr class="table-dark" style="text-align: center">
                        <%
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

                        %> 
                    </tr>
                    <%                            if (id != null && !id.equals("") && !addSancion.equals("1")) {
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
                    %>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
