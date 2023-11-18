package dao;

import common.HashGenerator;
import entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private UserDAO userDAO;
    @BeforeEach
    void setUp() throws Exception{
        userDAO = new UserDAO();
    }
    @AfterEach
    void tearDown() throws Exception{
        userDAO = null;
    }

    @Test
    void create() throws ParseException, IOException {
        User user = new User();
        user.setUsername("Iggy");
        user.setPassword("1234");
        user.setEmail("sdfsd@gmail.com");
        user.setFullName("Nanunaka");
        user.setPhoneNumber("098678923");
        user.setRole("user");
        user.setAddress("dnvt");

        User createUser = userDAO.create(user);

        Assertions.assertEquals(user.getUsername(),createUser.getUsername());
    }

    @Test
    void update() {
       User user = userDAO.get(1);

       user.setAddress("Ha Noi");
       User updateUser = userDAO.update(user);
       Assertions.assertTrue(updateUser.getAddress().equals("Ha Noi"));

    }

    @Test
    void testGet() {
        User user = userDAO.get(1);
        System.out.println(user.getUsername());
        Assertions.assertNotNull(user);
    }

    @Test
    void testDelete() {
        int userId = 4;
        userDAO.delete(userId);
        User user = userDAO.get(userId);

        assertNull(user);
    }

    @Test
    void testListAll() {
        List<User> listUsers = userDAO.listAll();
        for(Iterator<User> iterator = listUsers.iterator(); iterator.hasNext();){
            User user = (User) iterator.next();
            System.err.println(user.getUsername() + "----" + user.getPassword());
        }
        assertFalse(listUsers.isEmpty());
    }

    @Test
    void testCount() {
        long totalUser = userDAO.count();

        assertEquals(1,totalUser);
    }

    @Test
    void checkLogin() {
        String userName = "Iggy";
        String password = "1234";
        boolean check = userDAO.checkLogin(userName,password);
        assertTrue(check);
    }

    @Test
    void findByUserName() {
        User user = userDAO.findByUserName("Iggy");
        System.out.println(user.getUsername());
        assertNotNull(user);

    }

    @Test
    void findByEmail() {
        User user = userDAO.findByEmail("gini@gmail.com");
        System.out.println(user.getUsername());
        assertNotNull(user);
    }
}