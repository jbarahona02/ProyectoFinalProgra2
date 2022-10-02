package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class InicioSesion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 50px;\n");
      out.write("                background-color: #2ECCFA;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .contenedorLogin {\n");
      out.write("                margin-top: 10%;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .fondoDeLogin {\n");
      out.write("                background-color: rgba(225,225,225,0.4);\n");
      out.write("                width: 465px;\n");
      out.write("                height: 307px;\n");
      out.write("                margin-top: -40px;\n");
      out.write("                border-radius: 50px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .titulo {\n");
      out.write("                font-weight: bold;\n");
      out.write("                font-size: 200%;\n");
      out.write("                text-align: center;\n");
      out.write("                padding-top: 57px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .formulario {\n");
      out.write("                margin-top: 28px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .inputDelLogin {\n");
      out.write("                width: 80%;\n");
      out.write("                height: 34px;\n");
      out.write("                font-size: 100%;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .contenedorDeBoton {\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                margin-top: 26px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .boton {\n");
      out.write("                background-color: #223D62;\n");
      out.write("                padding-left: 30px;\n");
      out.write("                padding-right: 30px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .boton:hover {\n");
      out.write("                background-color: #223D62 !important;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            <div class=\"contenedorLogin\">\n");
      out.write("                <div>\n");
      out.write("                    <img src=\"imagenes/login.png\"> \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"fondoDeLogin\">\n");
      out.write("                        <h1 class=\"titulo\"> Iniciar Sesión </h1>\n");
      out.write("                        <form class=\"formulario\">\n");
      out.write("                            <input type=\"text\" class=\"form-control inputDelLogin\" id=\"inputPassword3\">\n");
      out.write("                            </br>\n");
      out.write("                            <input type=\"text\" class=\"form-control inputDelLogin\" id=\"inputPassword3\">\n");
      out.write("                        </form>\n");
      out.write("                        <div class=\"contenedorDeBoton\">\n");
      out.write("                            <input type=\"submit\" name=\"btnIniciarSesion\" value=\"Iniciar sesion\" class=\"btn btn-dark botonAgregar\">\n");
      out.write("                        </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </center>\n");
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
