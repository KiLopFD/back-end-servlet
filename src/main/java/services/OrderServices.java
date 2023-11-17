package services;
import dao.CategoryDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OrderServices {
    private OrderDAO orderDAO = new OrderDAO();

    public boolean AddOrder(User user)
    {
        Order order = new Order();
        order.setInfoUser(user);
        Order test = orderDAO.create(order);
        if(test == null)
            return false;
        return true;
    }

    public boolean DelOrder(int id)
    {
        try {
            orderDAO.delete(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<Order> ListAll()
    {
        List<Order> ord = orderDAO.listAll();
        return ord;
    }

    public List<Order> ListAllByUser(User user)
    {
        List<Order> ord = orderDAO.listAllByUser(user);
        return ord;
    }

    public Set<Orderdetail> ListAllOrderDetails(int orderId)
    {
        return orderDAO.ListAllOrderDetails(orderId);
    }

    public boolean AddOrderDet(int orderId, User userId, Orderdetail order)
    {
        Boolean test = orderDAO.add_orderdet(orderId, userId, order);
        if(test)
            return true;
        return false;
    }

    public boolean RemOrderDet(int orderId, User userId, int index)
    {
        Boolean test = orderDAO.del_orderdet(orderId, userId, index);
        if(test)
            return true;
        return false;
    }

    public Order find(int id)
    {
        return orderDAO.get(id);
    }

}
