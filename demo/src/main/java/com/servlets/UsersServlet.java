package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.models.repository.UserReposity;
import com.models.schema.User;
import com.util.DataBaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        UserReposity rep = new UserReposity();
        try{ 
        rep.setConnection(DataBaseConnection.getConnection());
        List<User> users = rep.findAll();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
    }catch(SQLException e){
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Error</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Error</h1>");
        out.println("<p>");
        out.println(e.getMessage());
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");
    }

    }
}
