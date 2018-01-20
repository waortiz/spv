<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Salud P&uacute;blica Virtual - Facultad Nacional de Salud Pública</title>
        <link rel="icon" href='<c:url value="/resources/imagenes/udeaIco.png" />' type="image/png" />
        <link rel="icon" href='<c:url value="/resources/imagenes/udeaIco.png" />' type="image/png" />
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
        <script src='<c:url value="/resources/js/jquery-3.2.1.min.js" />'></script>
        <style>
            .container-fluid{
              height:100%;
              display:table;
              width: 100%;
              padding: 0;
            }
            .row-fluid {height: 100%; display:table-cell; vertical-align: top;}
            .centering {
              float:none;
              margin:50pt auto;
            }            
        </style>
    </head>
    <body>
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
    </body>
</html>