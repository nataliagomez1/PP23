package DAO;

import modelo.Actividad;
import modelo.TipoActividad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ActividadDAO {
    public void agregarActividad(Actividad actividad) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO actividades (nombre, tipo, ponderado, fecha, asignatura_id) VALUES (?, ?, ?, ?, ?)";

        try {
            java.util.Date utilDate = actividad.getFecha();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            conexion = ConexionDB.obtenerConexion();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, actividad.getNombre());
            ps.setString(2, actividad.getTipoActividad().name());
            ps.setDouble(3, actividad.getPonderado());
            ps.setDate(4, sqlDate);
            ps.setInt(5, actividad.getIdAsignatura());
            ps.executeUpdate();
        } finally {
            ConexionDB.cerrarConexion(conexion);
            if (ps != null) ps.close();
        }
    }

    // Obtener todas las actividades de una asignatura específica
    public List<Actividad> obtenerActividadesPorAsignatura(int asignaturaId) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Actividad> lista = new ArrayList<>();
        String sql = "SELECT * FROM actividades WHERE asignatura_id = ?";

        try {
            conexion = ConexionDB.obtenerConexion();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, asignaturaId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Actividad actividad = new Actividad();
                actividad.setId(rs.getInt("id"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setTipoActividad(TipoActividad.valueOf(rs.getString("tipo")));
                actividad.setPonderado(rs.getDouble("ponderado"));
                actividad.setFecha(rs.getDate("fecha"));
                actividad.setIdAsignatura(rs.getInt("asignatura_id"));
                lista.add(actividad);
            }

        } finally {
            ConexionDB.cerrarConexion(conexion);
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }

        return lista;
    }

}
