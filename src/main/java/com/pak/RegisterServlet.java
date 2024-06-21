import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Scanner;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Insert the user into the database
        if (registerUser(username, password)) {
            // Registration successful
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/html");
            response.getWriter().write("Registration successful. <a href='login.jsp'>Click here to login</a>");
        } else {
            // Registration failed
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("text/html");
            response.getWriter().write("Registration failed");
        }
    }

    private boolean registerUser(String username, String password) {
        // Connect to MySQL database
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Load MySQL JDBC Driver
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println("Enter username  and Password");
            Scanner sc = new Scanner(System.in);
             String un = sc.next();
             String pa = sc.next();
            stmt.setString(1, un);
            stmt.setString(2, pa);
            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            conn.close();
            return rowsAffected == 1; // If one row is affected, the user is successfully registered
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
