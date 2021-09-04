package com.volvadvit.userform.dao;

import com.volvadvit.userform.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    private final String jdbcDriver = "com.mysql.jdbc.Driver";
    private final String mysqlDatabase = "jdbc:mysql://localhost:3306/users?useSSL=false";
    private final String username = "test";
    private final String password = "sXe--123";

    public int resisterUser(User user) throws ClassNotFoundException {
        String INSERT_USER_SQL = "INSERT INTO user " +
                "(first_name, last_name, username, password, address, contact) " +
                "VALUES (?,?,?,?,?,?);"; // ? - placeholder
        int result = 0;

        Class.forName(jdbcDriver);
        try {
            Connection conn = DriverManager.getConnection(mysqlDatabase,username, password);
            PreparedStatement statement = conn.prepareStatement(INSERT_USER_SQL);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getContact());

            result = statement.executeUpdate();
        } catch (java.sql.SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    public String[] loginUser(String[] credentials) throws ClassNotFoundException {
        String SELECT_USER_SQL = "SELECT first_name, last_name FROM user " +
                "WHERE username=? AND password=?;";
        String[] result = new String[2];

        Class.forName(jdbcDriver);
        try {
            Connection conn = DriverManager.getConnection(mysqlDatabase, username, password);
            PreparedStatement statement = conn.prepareStatement(SELECT_USER_SQL);
            statement.setString(1, credentials[0]);
            statement.setString(2, credentials[1]);
            ResultSet rs = statement.executeQuery();
            rs.next();
            result[0] = rs.getString("first_name");
            result[1] = rs.getString("last_name");
        } catch (java.sql.SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }
}
