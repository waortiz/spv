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
                <td><input type="text" id="cedinput" class="form-control form-control-sm" placeholder="Buscar cédula"></td>
                <td><input type="text" id="personinput" class="form-control form-control-sm" placeholder="Buscar persona"></td>
                <td><input type="text" id="perfinput" class="form-control form-control-sm" placeholder="Buscar perfil"></td>
                <td><input type="text" id="depinput" class="form-control form-control-sm" placeholder="Buscar dependencia"></td>
                <td><input type="text" id="esinput" class="form-control form-control-sm" placeholder="Buscar estado"></td>
            </tr>
            <tr>
                
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Correo electronico</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>                
                <td>${usuario.getNombres()}</td>
                <td>${usuario.getApellidos()}</td>
                <td>${usuario.getCorreo()}</td>
                <td>${usuario.getCorreo()}</td>
                <td>
                      <button class="btn btn-success btn-sm" onclick="mostrarUsuario(${persona.getId()})">Ver</button>
                      <button class="btn btn-info btn-sm" style="margin-left: 10px;" onclick="validarEdicionOfertaEmpleo(${ofertaEmpleo.getId()})"><i class="fa fa-pencil" aria-hidden="true"></i></button>
                </td>
            </tr>
        </c:forEach>

        </table>
        </div>
    </div>
</div>

<div class="modal" id="md_edit" tabindex="1">
          <div class="modal-dialog">
              <div class="modal-content">
              <div class="modal-header mhsuccess">
                  <h4 class="modal-title">Editar usuario</h4>
                  <button class="close" data-dismiss="modal">&times;</button>
              </div>
              <div class="modal-body">
                  <form>
                      <div class="row">
                           <div class="col-md-6">
                              <div class="form-group">
                                  <label>Persona</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Debe seleccionar el nombre de la persona" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a><br>
                                  <select  name="us_persona2" id="selpersona3"  style="width: 100%;">
                                  <option></option>
                                  <option value="juan">Juan</option>
                                  <option value="daniel">Daniel</option>
                                  <option value="jeronimo">Jeronimo</option>
                                  </select>
                              </div>
                              </div>
                              <div class="col-md-6">
                              <div class="form-group">                               
                                  <label>Perfil</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Debe seleccionar el tipo de perfil" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a><br>
                                  <select  name="rol_nombre2" id="selperfil2"  style="width: 100%;">
                                  <option></option>
                                  <option value="administrador">Administrador</option>
                                  <option value="progra">programador</option>
                                  <option value="analista">Analista</option>
                                  </select>
                              </div>
                              </div>

                              
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                              <label>Contraseña</label><a href="#" data-toggle="tooltip" data-placement="right" title = "debe crear contraseña" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a>
                              <input class="form-control form-control-sm" type="password" name="us_clave" id="us_clave">                   
                              </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">  
                                <label>Confirmar contraseña</label><a href="#" data-toggle="tooltip" data-placement="right" title = "debe escribir la contraseña para confirmar" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a>
                                <input class="form-control form-control-sm" type="password" name="us_clavecon" id="us_clavecon">                
                              </div>
                                </div>
                            </div>
                            </form>
              </div>
              <div class="modal-footer">
                  <button type="submit" class="btn btn-success" data-dismiss="modal">Guardar</button>
                    <button class="btn btn-default" data-dismiss="modal">Cancelar</button>
              </div>
              </div>
          </div>
      </div> 
    <script src='<c:url value="/resources/js/administracion/usuarios.js" />' ></script>
    
    