<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

 <div id="contenido">
    <div class="container">
        <div>
        <h2 style="display: inline-block;">Usuarios</h2><button type="button" style="margin-top: 10px; float:right;" class="btn btn-success" onclick="window.location.href = '${pageContext.request.contextPath}/administracion/crearUsuario'"><i class="fas fa-plus" ></i> Agregar Usuario</button>
        </div>
      <div class="table-responsive"> 
      <table style="width: 100%; margin-bottom: 30px;" id="tbusuario" class="table table-hover tableestilo" >
        <thead>
            <tr>
                <td><input type="text" id="nombreUs" class="form-control form-control-sm" placeholder="Buscar nombre"></td>
                <td><input type="text" id="personinput" class="form-control form-control-sm" placeholder="Buscar nombre de usuario"></td>
                <td><input type="text" id="perfinput" class="form-control form-control-sm" placeholder="Buscar correo electrónico"></td>
                
            </tr>
            <tr>
                
                <th>Nombre</th>
                <th>Nombre de usuario</th>
                <th>Correo electronico</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>                
                <td>${usuario.nombreApellido()}</td>
                <td>${usuario.getPerfil()}</td>
                <td>${usuario.getCorreo()}</td>
                <td>
                      <button class="btn btn-success btn-sm" onclick="mostrarUsuario(${usuario.getId()}">Ver</button>
                      <button class="btn btn-info btn-sm" style="margin-left: 10px;" onclick="validarEdicionUsuario(${usuario.getId()})"><i class="fa fa-pencil" aria-hidden="true"></i></button>
                </td>
            </tr>
        </c:forEach>

        </table>
        </div>
    </div>
</div>

<div class="modal fade" id="validacionUsuario" role="dialog">
    <div class="modal-dialog">
        <form id="validarUsuario" method="POST">
            <div class="modal-content">
                <div class="modal-header mhsuccess">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Validación Usuario</h4>                                
                </div>
                <div class="modal-body">
                    <div id="alert_placeholder_validacion_oferta_empleo"></div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="codigoOferta">Nombre de usuario</label>
                                <input type='text' class="form-control" name="nombreUsuario" id="nombreUsuarioValidar" required />
                                <input type='hidden' class="form-control" name="idUsuario" id="idUsuarioValidar" />
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
<form method="POST" id="mostrarEdicionUsuario" action="${pageContext.request.contextPath}/administracion/editarUsuario">
   <input type='hidden' class="form-control" name="idUsuarioEdicion" id="idUsuarioEdicion" />
</form>
    <script src='<c:url value="/resources/js/administracion/usuarios.js" />' ></script>
    <script>
     $(document).ready(function () {
        
        $('#validarUsuario').submit(function (evt) {
            evt.preventDefault();
            var formData = new FormData(this);
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/administracion/validarEdicion",
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    if (response === "") {
                       $('#validacionUsuario').modal('hide');
                       $('#nombreUsuarioValidar').val('');
                       $('#mostrarEdicionUsuario').submit();      
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
    function validarEdicionUsuario(idPerfil) {
        $('#idUsuarioValidar').val(idPerfil);
        $('#idUsuarioEdicion').val(idPerfil);
        
        console.log(idPerfil);
        $('#validacionUsuario').modal('show');
    }
    </script>
    