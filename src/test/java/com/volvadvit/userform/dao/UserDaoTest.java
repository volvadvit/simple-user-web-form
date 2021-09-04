package com.volvadvit.userform.dao;

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
}