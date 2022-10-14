<%-- 
    Document   : Pagos
    Created on : 12/10/2022, 11:57:02 AM
    Author     : Javier Barahona
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Modelos.Pago"%>
<%@page import="Modelos.Infraccion"%>
<%@page import="Modelos.InfraccionDAO"%>
<%@page import="Modelos.VehiculoDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagos</title>
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

            .tituloAdvertencia {
                font-weight: bold;
                color: red;
                font-size: 17px;
                text-align: center;
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
                width: 135px;
                font-size: 17px;
                margin-top: 20px;
            }

            .contenedorTabla {
                display: flex; 
                justify-content: center;
                width: 100%
            }

            .informacionDeTabla {
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
                margin: 5px;
            }

            .estiloEnlace {
                color: black;
                text-decoration: none;
            }

            .estiloEnlace:hover {
                color: black;
                text-decoration: none;
            }

            .estiloEnlace2 {
                color: white;
                text-decoration: none;
            }

            .estiloEnlace2:hover {
                color: white;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%
            Pago pago = (Pago) request.getAttribute("pago");
            InfraccionDAO infraccionDAO = new InfraccionDAO();
            VehiculoDAO vehiculoDAO = new VehiculoDAO();
            String monto;
            String fechaDePago;
            String infraccionId;
            Date fechaActual = new Date();
            DateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");

            if (pago != null) {
                monto = String.valueOf(pago.getMonto());
                fechaDePago = pago.getFechaDePago().toString();
                infraccionId = String.valueOf(pago.getInfraccionId());
            } else {
                monto = request.getParameter("monto") != null ? monto = request.getParameter("monto") : "";
                fechaDePago = formatoDeFecha.format(fechaActual);
                infraccionId = request.getParameter("infraccionId") != null ? infraccionId = request.getParameter("infraccionId") : "";
            }

        %>
        <h1>Pagos</h1>
        <div class="contenedorFormulario">
            <div class="contenidoFormulario">
                <%                    String error = request.getParameter("error");
                    String mensaje = request.getParameter("mensaje");
                    if (error != null) {
                        if (error.equals("PagoExistente")) {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">El pago de la infracción seleccionada ya se realizó</h1>");
                        } else {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">Debe completar todos los campos</h1>");
                        }
                    }

                    if (mensaje != null) {
                        if (mensaje.equals("Descuento")) {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">Únicamente debe pagar el 50% del monto total</h1>");
                        } else if (mensaje.equals("MontoIncompleto")) {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">Debe realizar el pago del monto exacto de la infracción</h1>");
                        }
                    }
                %>
                <p>Ingrese la información solicitada para registrar un pago : </p>
                <form action="ControladorPago" method="POST">
                    <div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Monto : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtMonto" value="<%=monto%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput" style="width: 180px">
                                <label>Fecha del pago : </label>

                            </div>
                            <div class="col-8" style="width: 390px">
                                <input type="date" class="form-control" name="txtFechaPago" value="<%=fechaDePago%>" readonly="readonly">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput" style="width: 137px">
                                <label>Infracción : </label>
                            </div>
                            <div class="col-6" style="width: 432px">
                                <select name="cmbInfraccion" value="<%=infraccionId%>"  id="cmbInfraction" class="form-control">
                                    <%
                                        if (infraccionId.equals("0") || infraccionId.equals("")) {
                                            out.println("<option value=0>Seleccione una infracción</option>");
                                        } else {
                                            Infraccion infraccion = new Infraccion();
                                            infraccion = infraccionDAO.getInfraccion(Integer.valueOf(infraccionId));
                                            out.println("<option value=" + infraccion.getId() + ">" + infraccion.getId() + " - placa de vehículo "
                                                    + vehiculoDAO.obtenerVehiculoPorId(infraccion.getVehiculo()).getPlaca() + " - " + "Q" + infraccion.getTotal() + "</option>");

                                        }

                                        List<Infraccion> infracciones = infraccionDAO.infraccionesPorConductor(request.getAttribute("conductorId").toString());
                                        for (Infraccion infraccion : infracciones) {
                                            out.println("<option value=" + infraccion.getId() + ">" + infraccion.getId() + " - Placa de vehículo: "
                                                    + vehiculoDAO.obtenerVehiculoPorId(infraccion.getVehiculo()).getPlaca() + " - " + "Q" + infraccion.getTotal() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>    

                    <input type="hidden" name="txtId" value="${pago.getId()}">    
                    <input type="hidden" name="txtConductorId" value="${conductorId}"> 
                    <div class="contenedorBotonAgregar">
                        <input type="submit" name="accion" value="Realizar pago" class="btn btn-dark botonAgregar">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-dark botonAgregar" style="margin-left: 10px;">
                    </div>
                </form>
            </div>
        </div>


        <div class="contenedorTabla">
            <div class="informacionDeTabla">
                <table class="table table-striped-columns" style="text-align: center">
                    <thead>
                        <tr class="table-dark" style="text-align: center">
                            <th>ID</th>
                            <th>Monto</th>
                            <th>Fecha de pago Año-Mes-Día</th>
                            <th>No. Infracción</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pago" items="${pagos}">
                            <tr class="table-dark">
                                <td>${pago.getId()}</td>
                                <td>${pago.getMonto()}</td>
                                <td>${pago.getFechaDePago()}</td>
                                <td>${pago.getInfraccionId()}</td>
                                <td class="columnaDeBotones">
                                    <div class="d-grid gap-2 d-md-block contenedorBotones">
                                        <a class="btn btn-warning estiloEnlace" href="ControladorPago?accion=Seleccionar&id=${pago.getId()}">Seleccionar</a>
                                        <a class="btn btn-danger botones estiloEnlace2" href="ControladorPago?accion=Eliminar&id=${pago.getId()}&txtConductorId=${conductorId}">Eliminar</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
