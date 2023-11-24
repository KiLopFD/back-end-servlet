package services;

import dao.JpaDAO;
import dao.OrderDAO;
import dao.OrderdetailDAO;
import dao.ProductDAO;
import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.Console;
import java.math.BigDecimal;
import java.util.*;

/**
 * Handling all the order function
 */
public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
    private ProductDAO productDAO = new ProductDAO();

    /**
     *
     * @param products
     * @param user
     * @Function Create an order based on a list of prods and a specific user
     */
    public void addOrder(List<Product> products, User user) {
        Map<Product, Integer> prods = new HashMap<Product, Integer>();
        for(Product prod : products)
        {
            if(prods.containsKey(prod))
            {
                Integer quantity = prods.get(prod);
                prods.put(prod, quantity + 1);
            }
            else
                prods.put(prod, 1);
        }

        Set<Orderdetail> orderdetails = new HashSet<Orderdetail>();
        Order ord =  new Order();
        ord.setInfoUser(user);
        orderDAO.create(ord);

        for( Map.Entry<Product, Integer> ent: prods.entrySet() )
        {
            Orderdetail orderdetail = new Orderdetail();
            orderdetail.setProductOfOrderDetail(ent.getKey());
            orderdetail.setQuantity(ent.getValue());
            orderdetail.setTotalPrice();
            orderdetail.setDetailTime(new Date());
            orderdetail.setOrder(ord);
            orderdetailDAO.create(orderdetail);
            orderdetails.add(orderdetail);
        }
        ord.setListOrderDetails(orderdetails);
        orderDAO.update(ord);
    }

    /**
     *
     * @return A list of all orders
     */
    public List<Order> List_Order()
    {
        return orderDAO.listAll();
    }

    /**
     *
     * @param user
     * @return A list of all orders from a user
     */
    public List<Order> List_OrderbyUser(User user)
    {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Order> res =  orderDAO.findWithNamedQuery("Order.findBydUser", parameter);
        return res;
    }

    /**
     *
     * @param order
     * @return Total price of a specific order
     */
    public BigDecimal Total_PriceOrder(Order order)
    {
        BigDecimal sum = BigDecimal.valueOf(0);
        BigDecimal total = BigDecimal.valueOf(0);
        Set<Orderdetail> orderdetails = order.getListOrderDetails();
        for(Orderdetail detail: orderdetails) {
            total = sum.add(detail.getTotalPrice());
            sum = total;
        }
        return total;
    }

    /**
     *
     * @param user
     * @return Total price of all orders from a user
     */
    public BigDecimal Total_Price(User user)
    {
        List<Order> result = orderDAO.listAll();

        List<Order> ords = result;
        BigDecimal sum = BigDecimal.valueOf(0);
        BigDecimal total = BigDecimal.valueOf(0);
        for(Order ord: ords)
            if(ord.getStatusPayment().equals("Pending"))
                if(ord.getInfoUser().getUserId() == user.getUserId())
                {
                    Set<Orderdetail> orderdetails = ord.getListOrderDetails();
                    for(Orderdetail detail: orderdetails) {
                        total = sum.add(detail.getTotalPrice());
                        sum = total;
                    }
                }
        orderDAO.close();
        return total;
    }

    /**
     *
     * @param order
     * @Function delete an order that is not pending
     */
    public void delete(Order order)
    {
        if(order.getStatusPayment().equals("Pending"))
        {
            Set<Orderdetail> orderdetails = order.getListOrderDetails();
            if(!orderdetails.isEmpty())
                for(Orderdetail detail: orderdetails)
                    orderdetailDAO.delete(detail.getOrder_detail_id());
            orderDAO.delete(order.getOrderId());
        }
        else
            System.out.println("Cannot delete!!");
    }
}
