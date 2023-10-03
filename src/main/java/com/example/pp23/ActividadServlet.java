package com.example.pp23;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modelo.Actividad;
import modelo.Asignatura;
import modelo.TipoActividad;
import servicios.ActividadServicio;
import servicios.AsignaturaServicio;

@WebServlet(name = "actividadServlet", value = "/actividad-servlet")
public class ActividadServlet extends HttpServlet{
    private ActividadServicio actividadService = new ActividadServicio();
    private AsignaturaServicio asignaturaServicio= new AsignaturaServicio();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Asignatura> todasLasAsignaturas = asignaturaServicio.obtenerAsignaturas();
            req.setAttribute("todasLasAsignaturas", todasLasAsignaturas);

            int idAsignatura = Integer.parseInt(req.getParameter("idAsignatura"));
            // Obtener lista de actividades para una asignatura específica
            List<Actividad> actividades = actividadService.obtenerActividadesPorAsignatura(idAsignatura);

            // Pasar la lista al request para que esté disponible en el JSP
            req.setAttribute("actividades", actividades);

            // Redirigir al JSP de actividades
            req.getRequestDispatcher("/actividad.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores (redirigir a una página de error, registrar el error, etc.)
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtener datos de la actividad desde el formulario
            String nombre = req.getParameter("nombre");
            String tipoActividadParam = req.getParameter("tipoActividad");
            String ponderadoParam = req.getParameter("ponderado");
            String fechaParam = req.getParameter("fecha");
            String notaParam = req.getParameter("nota");
            String idAsignaturaParam = req.getParameter("idAsignatura"); // Asumiendo que se envía el ID de la asignatura cuando se crea la actividad

// Crear el objeto Actividad
            Actividad actividad = new Actividad();

            actividad.setNombre(nombre);
            actividad.setTipoActividad(TipoActividad.valueOf(tipoActividadParam)); // Convierte el String a Enum

// Convertir y establecer el ponderado
            double ponderado = Double.parseDouble(ponderadoParam);
            actividad.setPonderado(ponderado);

// Convertir y establecer la fecha
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Asumiendo que la fecha se envía en este formato desde el formulario
            Date fecha = format.parse(fechaParam);
            actividad.setFecha(fecha);

// Convertir y establecer la nota
            double nota = Double.parseDouble(notaParam);
            actividad.setNota(nota);

// Convertir y establecer el ID de la asignatura
            int idAsignatura = Integer.parseInt(idAsignaturaParam);
            actividad.setIdAsignatura(idAsignatura);

// Ahora puedes guardar la actividad utilizando el servicio
            actividadService.agregarActividad(actividad);


            // Redirigir de nuevo a la lista de actividades para una asignatura específica
            resp.sendRedirect(req.getContextPath() + "/actividad-servlet?idAsignatura=" + actividad.getIdAsignatura());
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores (redirigir a una página de error, registrar el error, etc.)
        }
    }
}
