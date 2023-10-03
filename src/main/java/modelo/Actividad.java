package modelo;

import java.util.Date;

public class Actividad {
    private int id;
    private int idAsignatura;
    private TipoActividad tipoActividad;
    private String nombre;
    private double ponderado;
    private Date fecha;
    private double nota;


    public Actividad() {
    }

    public Actividad(int id, int idAsignatura, TipoActividad tipoActividad, String nombre, double ponderado, Date fecha, double nota) {
        this.id = id;
        this.idAsignatura = idAsignatura;
        this.tipoActividad = tipoActividad;
        this.nombre = nombre;
        this.ponderado = ponderado;
        this.fecha = fecha;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPonderado() {
        return ponderado;
    }

    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

}
