package modelo;
import java.util.ArrayList;


public class Asignatura {
    private int id;
    private String nombre;
    private ArrayList<Actividad> listaActividades;

    public Asignatura() {
    }

    public Asignatura(int id, String nombre, ArrayList<Actividad> listaActividades) {
        this.id = id;
        this.nombre = nombre;
        this.listaActividades = listaActividades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(ArrayList<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

}
