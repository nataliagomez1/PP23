package DAO;

import  modelo.Asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAO {
    // Crear una nueva asignatura
    public void agregarAsignatura(Asignatura asignatura) throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO asignaturas (nombre) VALUES (?)";

        try {
            conexion = ConexionDB.obtenerConexion();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, asignatura.getNombre());
            ps.executeUpdate();
        } finally {
            ConexionDB.cerrarConexion(conexion);
            if (ps != null) ps.close();
        }
    }

    public List<Asignatura> obtenerAsignaturas() throws Exception {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Asignatura> lista = new ArrayList<>();
        String sql = "SELECT * FROM asignaturas";
        //String sql = "SELECT 1";

        try {
            conexion = ConexionDB.obtenerConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Asignatura asignatura = new Asignatura();
                asignatura.setId(rs.getInt("id"));
                asignatura.setNombre(rs.getString("nombre"));
                lista.add(asignatura);
            }

        } finally {
            ConexionDB.cerrarConexion(conexion);
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }

        return lista;
    }

}
