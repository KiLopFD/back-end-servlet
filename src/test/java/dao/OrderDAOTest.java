package dao;

import com.oracle.wls.shaded.org.apache.bcel.generic.NEW;
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
import java.util.List;
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
        User user = new UserDAO().get(10);

        order.setInfoUser(user);

        Set<Orderdetail> orderdetails = new HashSet<>();
        Orderdetail orderdetail = new Orderdetail();

        Product product = new ProductDAO().get(4);
        orderdetail.setProductOfOrderDetail(product);
        orderdetail.setQuantity(2);
        orderdetail.setDetailTime( new Date());
        orderdetail.setTotalPrice(BigDecimal.valueOf(1000));
        orderdetails.add(orderdetail);

        order.setListOrderDetails(orderdetails);


        Order saveOrder = orderDAO.create(order);
        assertNotNull(saveOrder);


    }

    @Test
    void update() {
        Order order = orderDAO.get(18);
        order.setStatusPayment("paid");
        Order newOrder = orderDAO.update(order);
        assertEquals("paid",newOrder.getStatusPayment());
    }

    @Test
    void get() {

    }

    @Test
    void testGet() {
        orderDAO.delete(1);

    }

    @Test
    void delete() {

    }

    @Test
    void listAll() {
        List<Order> orderList = orderDAO.listAll();

        for(Order order : orderList){
            System.out.println(order.getOrderId());
        }
    }

    @Test
    void count() {
    }


}