package com.server.db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/welcome")
public class welcome extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<DOCTYPE html>");
        out.println("<html>");
        out.println("<h1>Welcome to server</h1>");
        out.println("</html>");

        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\dtclass.db");
            String sql = "select name, password, email from tbl_Login";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            String str = "<table border=1><tr><th>Name</th><th>Password</th><th>Email</th></tr>";
            while(rs.next())
            {
                str += "<tr><td>"+rs.getString(1)+ "</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+ "</td></tr>";
            }
            str += "</table>";
            out.println(str);
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try
            {
                out.close();
                if(conn!=null)
                    conn.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
