<%-- 
    Document   : UserPage
    Created on : 27/09/2022, 07:42:06 PM
    Author     : José Bobadilla
--%>

<%@page import="Modelos.UsuarioDAO"%>
<%@page import="Modelos.Conductor"%>
<%@page import="Modelos.ConductorDAO"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.Agente"%>
<%@page import="Modelos.AgenteDAO"%>
<%@page import="Modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

            .botonAgregar2 {
                width: 200px;
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
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = (Usuario) request.getAttribute("usuario");
            String email, contrasenia = "";
            int agente;
            int conductor;
            String tipoUsuario = (String) request.getSession().getAttribute("tipoUsuario");
            int id = 0;

            if (usuario != null) {
                id = usuario.getId();
                email = usuario.getEmail();
                agente = usuario.getAgente();
                conductor = usuario.getConductor();
            } else {
                email = request.getParameter("email") != null ? request.getParameter("email") : "";
                contrasenia = request.getParameter("contrasenia") != null ? request.getParameter("contrasenia") : "";
                agente = request.getParameter("agente") != null ? Integer.valueOf(request.getParameter("agente")) : 0;
                conductor = request.getParameter("conductor") != null ? Integer.valueOf(request.getParameter("conductor")) : 0;
            }

            String conductorMenu = (String) request.getSession().getAttribute("conductor");
            Integer idUser = (Integer) request.getSession().getAttribute("userId");
            

            Usuario usuarioConductor = null;
            if (idUser != null && conductorMenu != null) {
                usuarioConductor = usuarioDAO.buscarUsuario(idUser);
                id = usuarioConductor.getId();
                usuario = null;
            }

        %>


        <div>


            <h1>Usuarios</h1>
            <div>
                <div class="contenedorFormulario">
                    <div>

                        <div class="contenidoFormulario">

                            <%                                String error = request.getParameter("error");
                                String errorEliminar = request.getParameter("errorEliminar");

                                if (error != null) {
                                    if (error.equals("emailRepetido")) {
                                        out.println("<h1 class=" + "tituloAdvertencia" + ">El correo ingresado ya existe en el sistema</h1>");
                                    } else if (error.equals("tipoUsuario")) {
                                        out.println("<h1 class=" + "tituloAdvertencia" + ">Seleccione tipo de usuario</h1>");
                                    } else {
                                        out.println("<h1 class=" + "tituloAdvertencia" + ">Debe completar todos los campos</h1>");
                                    }
                                }

                                if (errorEliminar != null) {
                                    out.println("<h1 class=" + "tituloAdvertencia" + ">" + errorEliminar + "</h1>");
                                }
                            %>

                            <p>Información del usuario: </p>
                            <form action="ControladorUsuario" method="POST">
                                <div class="row filaParaInput">
                                    <div class="col-2 col-form-label etiquetaDeInput">
                                        <label>Correo : </label>
                                    </div>

                                    <%
                                        String disabled = (conductorMenu == null) ? "" : "disabled";
                                        String disabledUpdate = "";
                                        if (conductorMenu == null && usuario != null && usuario.getId() != 0) {
                                            disabledUpdate = "disabled";
                                        }
                                        if (conductorMenu != null) {
                                            email = usuarioConductor.getEmail();
                                        }
                                        out.println("<div class='col-8'>");
                                        out.println("<input type='text' class='form-control' name='txtEmail' value='" + email + "'>");
                                        out.println("</div>");
                                    %>
                                </div>

                                <%
                                    if (conductorMenu == null && usuario == null) {
                                        out.println("<div class='row filaParaInput'>");

                                        out.println("<div class='col-2 col-form-label etiquetaDeInput'>");
                                        out.println("<label>Contraseña : </label>");
                                        out.println("</div>");

                                        out.println("<div class='col-8'>");
                                        out.println("<input type='text' class='form-control' name='txtContrasenia' value='" + contrasenia + "'>");
                                        out.println("</div>");

                                        out.println("</div>");
                                    }
                                %>

                                <%
                                    if ((tipoUsuario != null && tipoUsuario.equals("2")) || (usuario != null && usuario.getAgente() != 0)) {
                                        out.println("<div class='row filaParaInput'>");
                                        out.println("<div class='col-2 col-form-label etiquetaDeInput'>");
                                        out.println("<label>Agente : </label>");
                                        out.println("</div>");

                                        out.println("<div class='col-8'>");

                                        out.println("<select name='Agente' id='cmbAgente' class='form-control' " + disabled + " " + disabledUpdate + ">");
                                        AgenteDAO agenteDAO = new AgenteDAO();
                                        List<Agente> agentes = agenteDAO.buscarAgentes();

                                        String selectedEmpty = (agente == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + " disabled>No hay información</option>");

                                        for (Agente item : agentes) {
                                            String selected = (agente == item.getId()) ? "selected" : "";
                                            out.println("<option value=" + item.getId() + " " + selected + ">" + item.getNombre() + " " + item.getApellidos() + "</option>");
                                        }

                                        out.println("</select>");

                                        out.println("</div>");
                                        out.println("</div>");
                                    }
                                %>

                                <%
                                    if ((tipoUsuario != null && tipoUsuario.equals("1")) || (usuario != null && usuario.getConductor() != 0) || (usuarioConductor != null && usuarioConductor.getConductor() != 0)) {
                                        out.println("<div class='row filaParaInput'>");
                                        out.println("<div class='col-2 col-form-label etiquetaDeInput'>");
                                        out.println("<label>Conductor : </label>");
                                        out.println("</div>");

                                        out.println("<div class='col-8'>");

                                        out.println("<select name='Conductor' id='cmbConductor' class='form-control' " + disabled + " " + disabledUpdate + ">");

                                        ConductorDAO conductorDAO = new ConductorDAO();
                                        List<Conductor> conductores = conductorDAO.listarConductores();

                                        String selectedEmpty = (conductor == 0) ? "selected" : "";
                                        out.println("<option value='0'" + selectedEmpty + " disabled>No hay inforamción</option>");

                                        if (conductorMenu != null) {
                                            conductor = usuarioConductor.getConductor();
                                        }

                                        for (Conductor item : conductores) {
                                            String selected = (conductor == item.getId()) ? "selected" : "";
                                            out.println("<option value=" + item.getId() + " " + selected + ">" + item.getNombres() + " " + item.getApellidos() + "</option>");
                                        }
                                        out.println("</select>");
                                        out.println("</div>");
                                        out.println("</div>");
                                    }
                                %>

                                <%
                                    if (conductorMenu == null && usuario == null && email == "" && tipoUsuario == null) {
                                        out.println("<div class='row filaParaInput'>");

                                        out.println("<div class='col-3 col-form-label etiquetaDeInput'>");
                                        out.println("<label>Tipo de usuario : </label>");
                                        out.println("</div>");

                                        out.println("<div class='col-7' >");
                                        out.println("<select name='Tipo' id='tipoUsuario' class='form-control'>");
                                        out.println("<option value='1'>Conductor</option>");
                                        out.println("<option value='2'>Agente</option>");
                                        out.println("</select>");
                                        out.println("</div>");

                                        out.println("</div>");
                                    }

                                %>



                                        
                                <div class="contenedorBotonAgregar">
                                    <%  
                                        out.println("<input type='hidden' name='txtId' value=" + id + ">");
                                        if ((usuario != null && usuario.getId() != 0) || (usuarioConductor != null && usuarioConductor.getConductor() != 0)) {
                                            out.println("<input type='submit' name='btnAccion' value='Actualizar' class='btn btn-dark botonAgregar' style='margin-left: 10px;'>");
                                        }

                                        if (usuario != null && usuario.getId() != 0) {

                                            out.println("<input type=" + "'submit'" + "name=" + "'btnAccion'" + " value=" + "'Limpiar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                                        } else if (tipoUsuario != null) {
                                            out.println("<input type=" + "'submit'" + "  name=" + "'btnAccion'" + " value=" + "'Agregar'" + " class=" + "'btn btn-dark botonAgregar'" + ">");
                                        } else if (usuarioConductor == null) {
                                            out.println("<input type=" + "'submit'" + "  name=" + "'btnAccion'" + " value=" + "'Seleccionar Tipo'" + " class=" + "'btn btn-dark botonAgregar2'" + ">");
                                        }

                                    %>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <div class="contenedorTabla">
            <div class="informacionDeTabla">
                <table class="table table-striped-columns">
                    <thead>
                        <%                            if (conductorMenu == null) {
                                out.println("<tr class='table-dark' style='text-align: center'>");
                                out.println("<th>ID</th>");
                                out.println("<th>Correo</th>");
                                out.println("<th>Agente</th>");
                                out.println("<th>Conductor</th>");
                                out.println("<th>Acciones</th>");
                                out.println("</tr>");
                            }
                        %>

                    </thead>
                    <tbody>
                        <%
                            List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                            if (!usuarios.isEmpty() && conductorMenu == null) {
                                out.println("<form action=" + "'ControladorUsuario'" + "method=" + "'POST'" + ">");
                                for (Usuario item : usuarios) {
                                    String usuarioText = item.getConductorNombre() == null ? " " : item.getConductorNombre();
                                    String agenteText = item.getAgenteNombre() == null ? " " : item.getAgenteNombre();
                                    out.println("<tr class=" + "'table-dark'" + ">");

                                    out.println("<td>" + item.getId() + "</td>");
                                    out.println("<td>" + item.getEmail() + "</td>");
                                    out.println("<td>" + agenteText + "</td>");
                                    out.println("<td>" + usuarioText + "</td>");
                                    out.println("<td class=" + "'columnaDeBotones'" + ">");
                                    out.println("<div class=" + "'d-grid gap-2 d-md-block contenedorBotones'" + ">");
                                    out.println("<a href='ControladorUsuario?registro=" + item.getId() + "&btnAccion=Seleccionar' class='btn btn-warning estiloEnlace' >Seleccionar</a>");
                                    if (conductorMenu == null) {
                                        out.println("<a href='ControladorUsuario?registro=" + item.getId() + "&btnAccion=Eliminar' class='btn btn-danger estiloEnlace2' >Eliminar</a>");
                                    }

                                    out.println("</div>");
                                    out.println("</td>");
                                    out.println("</tr>");
                                }
                                out.println("</form>");
                            }

                        %>

                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    </body>
</html>
