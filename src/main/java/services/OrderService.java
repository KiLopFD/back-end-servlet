package services;

import dao.OrderDAO;
import dao.OrderdetailDAO;
import dao.ProductDAO;
import entity.Order;
import entity.Orderdetail;
import entity.Product;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.Console;
import java.math.BigDecimal;
import java.util.*;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
    private ProductDAO productDAO = new ProductDAO();

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

    public List<Order> List_Order()
    {
        return orderDAO.listAll();
    }

    public BigDecimal Total_Price(User user)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("StorePhone");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNamedQuery("Order.findAll");
        List<Order> result = query.getResultList();

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

        entityManager.getTransaction().commit();
        entityManager.close();
        return total;
    }

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
