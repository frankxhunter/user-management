package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.models.repository.UserReposity;
import com.models.schema.User;
import com.util.DataBaseConnection;
import com.util.Validation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form-user")
public class FormUsersServler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get Parameters
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Validation
        Map<String, String> errors = new HashMap<>();
        if (!Validation.username(username)) {
            errors.put("username", "The username have a incorrect format");
        }
        if (!Validation.email(email)) {
            errors.put("email", "The email have a incorrect format");
        }
        if (!Validation.password(password)) {
            errors.put("password", "The password have a incorrect format");
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);

            // If no have errors, we save the data
        } else {
            UserReposity rp = new UserReposity();
            try (Connection con = DataBaseConnection.getConnection()) {
                rp.setConnection(con);
                User user = new User();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                rp.save(user);
                //getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/users");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
