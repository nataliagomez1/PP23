package servicios;

import DAO.ActividadDAO;
import modelo.Actividad;

import java.util.List;

public class ActividadServicio {
    private ActividadDAO actividadDAO;

    public ActividadServicio(){
        this.actividadDAO= new ActividadDAO();
    }
    public void agregarActividad(Actividad actividad) throws Exception {
        actividadDAO.agregarActividad(actividad);
    }
    public List<Actividad> obtenerActividadesPorAsignatura(int asignaturaId) throws Exception {
        return actividadDAO.obtenerActividadesPorAsignatura(asignaturaId);
    }
}
