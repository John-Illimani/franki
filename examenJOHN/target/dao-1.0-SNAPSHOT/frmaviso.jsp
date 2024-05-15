<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : frmaviso
    Created on : 14 may. 2024, 09:47:27
    Author     : illim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${aviso.id == 0}">Nuevo</c:if>
            <c:if test="${aviso.id != 0}">Editar</c:if>
                aviso
            </h1>
            <form action="inicio" method="post">
                <input type="hidden" name="id" value="${aviso.id}" /> 
            <table >
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value="${aviso.titulo}"/></td>
                </tr>
                <tr>
                    <td>Contenido</td>
                    <td><input type="text" name="contenido" value="${aviso.contenido}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>

        </form>

    </body>
</html>
