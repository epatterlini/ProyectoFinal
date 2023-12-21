package controlador;

import dao.UsuariosDAO;
import modelo.Usuario;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/vistas/GestionOradorServlet")
public class GestionUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        int idUsuario = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "actualizar":
                Usuario usuario = usuariosDAO.obtenerPorId(idUsuario);
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "confirmarActualizacion":
                Usuario usuarioActualizado = new Usuario();
                usuarioActualizado.setIdUsuario(idUsuario);
                usuarioActualizado.setNombre(request.getParameter("nombre"));
                usuarioActualizado.setApellido(request.getParameter("apellido"));
                usuarioActualizado.setCliente(request.getParameter("NumCliente"));
                usuariosDAO.actualizarUsuario(usuarioActualizado);
                response.sendRedirect("gestionUsuarios.jsp");
                break;
            case "eliminar":
                usuariosDAO.eliminarUsuario(idUsuario);
                response.sendRedirect("gestionUsuarios.jsp");
                break;
            default:
                response.sendRedirect("gestionUsuarios.jsp");
                break;
        }
    }
}