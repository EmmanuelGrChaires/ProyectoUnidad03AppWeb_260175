/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

/**
 *
 * @author Emma
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet(name="SvLogin", urlPatterns={"/SvLogin"})
public class SvLogin extends HttpServlet {
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=DBProyecto;encrypt=true;trustServerCertificate=true";
    private final String user = "EmmaCha";
    private final String password = "197600";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String sql = "SELECT * FROM Usuarios WHERE email=? AND password=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("nombre", rs.getString("nombre"));
                    response.sendRedirect("secure/home.jsp");
                } else {
                    response.sendRedirect("index.jsp?error=Credenciales incorrectas");
                }
            }
        } catch (Exception e) {
            throw new ServletException("Error en login", e);
        }
    }
}
