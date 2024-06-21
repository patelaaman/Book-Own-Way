package com.pak;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String address = request.getParameter("address");
        
        // JDBC connection variables
        String url = "jdbc:mysql://localhost:3306/Register";
        String user = "root";
        String dbPassword = "root";
        
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, dbPassword);
            
            // Create a PreparedStatement to insert user data into the database
            String query = "INSERT INTO student (name, email, pass, address) VALUES (?, ?, ?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,pass);
            preparedStatement.setString(4,address);
            
            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();
            
            if (rowsInserted > 0) {
                // Registration successful
                response.sendRedirect("login.jsp");
            } else {
                // Registration failed
                response.sendRedirect("error.jsp");
            }
            
            // Close resources
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("registration-failure.html");
        }
    }
}
