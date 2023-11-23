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
        User user = new UserDAO().get(21);
        Cart newCart = cartService.createCart(user);
        assertNotNull(newCart);
    }

    @Test
    void addItem() {
        Cart cart = new CartDAO().get(1);
        Product product1 = new ProductDAO().get(3);
        cartService.addItem(cart,product1);
        cartService.addItem(cart,product1);cartService.addItem(cart,product1);cartService.addItem(cart,product1);cartService.addItem(cart,product1);cartService.addItem(cart,product1);



//        assertEquals(2,quantity);
    }

    @Test
    void updateItemQuantity() {
    }

    @Test
    void removeItem() {
        Cart cart = new CartDAO().get(1);
        Product product1 = new ProductDAO().get(3);
        cartService.removeItem(cart,product1);
    }

    @Test
    void getTotalQuantity() {
        Cart cart = new CartDAO().get(1);
        int totalQuantity = cartService.getTotalQuantity(cart);
        System.out.println(totalQuantity);
        assertEquals(25,totalQuantity);
    }

    @Test
    void getTotalAmount() {
        Cart cart = new CartDAO().get(1);
        BigDecimal totalAmount = cartService.getTotalAmount(cart);
        System.out.println(totalAmount);
    }

    @Test
    void getQuantityCart() {
    }

    @Test
    void clear() {
        Cart cart = new CartDAO().get(1);
        cartService.clear(cart);
    }
}