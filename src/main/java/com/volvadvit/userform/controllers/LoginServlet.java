package com.volvadvit.userform.controllers;

import com.volvadvit.userform.dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String[] credentials = validateInputData(req);
            String[] fullname = userDao.loginUser(credentials);
            req.setAttribute("name", fullname[0] + " " + fullname[1]);
            req.setAttribute("confirm", "successfully");
        } catch (Exception e) {
            req.setAttribute("name", "");
            req.setAttribute("confirm", "not");
            System.err.println(e.getMessage());
        } finally {
            req.getRequestDispatcher("login_details.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Server at: ").append(req.getContextPath());
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    private String[] validateInputData(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && password != null)
        {
            return new String[]{username, password};
        }
        throw new RuntimeException("User data have NULL parameter. Request denied");
    }
}
