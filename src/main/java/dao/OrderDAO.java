package dao;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import entity.Order;
import entity.Orderdetail;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.*;

public class OrderDAO extends JpaDAO<Order> implements GenericDAO<Order>{
    @Override
    public Order create(Order order){
       order.setOrderDate(new Date());
       order.setStatusPayment("Cash on Delivery");
       return super.create(order);
    }
    public boolean add_orderdet(int orderId, User userId, Orderdetail order){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("Order.findByIdAndUser");

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("orderId", orderId);
        parameters.put("userId", userId);

        Set<Map.Entry<String, Object>> setParameters = parameters.entrySet();

        for (Map.Entry<String, Object> entry : setParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        List<Order> result = query.getResultList();

        Order test = result.get(0);

        if (test == null) {
            entityManager.close();
            return false;
        }

        Set<Orderdetail> orders = test.getListOrderDetails();
        orders.add(order);
        test.setListOrderDetails(orders);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
    public boolean del_orderdet(int orderId, User userId, int index)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("Order.findByIdAndUser");

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("orderId", orderId);
        parameters.put("userId", userId);

        Set<Map.Entry<String, Object>> setParameters = parameters.entrySet();

        for (Map.Entry<String, Object> entry : setParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        List<Order> result = query.getResultList();

        Order test = result.get(0);
        if (test == null)
            return false;

        Set<Orderdetail> orders = test.getListOrderDetails();
        int count = 0;
        Orderdetail order = new Orderdetail();
        for(Orderdetail det: orders)
        {
            if (count == index)
                order = det;
            else
                count += 1;
        }
        if(order.getProductOfOrderDetail() != null) {
            OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
            orderdetailDAO.delete(order.getOrder_detail_id());
//            orders.remove(order);
//            test.setListOrderDetails(orders);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    public Set<Orderdetail> ListAllOrderDetails(int orderID)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("Order.findById");

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("orderId", orderID);

        Set<Map.Entry<String, Object>> setParameters = parameters.entrySet();

        for (Map.Entry<String, Object> entry : setParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        List<Order> result = query.getResultList();

        Order test = result.get(0);

        if (test == null) {
            entityManager.close();
        }

        Set<Orderdetail> orders = test.getListOrderDetails();
        return orders;
    }

    public List<Order> listAllByUser(User userId) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        return super.findWithNamedQuery("Order.findByUser", parameters);
    }

    public List<Order> listAllByOrdID(int orderID) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("orderId", orderID);
        return super.findWithNamedQuery("Order.findById", parameters);
    }

    @Override
    public Order update(Order order){
        return super.update(order);
    }
    @Override
    public Order get(Object id) {
        return super.find(Order.class, id);
    }

    public Order get(int orderId, User userId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("orderId", orderId);
        parameters.put("userId", userId);
        List<Order> result = super.findWithNamedQuery("Order.findByIdAndUser",parameters);

        if(!result.isEmpty()){
            return result.get(0);
        }
        return null;
    }
    @Override
    public void delete(Object id) {
        super.delete(Order.class, id);
    }

    @Override
    public List<Order> listAll() {
        return super.findWithNamedQuery("Order.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Order.countAll");
    }
}
