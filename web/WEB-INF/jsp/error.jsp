<%-- 
    Document   : error
    Created on : 08-jul-2017, 22:38:40
    Author     : William
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="centering text-center">
           <strong>${error}&nbsp;</strong><a href='${pageContext.request.contextPath}/index'  title='Inicio' >
                    <input type='button' class='btn-sm btn-success' value='Ir al inicio' /></a>
        </div>
    </div>
</div>