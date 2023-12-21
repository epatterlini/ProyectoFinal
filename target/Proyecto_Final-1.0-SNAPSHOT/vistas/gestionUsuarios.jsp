<%-- 
    Document   : gestionUsuarios
    Created on : 19 dic. 2023, 15:44:15
    Author     : Dormitorio
--%>

<%@page import="dao.UsuariosDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Clientes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Gestión de Clientes</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Núm. Cliente</th>
                        <th>Fecha Alta</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        UsuariosDAO usuariosDAO = new UsuariosDAO();
                        List<Usuario> usuarios = usuariosDAO.obtenerTodos();

                        if (usuarios != null && !usuarios.isEmpty()) {
                            for (Usuario usuario : usuarios) {
                    %>
                    <tr>
                        <td><%= usuario.getIdUsuario()%></td>
                        <td><%= usuario.getNombre()%></td>
                        <td><%= usuario.getApellido()%></td>
                        <td><%= usuario.getCliente()%></td>
                        <td><%= usuario.getFechaAlta()%></td>
                        <td>
                            <div class="d-flex">
                                <!-- Formulario para actualizar -->
                                <form action="GestionOradorServlet" method="post" class="mr-2">
                                    <input type="hidden" name="accion" value="actualizar">
                                    <input type="hidden" name="id" value="<%= usuario.getIdUsuario()%>">
                                    <button type="submit" class="btn btn-warning btn-block">Actualizar</button>
                                </form>

                                <!-- Formulario para eliminar -->
                                <form action="GestionOradorServlet" method="post">
                                    <input type="hidden" name="accion" value="eliminar">
                                    <input type="hidden" name="id" value="<%= usuario.getIdUsuario()%>">
                                    <button type="submit" class="btn btn-danger btn-block">Eliminar</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="6">No hay clientes registrados.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>
