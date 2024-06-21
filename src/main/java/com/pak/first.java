package com.pak;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class first {
  public static void main(String args[]) throws Exception{
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root","root");
	  String sql = "INSERT INTO stu (name , email ,pass) VALUES (?,?,?)";
	 PreparedStatement ps= con.prepareStatement(sql);
      System.out.println("Enter name ,email,pass : ");
	 Scanner sc = new Scanner(System.in);
	  String name = sc.next();
	   String email = sc.next();
	   String pass = sc.next();
	   
	   ps.setString(1, name);
	   ps.setString(2,email);
	   ps.setString(3, pass);
	 int i=ps.executeUpdate();
	 if(i>0) {
		 response.sendRedirect("Swimming.html");
	 }
	 else
	 {
		 System.out.println("Fail");
	 }
	con.close();
  }
}
//*/




//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.Scanner;
//import java.sql.*;
//
//public class first {
//  public static void main(String args[]) throws ClassNotFoundException ,SQLException{
//	  Class.forName("com.mysql.cj.jdbc.Driver");
//	  
//	  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Register", "root","root");
//	  Statement st =  con.createStatement();
//	  String sql = "select * from student";
//	  ResultSet rs = st.executeQuery(sql); 
//	  while(rs.next()) {
//     	 System.out.println("Name : \t"+rs.getString(1)+"\temail : \t"+rs.getString(2)
//     	 +"\tpassword : \t"+rs.getString(3)+" \tAddress : \t"+rs.getString(4));
//      }
//	con.close();
//  }
//}


//RegistrationServlet.java
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/first")
public class first extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     // Connect to MySQL database
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;

     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Register", "root", "root");
         stmt = conn.createStatement();
         rs = stmt.executeQuery("SELECT name, email, pass, address FROM student");

         request.setAttribute("registrationData", rs); // Set registration data as an attribute
         RequestDispatcher dispatcher = request.getRequestDispatcher("regis.jsp");
         dispatcher.forward(request, response);
     } catch (SQLException | ClassNotFoundException e) {
         e.printStackTrace(); // Handle exceptions properly in a real application
     } finally {
         // Close resources
         try {
             if (rs != null) rs.close();
             if (stmt != null) stmt.close();
             if (conn != null) conn.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }
}






