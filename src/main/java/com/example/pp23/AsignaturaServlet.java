package com.example.pp23;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modelo.Asignatura;
import servicios.AsignaturaServicio;

import java.util.List;

@WebServlet(name = "asignaturaServlet", value = "/asignatura-servlet")
public class AsignaturaServlet extends HttpServlet{
    private AsignaturaServicio asignaturaService = new AsignaturaServicio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("ESTE ES EL DO GET");
            // Obtener lista de asignaturas
            List<Asignatura> asignaturas = asignaturaService.obtenerAsignaturas();
            System.out.println(asignaturas);


            // Pasar la lista al request para que esté disponible en el JSP
            req.setAttribute("asignaturas", asignaturas);

            // Redirigir al JSP de asignaturas
            req.getRequestDispatcher("asignatura.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores (redirigir a una página de error, registrar el error, etc.)
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtener datos de la asignatura desde el formulario
            String nombre = req.getParameter("nombre");
            // Aquí puedes obtener más campos si los tienes

            // Crear el objeto Asignatura
            Asignatura asignatura = new Asignatura();
            asignatura.setNombre(nombre);
            // Establecer otros campos si los tienes

            // Guardar la asignatura utilizando el servicio
            asignaturaService.agregarAsignatura(asignatura);

            // Redirigir de nuevo a la lista de asignaturas
            resp.sendRedirect(req.getContextPath() + "/asignatura-servlet");
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores (redirigir a una página de error, registrar el error, etc.)
        }
    }


}
