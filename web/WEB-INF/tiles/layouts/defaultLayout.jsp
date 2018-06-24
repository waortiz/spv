<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Salud P&uacute;blica Virtual - Facultad Nacional de Salud Pública</title>
        <link rel="icon" href='<c:url value="/resources/imagenes/udeaIco.png" />' type="image/png" />

        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" /> '>
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/jquery.datetimepicker.min.css" /> '>
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/jquery-ui.min.css" /> '>
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/font-awesome.min.css" /> '>
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/select2.min.css" /> '>   
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/dataTables.bootstrap.min.css" />'>
        <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css" /> '>
        
        <script type="text/javascript" src='<c:url value="/resources/js/jquery-3.2.1.min.js" />' ></script>
        <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js" />' ></script>  
        <script type="text/javascript" src='<c:url value="/resources/js/jquery-ui.min.js" />'></script>
        <script type="text/javascript" src='<c:url value="/resources/js/select2.min.js" />'></script>
        <script type="text/javascript" src='<c:url value="/resources/js/knockout-3.4.2.js" />'></script>
        <script type="text/javascript" src='<c:url value="/resources/js/jquery.formatCurrency-1.4.0.min.js" />'></script>
        <script type="text/javascript" src='<c:url value="/resources/js/jquery.dataTables.min.js" />'></script>
        <script type="text/javascript" src='<c:url value="/resources/js/dataTables.bootstrap.min.js" />'></script>
        <script type="text/javascript" src='<c:url value="/resources/js/jquery.form-validator.min.js" />'></script>
    </head>
    <body>
        <header id="custom-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <img src='<c:url value="/resources/imagenes/logo-facultad.png" />' alt="Universidad de Antioquia - Facultad Nacional de Salud Pública">
                    </div>
                    <div class="col-md-5" align="right">S&iacute;guenos:&nbsp;&nbsp;
                        <a href="#" class="fa fa-facebook circle"></a>
                        <a href="#" class="fa fa-twitter circle"></a>
                        <a href="#" class="fa fa-youtube circle"></a>
                        <a href="#" class="fa fa-instagram circle"></a>
                    </div>
                    <div class="col-md-4" align="right">
                        <form class="navbar-form navbar-left">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Escriba aquí su búsqueda">
                            </div>
                            <button type="submit" class="btn btn-success">Buscar</button>
                        </form>
                    </div>
                </div>
            </div>
        </header>        
        <section id="nav-container" class="container-fluid">
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                <span class="sr-only">navegación Toggle</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="${pageContext.request.contextPath}/index">Inicio <span class="sr-only">(current)</span></a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Informaci&oacute;n<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Preguntas frecuentes</a></li>
                                        <li><a href="#">Glosario</a></li>
                                        <li><a href="#">Noticias</a></li>
                                        <li><a href="#">Eventos</a></li>
                                        <li><a href="#">Estad&iacute;sticas de salud</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="${pageContext.request.contextPath}/ofertasEmpleo">Bolsa de empleo en salud</a></li>
                                    </ul>
                                </li>


                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Documentaci&oacute;n<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Procesos e infogramas</a></li>
                                        <li><a href="#">Informes</a></li>
                                        <li><a href="#">Planes</a></li>
                                        <li><a href="#">Normatividad</a></li>

                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Publicaciones<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Boletines</a></li>
                                        <li><a href="#">Revistas</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Otra cosa aquí</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Lorem Ipsum</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Indicadores<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Internos</a></li>
                                        <li><a href="#"></a></li>
                                        <li><a href="#">Estrategos</a></li>
                                        <li><a href="#">Acreditaci&oacute;n</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Lorem Ipsum</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Activos de conocimiento<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Investigaci&oacute;n</a></li>
                                        <li><a href="#">Extensi&oacute;n</a></li>
                                        <li><a href="#">Docencia</a></li>
                                        <li><a href="#">Otras &Aacute;reas</a></li>
                                    </ul>
                                </li>

                            </ul>
                            <!-- here<li><a href="#">FNSP</a></li> -->
                            <ul class="nav navbar-nav navbar-right">

                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Open data & Free software<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Salud ambiental</a></li>
                                        <li><a href="#">Sistemas de Informaci&oacute;n de Salud</a></li>
                                        <li><a href="#">Administraci&oacute;n en Salud</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Salud ocupacional</a></li>
                                        <li><a href="#">Epidemiolog&iacute;a</a></li>
                                        <li><a href="#">Salud mental</a></li>
                                    </ul>
                                </li>
                                <li>

                                </li>
                            </ul>
                        </div><!-- /.navbar-collapse -->
                    </div><!-- /.container-fluid -->
                </nav>
            </div>
        </section>        
        <tiles:insertAttribute name="body" />
        <br />
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
        <script type="text/javascript" src='<c:url value="/resources/js/funciones.js" />'></script>
    </body>
</html>