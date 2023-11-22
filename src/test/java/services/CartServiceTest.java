package services;

import dao.ProductDAO;
import entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {
    private static CartService cart;
    @BeforeEach
    void setUp() {
        cart = new CartService();

    }

    @AfterEach
    void tearDown() {
        cart = null;
    }
    @Test
    void addCart() {
        Product product = new Product();
        product.setProductId(2);

        cart.addItem(product);
        cart.addItem(product);
        Map<Product, Integer> items = cart.getItems();
        Integer quantity = items.get(product);

        System.out.println(quantity);



    }
    @Test
    void removeItem(){
        Product product = new Product();
        product.setProductId(1);
        cart.addItem(product);
        cart.addItem(product);
        Map<Product, Integer> items = cart.getItems();
        System.out.println(items.get(product));
        cart.removeItem(product);
        Integer quantity = items.get(product);
        System.out.println(quantity);


    }


    @Test
    void getTotalQuantity() {
      Product product1 = new Product(1);
      Product product2 = new Product(2);
      Product product3 = new Product(3);
      Product product4 = new Product(4);

      cart.addItem(product1);
      cart.addItem(product1);
      cart.addItem(product1);
      cart.addItem(product2);
      cart.addItem(product2);
      cart.addItem(product3);
      cart.addItem(product4);
      int quantities = cart.getTotalQuantity();

      System.out.println("Số lương: " +quantities);


    }

    @Test
    void getTotalAmount() {
        Product product1 = new ProductDAO().get(1);
        Product product3 = new ProductDAO().get(3);
        Product product4 = new ProductDAO().get(4);
        Product product5 = new ProductDAO().get(5);

        cart.addItem(product1);
        cart.addItem(product1);
        cart.addItem(product1);
        cart.addItem(product1);
        cart.addItem(product3);
        BigDecimal subAmount = cart.getTotalAmount();
        System.out.println(subAmount);


    }

    @Test
    void updateCart() {
    }

    @Test
    void clear() {
    }

    @Test
    void getTotalItems() {
    }
}