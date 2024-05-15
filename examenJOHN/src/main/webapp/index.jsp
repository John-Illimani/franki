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
        body{
            padding: 2rem;
        }
        .button{
            padding-left: 18rem;
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
        <div class="button">
            <p ><a href="MainServlet?action=add">Nuevo</a> </p>
        </div>


        <div class="container">
            <div class="table">
                <table border="1" cellspacing="0">
                    <tr>
                        <th style="width: 3rem">id</th>
                        <th style="width: 7rem">Nombres</th>
                        <th style="width: 2rem">Apellidos</th>
                        <th style="width: 2rem">Seminario</th>
                        <th style="width: 2rem">Confirmado</th>
                        <th style="width: 10rem">Fecha Inscripcion</th>
                        <th style="width: 4rem"></th>
                        <th style="width: 4rem"></th>
                    </tr>
                    <c:forEach var="item" items="${estudiantes}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.nombre}</td>
                            <td>${item.apellido}</td>
                            <td>${item.seminario}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${item.confirmado eq 'SI'}">
                                        <input type="checkbox" checked disabled>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" disabled>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${item.fecha}</td>
                            <td><a href="MainServlet?action=edit&id=${item.id}">Editar</a></td>
                            <td><a href="MainServlet?action=delete&id=${item.id}" onclick="return(confirm("esta seguro?"))" >Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
