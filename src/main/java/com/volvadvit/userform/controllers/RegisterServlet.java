package com.volvadvit.userform.controllers;

import com.volvadvit.userform.dao.UserDao;
import com.volvadvit.userform.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = validateInputData(req);
            userDao.resisterUser(user);
            req.setAttribute("name", user.getUsername());
            req.setAttribute("confirm", "successfully");
        } catch (Exception e) {
            req.setAttribute("name", "");
            req.setAttribute("confirm", "not");
            System.err.println(e.getMessage());
        } finally {
            req.getRequestDispatcher("register_details.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Server at: ").append(req.getContextPath());
        req.getRequestDispatcher("Registration.jsp").forward(req, resp);
    }

    private User validateInputData(HttpServletRequest req) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");

        if (firstName != null && lastName != null
                && username != null && password != null
                && address != null && contact != null)
        {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setPassword(password);
            user.setAddress(address);
            user.setContact(contact);
            return user;
        }
        throw new RuntimeException("User data have NULL parameter. Request denied");
    }
}
