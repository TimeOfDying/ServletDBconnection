package com.server.db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "/servletdb2")
public class ServletDB2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name, pwd;
        name = request.getParameter("txtName");
        pwd = request.getParameter("txtPWD");
        Connection conn = null;

        PreparedStatement stmt = null;

        try
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\dtclass.db");
            String sql = "select * from tbl_Login where name=? and password=?";
            stmt = conn.prepareStatement(sql);		             
            stmt.setString(1, name);
            stmt.setString(2, pwd);
            
            if(rs.next())
            {
                response.sendRedirect("http://localhost:8080/welcome");
            }
            else
            {
                response.sendRedirect("http://localhost:8080/error");
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try
            {
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
