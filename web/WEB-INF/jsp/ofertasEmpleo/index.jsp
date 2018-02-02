<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<section  class="container">
    <article class="">
        <div class="col-xs-12 col-sm-9"><!-- main area -->
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <div >
                            <h4 style="display: inline-block;"><i class="fa fa-briefcase" aria-hidden="true"></i> Ofertas de empleo en salud disponibles</h4><button class="btn btn-success" style="float:right;" onclick="window.location.href = '${pageContext.request.contextPath}/ofertasEmpleo/crear'">Agregar oferta</button>
                        </div>
                    </div>
                    <div id="addscroll">
                        <div class="table-responsive">
                            <table class="table table-hover tableestilo" id="ofertasEmpleo">
                                <thead>
                                    <tr>
                                        <td><input type="text" name="" class="form-control input-sm" data-index="0" placeholder="Buscar" id="busquedaEmpresa"></td>
                                        <td><input type="text" name="" class="form-control input-sm" data-index="1" placeholder="Buscar" id="busquedaCargo"></td>
                                        <td><input type="text" name="" class="form-control input-sm" data-index="2" placeholder="Buscar" id="busquedaNivelFormacion"></td>
                                        <td><input type="text" name="" class="form-control input-sm" data-index="3" placeholder="Buscar" id="busquedaSalario"></td>
                                        <td><input type="text" name="" class="form-control input-sm" data-index="4" placeholder="Buscar" id="busquedaFechaVigencia"></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <th>Empresa</th>
                                        <th>Cargo</th> 
                                        <th>Nivel acad&eacute;mico</th>
                                        <th>Salario</th> 
                                        <th>Vigencia(cierre)</th>
                                        <th>&nbsp;</th>
                                    </tr>             
                                </thead>
                                <tbody>
                                    <c:forEach var="ofertaEmpleo" items="${ofertasEmpleo}">   
                                        <tr>
                                            <td>${ofertaEmpleo.getEmpresa()}</td>
                                            <td>${ofertaEmpleo.getCargo()}</td>
                                            <td>${ofertaEmpleo.getNombreNivelFormacion()}</td>
                                            <td>${ofertaEmpleo.getSalarioFormateado()}</td>
                                            <td>${ofertaEmpleo.getFechaVigenciaFormateada()}</td>
                                            <td style='white-space: nowrap'>
                                                <button class="btn btn-success btn-sm" onclick="mostrarOfertaEmpleo(${ofertaEmpleo.getId()})">Ver</button>
                                                <button class="btn btn-info btn-sm" style="margin-left: 10px;" onclick="validarEdicionOfertaEmpleo(${ofertaEmpleo.getId()})"><i class="fa fa-pencil" aria-hidden="true"></i></button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>                    
            </div>
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
            <!--modal ver informacion-->
            <div id="modalOfertaEmpleo" class="modal fade" role="dialog">
                <div class="modal-dialog modal-lg">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header mhsuccess">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4><i class="fa fa-address-book-o" aria-hidden="true"></i> Descripci&oacute;n de la oferta</h4>
                        </div>
                        <div class="modal-body">  
                            <div class="row">
                                <input type="hidden" id="idOfertaEmpleo">
                                <input type="hidden" id="tieneDocumento">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label>Fecha de publicaci&oacute;n:</label>
                                        <input id="fechaPublicacion" disabled style="border: 0; text-align: center;margin-left: 0px; font-style: italic;font-weight: normal; width: 140px;" value=""></input>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Fecha de cierre:</label>
                                        <input id="fechaCierre" disabled style="border: 0; text-align: center;margin-left: 0px; font-style: italic;font-weight: normal; width: 140px;"></input>
                                    </div> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label>Empresa:</label>
                                        <label style="border: 0; text-align: left;margin-left: 3px; font-style: italic;font-weight: normal;">
                                            <span id="empresa" />                                        
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Ubicaci&oacute;n:</label>
                                        <label style="border: 0; text-align: left;margin-left: 3px; font-style: italic;font-weight: normal;">
                                            <span id="ubicacion" />                                        
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label>Cargo:</label>
                                        <label style="border: 0; text-align: left;margin-left: 3px; font-style: italic;font-weight: normal;">
                                            <span id="cargo" />
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <label>Salario:</label>
                                    <label style="border: 0; text-align: left;margin-left: 3px; font-style: italic;font-weight: normal;">
                                        <span id="salario" />
                                    </label>
                                </div>                            
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>T&iacute;tulo requerido:</label>
                                        <label style="border: 0; text-align: left;margin-left: 3px; font-style: italic;font-weight: normal;">
                                            <span id="titulo" />
                                        </label>
                                    </div>
                                </div>
                            </div>  
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Perfil del aspirante:</label>
                                        <textarea disabled style="border: 1;border-style:dotted;border-color:#aeb6bf;margin-left: 1px;width: 98%;" id="perfilAspirante"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Experiencia requerida</label>
                                        <textarea disabled style="border: 1;border-style:dotted;border-color:#aeb6bf;margin-left: 1px;width: 98%;" id="descripcion"></textarea>                                    
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Años de experiencia m&iacute;nima:</label>
                                        <label style="border: 0; text-align: left;margin-left: 3px; font-style: italic;font-weight: normal;">
                                            <span id="experienciaMinina" />
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <label>Nivel acad&eacute;mico requerido:</label>
                                    <label style="border: 0; text-align: left;margin-left: 3px; font-style: italic;font-weight: normal;">
                                        <span id="nivelFormacion" />
                                    </label>								
                                </div>
                            </div>                                
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Documento de soporte:</label>
                                        <a id="verDocumentoOferta" href="#" onclick="verDocumento()" title="Ver documento" style="margin-left: 30px;" class="btn btn-success btn-sm"><i class="fa fa-file-pdf-o" aria-hidden="true"> </i></a>
                                    </div>
                                </div>
                            </div>                        
                            <div class="row">
                                <div class="col-md-12">
                                    <legend><center>Contacto(s) o enlace(s) empresariales</center></legend>
                                    <table class="table table-hover tableestilo" id="telefonos">
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Telef&oacute;no</th>
                                                <th>Correo Electrónico</th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>  
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--fin modal de ver informacion-->
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
<div class="modal fade" id="validacionEdicionOfertaEmpleo" role="dialog">
    <div class="modal-dialog">
        <form id="validarEdicionOfertaEmpleo" method="POST">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Validación Oferta Empleo</h4>                                
                </div>
                <div class="modal-body">
                    <div id="alert_placeholder_validacion_oferta_empleo"></div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="codigoOferta">Código de la oferta de empleo</label>
                                <input type='text' class="form-control" name="codigoOfertaEmpleoValidar" id="codigoOfertaEmpleoValidar" required />
                                <input type='hidden' class="form-control" name="idOfertaEmpleoValidar" id="idOfertaEmpleoValidar" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Aceptar</button>
                    <button type="button" class="btn btn-success" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </form>
    </div>
</div>
<form method="POST" id="mostrarEdicionOfertaEmpleo" action="${pageContext.request.contextPath}/ofertasEmpleo/mostrarEdicion">
   <input type='hidden' class="form-control" name="idOfertaEmpleoEdicion" id="idOfertaEmpleoEdicion" />
</form>
<script>
    var telefonos = null;
    $(document).ready(function () {
        var table = $('#ofertasEmpleo').DataTable({
            "language": {
                "sProcessing": "Procesando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningún dato disponible en esta tabla",
                "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sInfoPostFix": "",
                "sSearch": "Buscar:",
                "sUrl": "",
                "sInfoThousands": ",",
                "sLoadingRecords": "Cargando...",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast": "Último",
                    "sNext": "Siguiente",
                    "sPrevious": "Anterior"}
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        });

        telefonos = $('#telefonos').DataTable({
            "language": {
                "sProcessing": "Procesando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningún dato disponible en esta tabla",
                "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sInfoPostFix": "",
                "sSearch": "Buscar:",
                "sUrl": "",
                "sInfoThousands": ",",
                "sLoadingRecords": "Cargando...",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast": "Último",
                    "sNext": "Siguiente",
                    "sPrevious": "Anterior"}
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        });

        $('#busquedaEmpresa').on('keyup', function () {
            table
                    .columns(0)
                    .search(this.value)
                    .draw();
        });
        $('#busquedaCargo').on('keyup', function () {
            table
                    .columns(1)
                    .search(this.value)
                    .draw();
        });
        $('#busquedaNivelFormacion').on('keyup', function () {
            table
                    .columns(2)
                    .search(this.value)
                    .draw();
        });
        $('#busquedaSalario').on('keyup', function () {
            table
                    .columns(3)
                    .search(this.value)
                    .draw();
        });
        $('#busquedaFechaVigencia').on('keyup', function () {
            table
                    .columns(4)
                    .search(this.value)
                    .draw();
        });
        $('#validarEdicionOfertaEmpleo').submit(function (evt) {
            evt.preventDefault();
            var formData = new FormData(this);
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/ofertasEmpleo/validarEdicion",
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    if (response === "") {
                       $('#validacionEdicionOfertaEmpleo').modal('hide');
                       $('#codigoOferta').val('');
                       $('#mostrarEdicionOfertaEmpleo').submit();      
                    } else {
                        alert_placeholder_validacion_oferta_empleo.warning(response);
                    }
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert_placeholder_validacion_oferta_empleo.warning("Error al validar la oferta de empleo.");
                }});

            $('#md_confirm').modal('hide');
        });        
    });

    function mostrarOfertaEmpleo(idOfertaEmpleo) {
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/ofertasEmpleo/" + idOfertaEmpleo,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response !== "") {
                    var ofertaEmpleo = JSON.parse(response);
                    $('#idOfertaEmpleo').val(ofertaEmpleo.id);
                    $('#fechaPublicacion').val(ofertaEmpleo.fechaPublicacionFormateada);
                    $('#fechaCierre').val(ofertaEmpleo.fechaVigenciaFormateada);
                    $('#empresa').html(ofertaEmpleo.empresa);
                    $('#ubicacion').html(ofertaEmpleo.nombreUbicacion);
                    $('#cargo').html(ofertaEmpleo.cargo);
                    $('#titulo').html(ofertaEmpleo.titulo);
                    $('#perfilAspirante').val(ofertaEmpleo.perfilAspirante);
                    $('#descripcion').val(ofertaEmpleo.descripcion);
                    $('#salario').html(ofertaEmpleo.salarioFormateado);
                    $('#experienciaMinina').html(ofertaEmpleo.experienciaMinina);
                    $('#nivelFormacion').html(ofertaEmpleo.nombreNivelFormacion);
                    telefonos.clear().draw();
                    for (var i = 0; i < ofertaEmpleo.telefonos.length; i++) {
                        telefonos.row.add(
                                [
                                    ofertaEmpleo.telefonos[i].nombreContacto,
                                    ofertaEmpleo.telefonos[i].numero,
                                    ofertaEmpleo.telefonos[i].correoElectronico,
                                ]
                                ).draw();
                    }
                    $('#tieneDocumento').val(ofertaEmpleo.tieneDocumento);
                    if (!ofertaEmpleo.tieneDocumento) {
                        $('#verDocumentoOferta').attr("title", 'La oferta no tiene documento');
                    } else {
                        $('#verDocumentoOferta').attr("title", 'Ver documento');
                    }
                    $('#modalOfertaEmpleo').modal('show');
                }
            }});
    }

    function validarEdicionOfertaEmpleo(idOfertaEmpleo) {
        $('#idOfertaEmpleoValidar').val(idOfertaEmpleo);
        $('#idOfertaEmpleoEdicion').val(idOfertaEmpleo);
        $('#validacionEdicionOfertaEmpleo').modal('show');
    }

    function verDocumento() {
        if ($('#tieneDocumento').val() === "true") {
            window.location.href = "${pageContext.request.contextPath}/ofertasEmpleo/documento/" + $('#idOfertaEmpleo').val();
        }
    }

    alert_placeholder_validacion_oferta_empleo = function () { };
    alert_placeholder_validacion_oferta_empleo.warning = function (message) {
        $('#alert_placeholder_validacion_oferta_empleo').html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">×</a><span>' + message + '</span></div>');
    };
    alert_placeholder_validacion_oferta_empleo.success = function (message) {
        $('#alert_placeholder_validacion_oferta_empleo').html('<div class="alert alert-success"><a class="close" data-dismiss="alert">×</a><span>' + message + '</span></div>');
    };
    alert_placeholder_validacion_oferta_empleo.removeWarning = function () {
        $('#alert_placeholder_validacion_oferta_empleo').html('');
    };
</script>
