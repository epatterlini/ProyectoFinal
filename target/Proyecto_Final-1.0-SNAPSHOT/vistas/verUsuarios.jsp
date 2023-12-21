<%@page import="dao.UsuariosDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Clientes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Lista de Clientes</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Num. Cliente</th>
                        <th>Fecha Alta</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Crear una instancia de OradoresDAO para acceder a la base de datos
                        UsuariosDAO usuariosDAO = new UsuariosDAO();

                        // Obtener la lista de oradores desde la base de datos
                        List<Usuario> usuarios = usuariosDAO.obtenerTodos();

                        if (usuarios != null && !usuarios.isEmpty()) {
                            // Iterar sobre la lista de oradores y mostrar sus datos en la tabla
                            for (Usuario usuario : usuarios) {
                    %>
                    <tr>
                        <td><%= usuario.getIdUsuario()%></td>
                        <td><%= usuario.getNombre()%></td>
                        <td><%= usuario.getApellido()%></td>
                        <td><%= usuario.getCliente()%></td>
                        <td><%= usuario.getFechaAlta()%></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5">No hay oradores registrados.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <!-- Botón para volver al índice -->
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>
