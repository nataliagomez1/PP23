package servicios;

import DAO.AsignaturaDAO;
import modelo.Asignatura;

import java.util.List;

public class AsignaturaServicio {
    private AsignaturaDAO asignaturaDAO;

    public AsignaturaServicio() {
        this.asignaturaDAO = new AsignaturaDAO();
    }

    public void agregarAsignatura(Asignatura asignatura) throws Exception {
        asignaturaDAO.agregarAsignatura(asignatura);
    }

    public List<Asignatura> obtenerAsignaturas() throws Exception {
        return asignaturaDAO.obtenerAsignaturas();
    }

}
