package com.pak;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Scanner;
public class RegisterServlet1{
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		 Class.forName("com.mysql.jdbc.Driver"); // Load MySQL JDBC Driver
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "root");
         String sql = "INSERT INTO student (lname, lpass) VALUES (?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         System.out.println("Enter username  and Password");
         Scanner sc = new Scanner(System.in);
          String un = sc.next();
          String pa = sc.next();
         ps.setString(1, un);
         ps.setString(2, pa);
         int i = ps.executeUpdate();
         if(i>0)
         {
        	 System.out.println("Data Inserted");
         }
		conn.close();
	}
}