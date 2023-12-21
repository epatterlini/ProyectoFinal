package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import util.ConexionDB;

public class UsuariosDAO {
    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuariosregistrados (Nombre, Apellido, NumCliente, FechaAlta) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getCliente());
            pstmt.setDate(4, usuario.getFechaAlta());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario obtenerPorId(int id) {
        String sql = "SELECT * FROM usuariosregistrados WHERE ID = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("ID"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setCliente(rs.getString("NumCliente"));
                usuario.setFechaAlta(rs.getDate("FechaAlta"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuario> obtenerTodos() {
        List<Usuario> oradores = new ArrayList<>();
        String sql = "SELECT * FROM usuariosregistrados";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("ID"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setCliente(rs.getString("NumCliente"));
                usuario.setFechaAlta(rs.getDate("FechaAlta"));
                oradores.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oradores;
    }

    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuariosregistrados SET Nombre = ?, Apellido = ?, NumCliente = ?, FechaAlta = ? WHERE ID = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getCliente());
            pstmt.setDate(4, usuario.getFechaAlta());
            pstmt.setInt(5, usuario.getIdUsuario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuariosregistrados WHERE ID = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
