<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<section  class="container">
    <article class="">
        <div class="col-xs-12 col-sm-9"><!-- main area -->
            <form:form style="margin-top: 20px;" method="POST" enctype="multipart/form-data" modelAttribute="ofertaEmpleo">
                <form:hidden path="id" />
                <form:hidden path="tieneDocumento" />
                <div id="alert_placeholder_oferta_empleo"></div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="form-group">
                            <label for="nombreOfertante">Nombre de quien publica la oferta</label>
                            <a href="#" data-toggle="tooltip" data-placement="right" title = "Registrar el nombre de la persona que publica la oferta"><i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                                <form:input class="form-control" path="nombreOfertante" data-validation="required"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="fechaVigencia">Fecha de vigencia (cierre)</label>
                            <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe indicar la fecha de cierre de la oferta">
                                <i class="fa fa-question-circle" aria-hidden="true"></i>
                            </a> 
                            <div class='input-group date' id='datetimepicker1'>
                                <form:input class="form-control fecha" path="fechaVigencia" data-validation="required"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="form-group">
                            <label for="empresa">Empresa</label> <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe indicar el nombre de empresa u organizaci&oacute;n"><i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                                <form:input class="form-control" path="empresa" data-validation="required" />
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label>Ubicaci&oacute;n</label> <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe indicar la ubicaci&oacute;n de la empresa"><i class="fa fa-question-circle" aria-hidden="true"></i></a><br>
                                <form:input path="nombreUbicacion" class="form-control" style="width: 210px; display: inline" readonly="true" data-validation="required" />
                                <form:hidden path="ubicacion" />
                            <button type="button" class="btn btn-success btn-xs" data-target="#ubicacionModal" data-toggle="modal" style="margin-left: 10px;">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </div>
                    </div>
                    <div class="modal" tabindex="1" id="ubicacionModal">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">   
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h3 class="modal-title">Buscar ciudad</h3>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="dep">Pa&iacute;s</label><a href="#" data-toggle="tooltip" data-placement="right" title = "debe seleccionar su país" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a><br>
                                        <select style="width: 100%" name="pais" id="pais" class="js-select-basic-single js-states form-control" onchange="buscarDepartamentos(this.value)">
                                            <option value=""></option>
                                            <c:forEach var="pais" items="${paises}">
                                                <option value="${pais.getId()}">${pais.getNombre()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="departamento">Departamento</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Debe seleccionar su departamento " style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a><br>
                                        <select style="width: 100%" name="departamento" id="departamento" class="js-select-basic-single js-states form-control" onchange="buscarCiudades(this.value)"></select>
                                    </div>
                                    <div class="form-group">
                                        <label for="ciudad">Ciudad</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Debe seleccionar su ciudad " style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a><br>
                                        <select style="width: 100%" id="ciudad" name="ciudad" class="js-select-basic-single js-states form-control"></select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-success" id="seleccionUbicacion">Aceptar</button>
                                    <button type="button" class="btn btn-default" id="cancelar">Cancelar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-9">
                        <div class="form-group">
                            <label for="cargo">Cargo solicitado</label> <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe indicar el cargo"><i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                                <form:input class="form-control" path="cargo" data-validation="required" />
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="salario">Salario</label> <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe indicar el salario"><i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                                <form:input class="form-control currencyField" path="salario" data-validation="required" />
                        </div>   
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="titulo">T&iacute;tulo solicitado</label> <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe registrar el t&iacute;tulo requerido"><i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                            <form:textarea class="form-control" path="titulo" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="perfilAspirante">Perfil</label> <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe describir brevemente las habilidades y valores requeridos para el cargo"><i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                            <form:textarea class="form-control" path="perfilAspirante" />
                        </div>
                    </div>
                </div>                        
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="descripcion">Experiencia requerida</label> <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe indicar la descripci&oacute;n de la experiencia"><i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                                <form:textarea class="form-control" path="descripcion" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="experienciaMinina">A&nacute;os de experiencia m&iacute;nima</label>
                            <a href="#" data-toggle="tooltip" data-placement="right" title = "Debe indicar el tiempo de su experiencia"><i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                                <form:input class="form-control" path="experienciaMinina" />
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <label for="nivelFormacion">Nivel acad&eacute;mico requerido</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Debe seleccionar el nivel académico">
                                <i class="fa fa-question-circle" aria-hidden="true"></i></a> 
                                <form:select path="nivelFormacion" class="js-select-basic-single js-states form-control">
                                    <form:option value=""></form:option>
                                    <form:options items="${nivelesFormacion}" itemLabel="nombre" itemValue="id"/>
                                </form:select>
                        </div>
                    </div>
                </div>                
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group form-inline">
                            <label for="documento">Documento de soporte</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Puede cargar el documento de soporte de la oferta">
                            <i class="fa fa-question-circle" aria-hidden="true"></i></a>  
                            <input type="file" class="form-control" name="documento" id="documento">
                            <button class="btn btn-success btn-xs" type="button" onclick="verDocumento()" data-toggle="tooltip" data-placement="top" title="Descargar"><span class="glyphicon glyphicon-download"></span></button>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <label for="pro">Agregar datos contacto(s)</label>
                        <button style="margin-left: 10px; margin-bottom: 20px;" type="button" class="btn btn-success btn-sm" onclick="nuevoTelefono();" >
                            <span class="glyphicon glyphicon-plus"></span>
                        </button>
                        <table class="table table-hover tableestilo" id="tbtel">
                            <thead>
                                <th>Nombre del contacto</th>
                                <th>Telef&oacute;no</th>
                                <th>Correo electr&oacute;nico</th>
                                <th>&nbsp;</th>
                                <th>&nbsp;</th>
                            </thead>
                            <tbody data-bind="foreach: { data: telefonos }">
                                <tr class="table-row">
                                    <td style="width: 30%">
                                        <span data-bind="text: nombreContacto" ></span>
                                        <input type="hidden" class="form-control" data-bind="value: nombreContacto, attr: { 'name': 'telefonos[' + $index() + '].nombreContacto'  }">
                                    </td>
                                    <td style="width: 30%">
                                        <span data-bind="text: numero" ></span>
                                        <input type="hidden" class="form-control" data-bind="value: numero, attr: { 'name': 'telefonos[' + $index() + '].numero'  }">
                                    </td>
                                    <td style="width: 30%">
                                        <span data-bind="text: correoElectronico" ></span>
                                        <input type="hidden" class="form-control" data-bind="value: correoElectronico, attr: { 'name': 'telefonos[' + $index() + '].correoElectronico'  }">
                                    </td>
                                    <td style="width: 5%">
                                        <button class='btn btn-success btn-xs' type='button' data-bind="click: $root.editarTelefono"><i class='fa fa-pencil' aria-hidden='true'></i></button>
                                        <input type="hidden" data-bind="value: consecutivo, attr: { 'name': 'telefonos[' + $index() + '].consecutivo'  }" />
                                    </td>
                                    <td style="width: 5%">
                                        <button class='btn btn-danger btn-xs' type='button' data-bind="click: $root.eliminarTelefono"><span class='glyphicon glyphicon-remove'></span></button>
                                    </td>
                                </tr>
                            </tbody>                            
                        </table>
                    </div>
                </div>
                <button class="btn btn-success" type="submit">Guardar</button>
            </form:form>
        </div>
        <aside class="col-xs-12 col-sm-3" ><!-- user block -->
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
                    <h2 id="start-sesion-caption">Bienvenido ${pageContext.request.userPrincipal.getPrincipal().username}</h2>
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
<div class="modal fade" id="md_telefono" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Contacto o enlace</h4>
            </div>
            <div class="modal-body">
                <div class="row" >
                    <div class="col-md-12">
                        <div class="form-group">
                            <label>Nombre completo</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Registre el nombre completo de la persona que sirve de enlace para ampliar informaci&oacute;n sobre la oferta">
                                <i class="fa fa-question-circle" aria-hidden="true"></i></a> <br>
                            <input type="text" name="nombreContacto" id="nombreContacto" class="form-control">
                            <input type="hidden" id="consecutivo" name="consecutivo" />
                        </div>
                    </div>
                </div>
                <div class="row" >    
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="numero">N&uacute;mero telef&oacute;nico</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Registre el correo electr&oacute;nico del contacto">
                                <i class="fa fa-question-circle" aria-hidden="true"></i></a> <br> 
                            <input type="text" name="numero" id="numero" class="form-control">
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <label for="correoElectronico">Correo electr&oacute;nico</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Registre el correo electr&oacute;nico del contacto">
                                <i class="fa fa-question-circle" aria-hidden="true"></i></a> <br> 
                            <input type="email" name="correoElectronico" id="correoElectronico" class="form-control">
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">                               
                <button type="button" class="btn btn-success" data-bind="click: adicionarTelefono">Guardar</button>
                <button type="button" class="btn btn-success" data-dismiss="modal">Cancelar</button>
            </div>
        </div>              
    </div>
</div>
<div class="modal fade" id="confirmacionEliminacionTelefono" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Eliminar Teléfono</h4>                
            </div>
            <div class="modal-body">
                ¿Está seguro de eliminar el teléfono?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-success" onclick="eliminarTelefono();">Eliminar</button>
            </div>
        </div>
    </div>
</div>       
<div class="modal fade" id="confirmacionAlmacenamientoOfertaEmpleo" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Actualización Oferta Empleo</h4>                                
            </div>
            <div class="modal-body">
                La oferta de empleo se ha actualizado exitosamente
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>                            
<script>
    var optsFC = {decimalSymbol: ',', digitGroupSymbol: '.', roundToDecimalPlace: 0};
    $(document).ready(function () {
        $('#salario').keyup(function () {
            this.value = (this.value + '').replace(/[^0-9]/g, '');
        });
        $('#numero').keyup(function () {
            this.value = (this.value + '').replace(/[^0-9]/g, '');
        });
        $('#experienciaMinina').keyup(function () {
            this.value = (this.value + '').replace(/[^0-9]/g, '');
        });
        $('#seleccionUbicacion').click(function () {
            var pais = $('#pais option:selected').text().toUpperCase();
            var dep = $('#departamento option:selected').text().toUpperCase();
            var ciu = $('#ciudad option:selected').text().toUpperCase();
            $('#ubicacion').val($('#ciudad').val());
            $('#nombreUbicacion').val(pais + " - " + dep + " - " + ciu);
            $('#ubicacionModal').modal('hide');
        });
        $('.currencyField').css('text-align', 'right');
        $('.currencyField').formatCurrency(optsFC);
        $('.currencyField').blur(function () {
            $(this).formatCurrency(optsFC);
        });
        if($('#tieneDocumento').val() === 'false') {
           $('#verDocumentoOferta').attr("title", 'La oferta no tiene documento');
        } else {
           $('#verDocumentoOferta').attr("title", 'Ver documento');
        }
        $('#ofertaEmpleo').submit(function (evt) {
            evt.preventDefault();
            var formData = new FormData(this);
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/ofertasEmpleo/editar",
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    if (response === "") {
                        if($('#tieneDocumento').val() === 'false' && $('#documento').val() !== '') {
                           $('#tieneDocumento').val('true'); 
                        }
                        if($('#tieneDocumento').val() === 'false') {
                           $('#verDocumentoOferta').attr("title", 'La oferta no tiene documento');
                        } else {
                           $('#verDocumentoOferta').attr("title", 'Ver documento');
                        }
                        $('#confirmacionAlmacenamientoOfertaEmpleo').modal('show');
                    } else {
                        alert_placeholder_oferta_empleo.warning(response);
                    }
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert_placeholder_oferta_empleo.warning("Error al actualizar la oferta de empleo.");
                }});

            $('#md_confirm').modal('hide');
        });
    });

    function buscarDepartamentos(idPais) {
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/ofertasEmpleo/departamentosPais/" + idPais,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response !== "") {
                    $('#departamento').find('option').remove();
                    $('#departamento').append('<option></option>');
                    var departamentos = JSON.parse(response);
                    for (var i = 0; i < departamentos.length; i++) {
                        $('#departamento').append('<option value=' + departamentos[i].codigo + '>' + departamentos[i].nombre + '</option>');
                    }
                }
            }});
    }

    function buscarCiudades(codigoDepartamento) {
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/ofertasEmpleo/ciudadesDepartamento/" + codigoDepartamento,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response !== "") {
                    $('#ciudad').find('option').remove();
                    $('#ciudad').append('<option></option>');
                    var ciudades = JSON.parse(response);
                    for (var i = 0; i < ciudades.length; i++) {
                        $('#ciudad').append('<option value=' + ciudades[i].codigo + '>' + ciudades[i].nombre + '</option>');
                    }
                }
            }});
    }

    var telefonoEliminar = null;
    var TelefonoModel = function (telefonos) {
        self = this;
        self.telefonos = ko.observableArray(telefonos);
        self.adicionarTelefono = function () {
            var nombreContacto = $('#nombreContacto').val();
            var numero = $('#numero').val();
            var correoElectronico = $('#correoElectronico').val();
            if ($('#consecutivo').val() === "") {
                self.telefonos.push({
                    consecutivo: ko.observable(self.telefonos().length + 1),
                    nombreContacto: ko.observable(nombreContacto),
                    numero: ko.observable(numero),
                    correoElectronico: ko.observable(correoElectronico)
                });
            } else {
                var consecutivo = parseInt($('#consecutivo').val(), 10);
                var indice = 0;
                for (i = 0; i < self.telefonos().length; i++) {
                    if (self.telefonos()[i].consecutivo() === consecutivo) {
                        indice = i;
                        break;
                    }
                }
                self.telefonos()[indice].nombreContacto(nombreContacto);
                self.telefonos()[indice].numero(numero);
                self.telefonos()[indice].correoElectronico(correoElectronico);
            }
            $('#md_telefono').modal('hide');
            $('#nombreContacto').val("");
            $('#numero').val("");
            $('#correoElectronico').val("");
        };
        self.eliminarTelefono = function (telefono) {
            telefonoEliminar = telefono;
            $('#confirmacionEliminacionTelefono').modal('show');
        };
        self.editarTelefono = function (telefono) {
            $('#nombreContacto').val(telefono.nombreContacto());
            $('#numero').val(telefono.numero());
            $('#correoElectronico').val(telefono.correoElectronico());
            $('#consecutivo').val(telefono.consecutivo());
            $('#md_telefono').modal('show');
        };
    };

    function nuevoTelefono() {
        $('#nombreContacto').val('');
        $('#numero').val('');
        $('#correoElectronico').val('');
        $('#consecutivo').val('');
        $('#md_telefono').modal('show');
    }

    function eliminarTelefono() {
        telefonoModel.telefonos.remove(telefonoEliminar);
        $('#confirmacionEliminacionTelefono').modal('hide');
    }

    function verDocumento() {
        if ($('#tieneDocumento').val() === "true") {
            window.location.href = "${pageContext.request.contextPath}/ofertasEmpleo/documento/" + $('#id').val();
        }
    }

    var telefonos = [];
    <c:if test = "${telefonosJSON != null}">
    telefonos = ${telefonosJSON};
    </c:if>

    var telefonoModel = new TelefonoModel(telefonos);
    ko.applyBindings(telefonoModel);

    alert_placeholder_oferta_empleo = function () { };
    alert_placeholder_oferta_empleo.warning = function (message) {
        $('#alert_placeholder_oferta_empleo').html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">×</a><span>' + message + '</span></div>');
    };
    alert_placeholder_oferta_empleo.success = function (message) {
        $('#alert_placeholder_oferta_empleo').html('<div class="alert alert-success"><a class="close" data-dismiss="alert">×</a><span>' + message + '</span></div>');
    };
    alert_placeholder_oferta_empleo.removeWarning = function () {
        $('#alert_placeholder_oferta_empleo').html('');
    };
</script>
