package com.pak;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/Restaurent")
public class Restaurent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String numberOfGuests = request.getParameter("numberOfGuests");
        String purpose = request.getParameter("purpose");
        
        // JDBC connection variables
        String url = "jdbc:mysql://localhost:3306/Restaurent2";
        String user = "root";
        String password = "root";
        
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Create a PreparedStatement to insert booking data into the database
            String query = "INSERT INTO booking (name, email, phoneNumber, numberOfGuests, purpose) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, numberOfGuests);
            preparedStatement.setString(5, purpose);
            
            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();
            
            if (rowsInserted > 0) {
                // Booking successful
                response.sendRedirect("Success.jsp");
            } else {
                // Booking failed
                response.sendRedirect("error.jsp");
            }
            
            // Close resources
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("booking-failure.html");
        }
    }
}

