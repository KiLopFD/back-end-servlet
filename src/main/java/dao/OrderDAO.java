package dao;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import entity.Order;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAO extends JpaDAO<Order> implements GenericDAO<Order>{
    @Override
    public Order create(Order order){
       order.setOrderDate(new Date());
       order.setStatusPayment("Cash on Delivery");
       return super.create(order);
    }
    @Override
    public Order update(Order order){
        return super.update(order);
    }
    @Override
    public Order get(Object id) {
        return super.find(Order.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Order.class,id);
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