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
import java.util.ArrayList;
import java.util.List;

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
        Product product1 = new ProductDAO().get(3);
        cartService.addItem(user, product1);
    }

    @Test
    void updateItemQuantity() {
        User user = new UserDAO().get(1);
        Product product1 = new ProductDAO().get(1);
        int quantity = 4;
        cartService.updateItemQuantity(user, product1, quantity);
    }
    @Test
    void getItemQuantity() {
        User user = new UserDAO().get(1);
        Product product1 = new ProductDAO().get(1);
        System.out.println( cartService.getQuantityOfItem(user, product1) );
    }

    @Test
    void removeItem() {
        User user = new UserDAO().get(1);
        Product product1 = new ProductDAO().get(1);
        cartService.removeItem(user, product1);
    }

    @Test
    void removeItems() {
        User user = new UserDAO().get(1);
        Product product1 = new ProductDAO().get(1);
        cartService.removeItems(user, product1);
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
    void getTotalPriceOfItem()
    {
        User user = new UserDAO().get(1);
        Product product1 = new ProductDAO().get(1);
        BigDecimal totalAmount = cartService.getTotalPriceOfItem(user, product1);
        System.out.println(totalAmount);
    }

    @Test
    void clear() {
        User user = new UserDAO().get(1);
        cartService.clear(user);
    }
    @Test
    void CheckOut_all()
    {
        User user = new UserDAO().get(1);
        cartService.checkoutall(user);
    }

    @Test
    void CheckOut_idx()
    {
        User user = new UserDAO().get(1);
        List<Integer> idx = new ArrayList<Integer>();
        idx.add(0);
        idx.add(2);
        cartService.checkoutidx(user, idx);
    }
}