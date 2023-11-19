package dao;

import entity.Orderdetail;
import entity.Product;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderdetailDAOTest {
    private OrderdetailDAO orderdetailDAO;

    @BeforeEach
    void setUp()throws Exception{
        orderdetailDAO  = new OrderdetailDAO();
    }

    @AfterEach
    void tearDown() throws Exception {
        orderdetailDAO = null;
    }

//    @Test
//    void findPaidProductsByUser() {
//        User user = new UserDAO().get(2);
//        List<Product> listProducts = orderdetailDAO.findPaidProductsByUser(user);
//
//    }
}