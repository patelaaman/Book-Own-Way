package com.pak;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Scanner;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebServlet("/LoginServlet")
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public LoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		try {
//	  //  PrintWriter out = response.getWriter();
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
//		PreparedStatement ps = con.prepareStatement("INSERT INTO student (name ,pass) VALUES (?,?)");
//		System.out.println("Enter Name and Password");
//		Scanner sc = new Scanner(System.in);
//		String name = sc.next();
//		String pass = sc.next();
//		ps.setString(1,name);
//		ps.setString(2,pass);
//		
//		int i = ps.executeUpdate();
//		
//		if(i>0) {
//			response.sendRedirect("Swimming.html");
//			}
//		else {
//			response.sendRedirect("error.jsp");
//		}
//		
//	}catch(Exception e) {
//		System.out.println(e);
//	}
//}
//	}
//


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        
        // JDBC connection variables
        String url = "jdbc:mysql://localhost:3306/Register";
        String user = "root";
        String dbPassword = "root";
        
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, dbPassword);
            
            // Create a PreparedStatement to query the database for the user
            String query = "SELECT * FROM student WHERE name=? AND pass=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, pass);
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                // User authenticated
                response.sendRedirect("Success.jsp");
            } else {
                // Invalid credentials
                response.sendRedirect("error.jsp");
            }
            
            // Close resources
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login-failure.html");
        }
    }
}
