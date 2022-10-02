package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DriverPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
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
      out.write("            .formContainer{\n");
      out.write("                position: relative;\n");
      out.write("                margin-top: 50px;\n");
      out.write("                background-color: rgba(225,225,225,0.4);\n");
      out.write("                width: 700px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .formContent {\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .rowInput {\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .inputLabel {\n");
      out.write("                font-size: 18px;\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: end;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .dataTable{\n");
      out.write("                margin-top: 20px;\n");
      out.write("                width: 1200px;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .columnButtons {\n");
      out.write("                width: 230px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .buttonsContainer {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .buttons {\n");
      out.write("                width: 90px;\n");
      out.write("                margin: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <h1>Conductor</h1>\n");
      out.write("        <div class=\"formContainer\">\n");
      out.write("            <div class=\"formContent\">\n");
      out.write("                <p>Ingrese la información solicitada para registrar un conductor : </p>\n");
      out.write("                <form action=\"\">\n");
      out.write("                    \n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"row rowInput\">\n");
      out.write("                            <div class=\"col-2 col-form-label inputLabel\">\n");
      out.write("                                <label>Email : </label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-8\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"inputPassword3\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row rowInput\">\n");
      out.write("                            <div class=\"col-2 col-form-label inputLabel\">\n");
      out.write("                                <label>Email : </label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-8\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"inputPassword3\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row rowInput\">\n");
      out.write("                            <div class=\"col-2 col-form-label inputLabel\">\n");
      out.write("                                <label>Email : </label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-8\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"inputPassword3\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>    \n");
      out.write("                       \n");
      out.write("                     \n");
      out.write("                   \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div style=\"display: flex; justify-content: center; width: 100%\">\n");
      out.write("            <div class=\"dataTable\">\n");
      out.write("                <table class=\"table table-striped-columns\">\n");
      out.write("                    <tr class=\"table-dark\">\n");
      out.write("                        <th>Campo 1</th>\n");
      out.write("                        <th>Campo 2</th>\n");
      out.write("                        <th>Campo 3</th>\n");
      out.write("                        <th>Campo 4</th>\n");
      out.write("                        <th>Campo 5</th>\n");
      out.write("                        <th>acciones</th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr class=\"table-dark\">\n");
      out.write("                        <td>asdas</td>\n");
      out.write("                        <td>asdas</td>\n");
      out.write("                        <td>asdas</td>\n");
      out.write("                        <td>asdas</td>\n");
      out.write("                        <td>asdas</td>\n");
      out.write("                        <td class=\"columnButtons\">\n");
      out.write("                            <div class=\"d-grid gap-2 d-md-block buttonsContainer\">\n");
      out.write("                                <button class=\"btn btn-info buttons\" type=\"button\">Actualizar</button>\n");
      out.write("                                <button class=\"btn btn-danger buttons\" type=\"button\">Eliminar</button>\n");
      out.write("                              </div>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
