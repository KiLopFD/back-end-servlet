package dao;

import entity.Cart;
import entity.Product;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartDAOTest {
    private static CartDAO cartDAO;

    @BeforeEach
    void setUp() {
        cartDAO = new CartDAO();
    }

    @AfterEach
    void tearDown() {
        cartDAO = null;
    }

    @Test
    void createEmptyCart() {
//        User user = new UserDAO().get(3);
//        Cart cart = cartDAO.create(user);
//        assertNotNull();

    }

    @Test
    void createCart() {
    }
}