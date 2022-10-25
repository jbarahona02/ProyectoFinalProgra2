<%-- 
    Document   : ReporteSolvencia
    Created on : 24/10/2022, 19:39:05
    Author     : alera
--%>

<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="Configuracion.Conexion"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Conexion conexionDB = new Conexion();
    File reportFile = new File(application.getRealPath("REPORTES/solvencia.jasper"));
    Map parameters = new HashMap();
    String id = request.getParameter("id");
    parameters.put("idVehiculo", id);
    
    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexionDB.getConexion());
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream outputStream = response.getOutputStream();
    outputStream.write(bytes, 0, bytes.length);
    outputStream.flush();
    outputStream.close();

%>
