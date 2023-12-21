/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import dao.UsuariosDAO;
import modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/registroUsuarios")
public class RegistroUsuarios extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String NumCliente = request.getParameter("tema");

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCliente(NumCliente);

        java.util.Date fechaActual = new java.util.Date();
        usuario.setFechaAlta(new Date(fechaActual.getTime()));

        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.agregarUsuario(usuario);

        response.sendRedirect(request.getContextPath() + "/vistas/verUsuarios.jsp");
    }
}
