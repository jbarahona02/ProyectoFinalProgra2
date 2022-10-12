package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Inicio de Sesión</title>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">\r\n");
      out.write("        <style>\r\n");
      out.write("            body {\r\n");
      out.write("                margin: 0;\r\n");
      out.write("                padding: 50px;\r\n");
      out.write("                background-color: #2ECCFA;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .contenedorLogin {\r\n");
      out.write("                margin-top: 5%;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .fondoDeLogin {\r\n");
      out.write("                background-color: rgba(225,225,225,0.4);\r\n");
      out.write("                width: 465px;\r\n");
      out.write("                height: 380px;\r\n");
      out.write("                margin-top: -40px;\r\n");
      out.write("                border-radius: 50px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .titulo {\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                font-size: 200%;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                padding-top: 57px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .formulario {\r\n");
      out.write("                margin-top: 28px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .etiquetaDeInput {\r\n");
      out.write("                text-align: left;\r\n");
      out.write("                margin-left: 50px;\r\n");
      out.write("                font-size: 19px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .inputDelLogin {\r\n");
      out.write("                width: 80%;\r\n");
      out.write("                height: 34px;\r\n");
      out.write("                font-size: 100%;\r\n");
      out.write("                border-radius: 10px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .contenedorDeBoton {\r\n");
      out.write("                display: flex;\r\n");
      out.write("                justify-content: center;\r\n");
      out.write("                margin-top: 26px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .botonAgregar {\r\n");
      out.write("                background-color: #223d62;\r\n");
      out.write("                padding-left: 30px;\r\n");
      out.write("                padding-right: 30px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .botonRegistro {\r\n");
      out.write("                background-color: #223d62;\r\n");
      out.write("                padding-left: 30px;\r\n");
      out.write("                padding-right: 30px;\r\n");
      out.write("                margin-left: 30px;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .botonAgregar:hover {\r\n");
      out.write("                background-color: #223d62 !important;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .botonRegistro:hover {\r\n");
      out.write("                background-color: #223d62 !important;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <center>\r\n");
      out.write("            <div class=\"contenedorLogin\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <img src=\"imagenes/login.png\"> \r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"fondoDeLogin\">\r\n");
      out.write("                        <h1 class=\"titulo\"> Iniciar Sesión </h1>\r\n");
      out.write("                        <form class=\"formulario\" action=\"ControladorInicioSesion\" method=\"POST\">\r\n");
      out.write("                            <div class=\"etiquetaDeInput\">\r\n");
      out.write("                                <label class=\"form-label\">Correo: </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <input type=\"text\" name=\"txtCorreo\" class=\"form-control inputDelLogin\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <br>  \r\n");
      out.write("                            <div class=\"etiquetaDeInput\">\r\n");
      out.write("                                <label class=\"form-label\">Contraseña: </label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <input type=\"password\" name=\"txtContrasenia\" class=\"form-control inputDelLogin\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"contenedorDeBoton\">\r\n");
      out.write("                                <input type=\"submit\" name=\"btnIniciarSesion\" value=\"Ingresar\" class=\"btn btn-dark botonAgregar\">\r\n");
      out.write("                                <input type=\"submit\" name=\"btnIniciarSesion\" value=\"Registrarse\" class=\"btn btn-dark botonRegistro\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </center>\r\n");
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
