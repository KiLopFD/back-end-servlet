package services;
import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import dao.OrderDAO;
import entity.Order;
import entity.Product;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceTest {
    private OrderService orderService;
    private ProductServices productServices;
    private UserService userService;


    @BeforeEach
    void setup() {
        orderService = new OrderService();
        productServices = new ProductServices();
        userService = new UserService();
    }

    @AfterEach
    void teardown() {
        orderService = null;
        productServices = null;
        userService = null;
    }

    @Test
    void Create()
    {
        User user = userService.listUser().get(0);
        List<Product> hoho = productServices.listAllProduct();
        List<Product> products = new ArrayList<Product>();
        products.add(hoho.get(0));
        orderService.addOrder(products, user);
    }

    @Test
    void Delete()
    {
        OrderDAO orderDAO = new OrderDAO();
        Order ord = orderDAO.get(8);
        orderService.delete(ord);
    }
    @Test
    void List_AllbyUser()
    {
        User user = userService.listUser().get(0);
        System.out.println(orderService.List_OrderbyUser(user));
    }

    @Test
    void Total_Price()
    {
        User user = userService.listUser().get(0);
        System.out.println(orderService.Total_Price(user));
    }

}
