package dao;

import entity.Product;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {
    private ProductDAO productDAO;

    @BeforeEach
    void setUp() {
        productDAO = new ProductDAO();
    }

    @AfterEach
    void tearDown() {
        productDAO = null;
    }

    @Test
    void findPaidProductsByUser() {
        User user = new UserDAO().get(10);
        List<Product> listProductByUser = productDAO.findPaidProductsByUser(user);
        for(Product product : listProductByUser){
            System.out.println(product.getProductId()+"---"+product.getProductName() +"---");
        }
        assertNotNull(listProductByUser);
    }

}