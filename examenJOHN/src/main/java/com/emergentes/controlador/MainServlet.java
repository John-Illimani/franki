/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.modelo.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.EstudiantesDAO;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EstudiantesDAO dao = new EstudiantesDAOimpl();
            int id;
            Estudiantes avi = new Estudiantes();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("estudiante", avi);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    request.setAttribute("estudiante", avi); 
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/MainServlet");
                    break;
                case "view":
                    List<Estudiantes> lista = dao.getAll();

                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String seminario = request.getParameter("seminario");
        String confirmado = request.getParameter("confirmado");
        String fecha = request.getParameter("fecha");
        
        Estudiantes avi = new Estudiantes();

        avi.setId(id);
        avi.setNombre(nombre);
        avi.setApellido(apellido);
        avi.setSeminario(seminario);
        avi.setConfirmado(confirmado);
        avi.setFecha(fecha);

        if (id == 0) {
            try {
                EstudiantesDAO dao = new EstudiantesDAOimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath() + "/MainServlet");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }

        } else {
            try {
                EstudiantesDAO dao = new EstudiantesDAOimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath() + "/MainServlet");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

}
