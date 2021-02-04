
<%@page import="java.util.List"%>
<%@page import="co.edu.fnsp.spv.entidades.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="card" style="padding: 10px">
    <div class="card-header"><h3>Agregar usuario</h3></div>
    <div class="card-body">
        <form method="post" id="usuario">
            
            
            <div class="row">
                <div class="col-md-6">
                   <div class="form-group">
                       <label>Persona</label><a href="#" data-toggle="tooltip" data-placement="right" title = "Debe seleccionar el nombre de la persona" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a><br>
                       <select  name="persona" id="selpersona" class="js-select-basic-single" style="width: 100%;">
                       <option value = "" ></option>
                            <c:forEach var="persona" items="${personas}">
                                
                                <option value="${persona.getId()}">${persona.nombreApellido()}</option>
                                
                            </c:forEach>
                            
                       </select>
                   </div>
                </div>
                <div class="col-md-6" style="display: none">
                    <div class="form-group">
                        <label>Perfil</label><a href="#" data-toggle="tooltip" data-placement="right" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a>
                        <input class="form-control form-control-sm"name="perfil" id="us_usuario">                   
                    </div>
                </div>
            </div>
                       
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Contraseña</label><a href="#" data-toggle="tooltip" data-placement="right" title = "debe crear contraseña" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a>
                        <input class="form-control form-control-sm" type="password" name="clave" id="us_clave">                   
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">  
                        <label>Confirmar contraseña</label><a href="#" data-toggle="tooltip" data-placement="right" title = "debe escribir la contraseña para confirmar" style="margin-left: 5px;"><i class="fa fa-question-circle" aria-hidden="true"></i></a>
                        <input class="form-control form-control-sm" type="password" name="clavecon" id="us_clavecon">                
                    </div>
                </div>
            </div>

            <button class="btn btn-success" type="button" onclick="mostrar()">Guardar</button>
            <!--<input type="submit" value="Submit">-->
        </form>
    </div>
    
</div>
  
    <script>
        
        var i = 0;
        function mostrar() {
           
           if($("#selpersona").val()=== ""){
                alert("Debe indicar la clave");
                return;
            }
            else if($("#us_clave").val()===""){
                alert("Debe indicar la clave");
                return;
            }
            else if($("#us_clavecon").val()===""){
                alert("Debe indicar la clave");
                return;
            }
            else if($("#us_clave").val()!==$("#us_clavecon").val()){
                alert("Las contraseñas deben coincidir");
                $("#us_clave").val("");
                $("#us_clavecon").val("");
                return;
                
            }
           else{
               //onsole.log("#us_perfil").val());
               $('#usuario').submit();
            }    
       
        }   
    </script>



