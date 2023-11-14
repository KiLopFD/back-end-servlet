package dao;

import entity.Order;
import entity.Orderdetail;
import entity.Product;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    private static OrderDAO orderDAO;


    @BeforeEach
    void setUp() throws Exception {
        orderDAO = new OrderDAO();
    }

    @AfterEach
    void tearDown() {
        orderDAO.close();
    }

    @Test
    void create() {
        Order order = new Order();
        User user = new UserDAO().get(1);

        order.setInfoUser(user);

        Set<Orderdetail> orderdetails = new HashSet<>();
        Orderdetail orderdetail = new Orderdetail();

        Product product = new ProductDAO().get(2);
        orderdetail.setProductOfOrderDetail(product);
        orderdetail.setQuantity(1);
        orderdetail.setDetailTime( new Date());
        orderdetail.setTotalPrice(BigDecimal.valueOf(1000));
        orderdetails.add(orderdetail);

        order.setListOrderDetails(orderdetails);


        Order saveOrder = orderDAO.create(order);
        assertNotNull(saveOrder);


    }

    @Test
    void update() {
    }

    @Test
    void get() {

    }

    @Test
    void testGet() {
    }

    @Test
    void delete() {
    }

    @Test
    void listAll() {
    }

    @Test
    void count() {
    }
}