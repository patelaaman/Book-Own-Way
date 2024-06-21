package com.pak;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

@WebServlet("/Display")
public class Display extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // JDBC connection variables
        String url = "jdbc:mysql://localhost:3306/Register";
        String user = "root";
        String dbPassword = "root";
        
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, dbPassword);
            
            // Create a Statement to execute the select query
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            
            List<User> usersList = new ArrayList<>();
            while (resultSet.next()) {
                // Retrieve user data from the result set
                String  name = resultSet.getInt("name");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("pass");
                String address = resultSet.getString("address");
                // Add other fields as needed
                
                // Create a User object and add it to the list
                User student = new User(id, name, email); // Create a User class with appropriate fields
                usersList.add(user);
            }
            
            // Pass the users list to the JSP or other server-side scripting technology
            request.setAttribute("usersList", usersList);
            request.getRequestDispatcher("users.jsp").forward(request, response); // Forward to Users Listing JSP
            
            // Close resources
            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}

