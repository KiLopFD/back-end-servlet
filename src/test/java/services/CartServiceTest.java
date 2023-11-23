package services;

import dao.CartDAO;
import dao.ProductDAO;
import dao.UserDAO;
import entity.Cart;
import entity.Product;
import entity.User;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {

    private CartService cartService ;
    @BeforeEach
    void setUp() {
        cartService = new CartService();
    }

    @AfterEach
    void tearDown() {
        cartService = null;
    }

    @Test
    void createCart() {
        User user = new UserDAO().get(2);
        Product prod = new ProductDAO().get(2);
        Cart newCart = cartService.createCart(user, prod);
        assertNotNull(newCart);
    }

    @Test
    void addItem() {
        User user = new UserDAO().get(1);
        Product product1 = new ProductDAO().get(1);
        cartService.addItem(user, product1);
    }

    @Test
    void updateItemQuantity() {
    }

    @Test
    void removeItem() {
        User user = new UserDAO().get(1);
        Product product1 = new ProductDAO().get(1);
        cartService.removeItem(user, product1);
    }

    @Test
    void getTotalQuantity() {
        User user = new UserDAO().get(1);
        int totalQuantity = cartService.getTotalQuantity(user);
        System.out.println(totalQuantity);
//        assertEquals(25,totalQuantity);
    }

    @Test
    void getTotalAmount() {
        User user = new UserDAO().get(1);
        BigDecimal totalAmount = cartService.getTotalAmount(user);
        System.out.println(totalAmount);
    }

    @Test
    void getQuantityCart() {
    }

    @Test
    void clear() {
        User user = new UserDAO().get(1);
        cartService.clear(user);
    }
}