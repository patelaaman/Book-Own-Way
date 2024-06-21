package com.pak;

//Assuming you have a User class representing registration data

//RegistrationServlet.java
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.ResultSet;

@WebServlet("/RegistrationViewer")
public class RegistrationViewer extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException {
     // Connect to MySQL database
	  try {
          Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Register", "root", "root");
      Statement  st = conn.createStatement();
         String sql = "SELECT * FROM student";
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()) {
        	 System.out.println("Name"+rs.getString(1)+"email"+rs.getString(2)
        	 +"password"+rs.getString(3)+" Address"+rs.getString(4));
         }
         conn.close();
          
      } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace(); // Handle exceptions properly in a real application
      }
      }
	}

