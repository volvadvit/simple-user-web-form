package com.volvadvit.registration.dao;

import com.volvadvit.registration.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDao {

    public int resisterUser(User user) throws ClassNotFoundException {
        String INSERT_USER_SQL = "INSERT INTO user " +
                "(id, first_name, last_name, username, password, address, contact) " +
                "VALUES (?,?,?,?,?,?,?);";
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false",
                    "test", "sXe--123");
            PreparedStatement statement = conn.prepareStatement(INSERT_USER_SQL);
            //TODO set autoincrement
            statement.setInt(1, 2);
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getContact());

            result = statement.executeUpdate();
        } catch (java.sql.SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }
}
