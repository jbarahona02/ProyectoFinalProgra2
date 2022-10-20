<%-- 
    Document   : ReporteInfraccoion
    Created on : Oct 20, 2022, 10:35:44 AM
    Author     : joseb
--%>

<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="Configuracion.Conexion"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Conexion conexionDB = new Conexion();
    File reportFile = new File(application.getRealPath("REPORTES/infraccion.jasper"));
    Map parameters = new HashMap();
    String id = request.getParameter("id");
    parameters.put("ID", id);
    
    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexionDB.getConexion());
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream outputStream = response.getOutputStream();
    outputStream.write(bytes, 0, bytes.length);
    outputStream.close();

%>
