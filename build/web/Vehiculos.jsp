<%-- 
    Document   : Vehiculos
    Created on : 19/10/2022, 20:34:18
    Author     : alera
--%>

<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Modelos.*" %>
<%@page import="java.util.AbstractList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vehiculos</title>
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
                width: 120px;
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
            Vehiculo vehiculo = (Vehiculo) request.getAttribute("vehiculo");
            Vehiculo vehiculoSeleccionado = (Vehiculo) request.getAttribute("vehiculoSeleccionado");

            String placa;
            String color;
            String linea;
            String marca;
            Integer conductorId;
            int idV;

            if (vehiculo != null) {
                idV = vehiculo.getId();
                placa = vehiculo.getPlaca();
                color = vehiculo.getColor();
                linea = vehiculo.getLinea();
                marca = vehiculo.getMarca();
                conductorId = vehiculo.getConductor();
            } else {
                idV = request.getParameter("idV") != null ? Integer.parseInt(request.getParameter("idV")) : 0;
                placa = request.getParameter("placa") != null ? placa = request.getParameter("placa") : "";
                color = request.getParameter("color") != null ? color = request.getParameter("color") : "";
                linea = request.getParameter("linea") != null ? linea = request.getParameter("linea") : "";
                marca = request.getParameter("marca") != null ? marca = request.getParameter("marca") : "";
                conductorId = request.getParameter("conductor") != null ? Integer.valueOf(request.getParameter("conductor")) : 0;
            }
        %>
        <h1>Vehiculos</h1>
        <div class="contenedorFormulario">
            <div class="contenidoFormulario">
                <%                    
                    String error = request.getParameter("error");
                    String errorEliminar = request.getParameter("errorEliminar");
                    if (error != null) {
                        if (error.equals("placaRepetida")) {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">La placa ingresada ya existe en el sistema</h1>");
                        } else if(error.equals("placaNoIgual")){
                            out.println("<h1 class=" + "tituloAdvertencia" + ">La placa ingresada no es igual a la del vehiculo seleccionado</h1>");
                        }else {
                            out.println("<h1 class=" + "tituloAdvertencia" + ">Debe completar todos los campos</h1>");
                        }
                    }
                    
                    if (errorEliminar != null) {
                         out.println("<h1 class=" + "tituloAdvertencia" + ">" + errorEliminar + "</h1>");
                    }
                %>
                <p>Ingrese la informaci??n solicitada para registrar un vehiculo : </p>
                <form action="ControladorVehiculo" method="POST">
                    <div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Placa : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtPlaca" value="<%=placa%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Color : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtColor" value="<%=color%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Linea : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtLinea" value="<%=linea%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label>Marca : </label>
                            </div>
                            <div class="col-8">
                                <input type="text" class="form-control" name="txtMarca" value="<%=marca%>">
                            </div>
                        </div>
                        <div class="row filaParaInput">
                            <div class="col-2 col-form-label etiquetaDeInput">
                                <label class="form-label">Conductor </label>
                            </div>
                            <div class="col-8">
                                <select name="Conductor"  id="cmbConductor" class="form-control">
                                    <%
                                        ConductorDAO conductorDAO = new ConductorDAO();
                                        List<Conductor> conductores = conductorDAO.listarConductores();
                                        String selectedEmpty = (conductorId == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + ">Seleccione un vehiculo</option>");
                                        for (Conductor conductor : conductores) {
                                            String selected = (conductorId == conductor.getId()) ? "selected" : "";
                                            out.println("<option value=" + conductor.getId() + " " + selected + ">" + conductor.getNombres() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>    

                    <input type="hidden" name="txtId" value="<%=idV%>">        
                    <div class="contenedorBotonAgregar">
                        <%
                            if (vehiculoSeleccionado != null) {
                            
                                out.println("<input type=" + "'submit'" + "name=" + "'accion'" + " value=" + "'Actualizar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                                
                                out.println("<input type=" + "'submit'" + "name=" + "'accion'" + " value=" + "'Limpiar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");

                                out.println("<input type=" + "'submit'" + "name=" + "'accion'" + " value=" + "'Reporte'" + " class=" + "'btn btn-dark botonAgregar'" + ">");

                            } else if (vehiculoSeleccionado == null) {
                                out.println("<input type=" + "'submit'" + "  name=" + "'accion'" + " value=" + "'Agregar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                            }
                        %>

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
                            <th>Placa</th>
                            <th>Color</th>
                            <th>Linea</th>
                            <th>Marca</th>
                            <th>Conductor</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="vehiculo" items="${vehiculos}">
                            <tr class="table-dark">
                                <td>${vehiculo.getId()}</td>
                                <td>${vehiculo.getPlaca()}</td>
                                <td>${vehiculo.getColor()}</td>
                                <td>${vehiculo.getLinea()}</td>
                                <td>${vehiculo.getMarca()}</td>
                                <td>${vehiculo.getNombreConductor()}</td>
                                <td class="columnaDeBotones">
                                    <div class="d-grid gap-2 d-md-block contenedorBotones">
                                        <a class="btn btn-warning estiloEnlace" href="ControladorVehiculo?accion=Seleccionar&id=${vehiculo.getId()}">Seleccionar</a>
                                        <a class="btn btn-danger botones estiloEnlace2" href="ControladorVehiculo?accion=Eliminar&id=${vehiculo.getId()}">Eliminar</a>
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
