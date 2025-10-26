/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

/**
 *
 * @author LENOVO
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet(name="SvRegister", urlPatterns={"/SvRegister"})
public class SvRegister extends HttpServlet {
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=DBProyecto;encrypt=true;trustServerCertificate=true";
    private final String user = "EmmaCha";
    private final String password = "197600";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String sql = "INSERT INTO Usuarios (nombre, email, password) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, email);
                ps.setString(3, pass);
                ps.executeUpdate();
            }
            response.sendRedirect("index.jsp?msg=Usuario registrado");
        } catch (Exception e) {
            throw new ServletException("Error en registro", e);
        }
    }
}
