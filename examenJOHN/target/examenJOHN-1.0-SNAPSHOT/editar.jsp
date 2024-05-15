<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }


        .header{
            border:solid black;
            width: 50%;
            padding: 1rem;
        }
    </style>
    <body>
        <div class="container">
            <div class="header">
                <div >
                    <header>
                        <h2>SEGUNDO PARCIAL TEM-742</h2>
                        <h2>Nombre: John Limber Illimani Choqueta</h2>
                        <h2>Carnet: 10067458</h2>
                    </header>
                </div>
            </div>
            <h1>Registro Dia del Internet</h1>
        </div>
        
        <div style="padding: 2rem; padding-left: 30rem ;">
            <h1><c:if test="${estudiante.id == 0}">Nuevo</c:if>
            <c:if test="${estudiante.id != 0}">Editar</c:if>
                Registro
            </h1>
            <form action="MainServlet" method="post">
                <input type="hidden" name="id" value="${estudiante.id}" /> 
            <table >
                <tr>
                    <td>NOMBRE:</td>
                    <td><input type="text" name="nombre" value="${estudiante.nombre}"/></td>
                </tr>
                <tr>
                    <td>APELLIDO:</td>
                    <td><input type="text" name="apellido" value="${estudiante.apellido}" /></td>
                </tr>
                <tr>
                    <td>SEMINARIO:</td>
                    <td><input type="text" name="seminario" value="${estudiante.seminario}" /></td>
                </tr>
                <tr>
                    <td>CONFIRMADO:</td>
                    <td>
                        <input type="checkbox" name="confirmado" value="SI" 
                               <c:if test="${estudiante.confirmado eq 'SI'}">checked</c:if>
                                   /> Confirmado
                        </td>
                    </tr>
                    <tr>
                        <td>FECHA</td>
                        <td><input type="date" name="fecha" value="${estudiante.fecha}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>

        </form>

        </div>
    </body>
</html>
