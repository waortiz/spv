<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="container">
    <article class="">
        <div class="col-xs-12 col-sm-9"><!-- main area -->
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.authenticated}">
                    <div class="row" id="main-area" >
                        <div class="col-xs-6 col-md-3">
                            <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/buho" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/buho.png"/>' alt="BUHO - Banco de Hojas de Vida">
                            </a>
                            <div class="icon-text">
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/buho"><h2>BUHO</h2></a>
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/buho"><h4>Banco de Hojas de Vida</h4></a>
                            </div>
                        </div>
                       <div class="col-xs-6 col-md-3">
                            <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/siso" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/siso.png"/>' alt="SISO - Sistema de Gesti&oacute;n de Solicitudes">
                            </a>
                            <div class="icon-text">
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/siso"><h2>SISO</h2></a>
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/siso"><h4>Sistema de Gesti&oacute;n de Solicitudes</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/sigep" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/sigep.png"/>' alt="SIGEP - Sistema de Gesti&oacute;n de Proyectos">
                            </a>
                            <div class="icon-text">
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/sigep"><h2>SIGEP</h2></a>
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/sigep"><h4>Sistema de Gesti&oacute;n de Proyectos</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/siau.png"/>' alt="SIAU - Sistema de Administraci&oacute;n de aulas y auditorios">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SIAU</h2></a>
                                <a href="#"><h4>Sistema de Administraci&oacute;n de aulas y auditorios</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/sisrec.png"/>' alt="SISREC - Sistema de Reportes de Contratos">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SISREC</h2></a>
                                <a href="#"><h4>Sistema de Reportes de Contratos</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/siac.png"/>' alt="SIAC-Sistema de Administraci&oacute;n de Contratos">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SIAC</h2></a>
                                <a href="#"><h4>Sistema de Administraci&oacute;n de Contratos</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/soca.png"/>' alt="SOCA-Solicitudes Comit&eacute; de asuntos estudiantiles">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SOCA</h2></a>
                                <a href="#"><h4>Evaluaci&oacute;n de cursos</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">

                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/glpi.png"/>' alt="SGLPI - servicios inform&aacute;ticos, de comunicación y generales">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SGLPI</h2></a>
                                <a href="#"><h4>Solicitudes inform&aacute;ticas, de comunicaci&oacute;n y generales</h4></a>
                            </div>			  
                        </div>
                        <div class="col-xs-6 col-md-3">

                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/glpi.png"/>' alt="EVA - Entornos Virtuales de Aprendizaje">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>EVA</h2></a>
                                <a href="#"><h4>Entornos Virtuales de Aprendizaje</h4></a>
                            </div>	
                        </div>                    
                    </div>                    
                    </c:when>
                    <c:otherwise>
                    <div class="row" id="main-area" >
                        <div class="col-xs-6 col-md-3">
                            <a href="${pageContext.request.contextPath}/ofertasEmpleo" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/besalud.png"/>' alt="BESALUD - Bolsa de empleo en salud">
                            </a>
                            <div class="icon-text">
                                <a href="${pageContext.request.contextPath}/ofertasEmpleo"><h2>BESALUD</h2></a>
                                <a href="${pageContext.request.contextPath}/ofertasEmpleo"><h4>Bolsa de Empleo en Salud</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/buho" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/buho.png"/>' alt="BUHO - Banco de Hojas de Vida">
                            </a>
                            <div class="icon-text">
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/buho"><h2>BUHO</h2></a>
                                <a href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/buho"><h4>Banco de Hojas de Vida</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/ssofi.png"/>' alt="SSOFI - Sistema de Solicitudes">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SSOFI</h2></a>
                                <a href="#"><h4>Sistema de Solicitudes</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/siau.png"/>' alt="SIAU - Sistema de Administraci&oacute;n de aulas y auditorios">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SIAU</h2></a>
                                <a href="#"><h4>Sistema de Administraci&oacute;n de aulas y auditorios</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/soca.png"/>' alt="SOCA - Solicitudes comit&eacute; de asuntos estudiantiles">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SOCA</h2></a>
                                <a href="#"><h4>Solicitudes comit&eacute; de asuntos estudiantiles</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/evaluacion-docente.png"/>' alt="Evaluaci&oacute;n docente">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>EVA</h2></a>
                                <a href="#"><h4>Evaluaci&oacute;n docente</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/evaluacion-cursos.png"/>' alt="Evaluaci&oacute;n de cursos">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>EVA</h2></a>
                                <a href="#"><h4>Evaluaci&oacute;n de cursos</h4></a>
                            </div>
                        </div>
                        <div class="col-xs-6 col-md-3">

                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/glpi.png"/>' alt="SGLPI - servicios inform&aacute;ticos, de comunicación y generales">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>SGLPI</h2></a>
                                <a href="#"><h4>Solicitudes inform&aacute;ticas, de comunicaci&oacute;n y generales</h4></a>
                            </div>			  
                        </div>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src='<c:url value="/resources/imagenes/glpi.png"/>' alt="EVA - Entornos Virtuales de Aprendizaje">
                            </a>
                            <div class="icon-text">
                                <a href="#"><h2>EVA</h2></a>
                                <a href="#"><h4>Entornos Virtuales de Aprendizaje</h4></a>
                            </div>	
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div><!-- end main area -->
        <aside class="col-xs-12 col-sm-3"><!-- user block -->
            <c:choose>
                <c:when test="${!pageContext.request.userPrincipal.authenticated}">
                    <div id="login-icon">
                        <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                    </div>
                    <h2 id="start-sesion-caption">Ingresar</h2>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div id="mensajeLogin" class="label"></div>                    
                            <form method="POST" id="loginForm" action="<c:url value='/login' />">
                                <p><label for="username" class="sr-only">Nombre de usuario</label>
                                    <input type="text" id="username" name="username" class="form-control" placeholder="Nombre de usuario" required autofocus>
                                    <label for="password" class="sr-only">Contraseña</label></p>
                                <input type="password" name="password" id="password" class="form-control" placeholder="Contraseña" required>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Recordar datos">
                                        Recordar datos
                                    </label>
                                </div>
                                <p><a href="#" data-toggle="modal" data-target="#lostPassword">Olvidé la contraseña</a></p>
                                <div align="center"><button class="btn btn-lg btn-primary" type="submit">Iniciar sesi&oacute;n</button></div>
                            </form>
                            <div class="modal fade" id="lostPassword" tabindex="-1" role="dialog">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title">Recuperar contraseña</h4>
                                        </div>
                                        <div class="modal-body">
                                            <h4>Se enviará un correo electrónico para la recuperación de su contraseña</h4>
                                            <form method="post" id="lostPasswordForm">
                                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Correo electrónico">
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                            <button type="button" class="btn btn-primary">Enviar</button>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </div><!-- /.modal -->
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="login-icon">
                        <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                    </div>
                    <h2 id="start-sesion-caption">Bienvenido ${pageContext.request.userPrincipal.getPrincipal().getNombreUsuario()}</h2>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
                                <li role="presentation"><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
                            </ul>
                        </div>
                    </div>                
                </c:otherwise>  
            </c:choose>
            <div id="carousel-info" class="carousel slide" data-ride="carousel"> <!-- slides info -->
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-info" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-info" data-slide-to="1"></li>
                    <li data-target="#carousel-info" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src='<c:url value="/resources/imagenes/eva-app.jpg"/>' alt="...">
                        <div class="carousel-caption">
                            <span><A href="#">&nbsp;</A></span>
                        </div>
                    </div>
                    <div class="item">
                        <img src='<c:url value="/resources/imagenes/glpi-app.jpg"/>' alt="...">
                        <div class="carousel-caption">
                            <span><A href="#">&nbsp;</A></span>
                        </div>
                    </div>
                    <div class="item">
                        <img src='<c:url value="/resources/imagenes/siac-app.jpg"/>' alt="...">
                        <div class="carousel-caption">
                            <span><A href="#">&nbsp;</A></span>
                        </div>
                    </div>
                </div>
                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-info" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-info" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div> <!-- end slides info -->
        </aside><!-- end user block -->
    </article>
</section>
