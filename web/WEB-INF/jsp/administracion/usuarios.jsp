
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                       <select  name="perfil" id="selperfil" class="js-select-basic-single" style="width: 100%;">
                            <option></option>
                            <option value="1">Administrador</option>
                            <option value="2">programador</option>
                            <option value="3">Analista</option>
                       </select>
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
           
           if($("#selpersona").val()===""){
                alert("Debe indicar la clave");
                return;
            }
            else if($("selperfil").val()===""){
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
                $('#usuario').submit();
            }    
       
        }   
    </script>


