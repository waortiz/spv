<%-- 
    Document   : error
    Created on : 08-jul-2017, 22:38:40
    Author     : William
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div id="contenido" >
    <div class="container">
        <div class="form-group">
            <ul class="nav nav-tabs">
                <li class="active" id="liconvoca"><a data-toggle="tab" href="#tabspanish" >
                        Espa&ntilde;ol</a></li>
                <li id="licrihab"><a data-toggle="tab" href="#tabenglish" >
                        English</a></li>     
            </ul>
        </div>
        <div class="tab-content">
            <div class="tab-pane fade in active" id="tabspanish">
                <div class="row">
                    <div class="col-md-4">
                        <img src='<c:url value="/resources/imagenes/imgerrorfondoblanco.png" />' style="width: 250px;">
                    </div>
                    <div class="col-md-6">
                        <h2 style="font-weight: bold;">OOPS!!!</h2><br>
                        <p style="font-size: 18px;">
                            Algo anda mal o el servicio está en mantenimiento.<br>
                            Estamos trabajando muy duro para resolver los problemas.<br>
                            Por favor intente más tarde. <br>
                            Si el problema persiste comuníquese al correo:
                        </p>
                        <a href="'${pageContext.request.contextPath}/index" style="margin-top: 20px;font-size: 18px;">Regresar a la página de inicio</a>
                    </div>
                </div>
            </div>
            <div class="tab-pane" id="tabenglish">
                <div class="row">
                    <div class="col-md-4">
                        <img src='<c:url value="/resources/imagenes/imgerrorfondoblanco.png" />' style="width: 250px;">
                    </div>
                    <div class="col-md-6">
                        <h2 style="font-weight: bold;">OOPS!!!</h2><br>
                        <p style="font-size: 18px;">
                            Something just went wrong or the service is in maintenance. <br>
                            We are currently working hard to fix the problem. <br>
                            Please try again later. <br>
                            If the problem persists, contact the mail: 
                        </p>
                        <a href="i'${pageContext.request.contextPath}/index" style="margin-top: 20px;font-size: 18px;">Return to homepage</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>