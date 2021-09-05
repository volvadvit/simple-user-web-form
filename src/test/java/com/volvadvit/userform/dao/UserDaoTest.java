package com.volvadvit.userform.dao;

import com.volvadvit.userform.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void loginUserTest() throws Exception{
        UserDao dao = new UserDao();
        String[] credentials = new String[]{"vadim", "1111"};
        String[] result = dao.loginUser(credentials);
        assertEquals("Vadim", result[0]);
    }

    @Test
    void registerUserTest() throws Exception {
        User user = new User("aaa", "bbb", "ccc",
                "ddd", "eee", "fff" + (int) (Math.random()*10));
        UserDao dao = new UserDao();
        int result = dao.resisterUser(user);
        assertEquals(1, result);
    }
}