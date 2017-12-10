package com.server.db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletDB")
public class ServletDB extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<form action='http://localhost:8080/servletdb2'>");
        out.println("UserID: <input type='text' name='txtName'><br>");
        out.println("Password: <input type='password' name='txtPWD'><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</html>");


    }
}
