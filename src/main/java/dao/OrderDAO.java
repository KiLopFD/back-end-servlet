package dao;

import entity.Order;
import entity.Product;
import entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAO extends JpaDAO<Order> implements GenericDAO<Order>{
    @Override
    public Order create(Order order){
       order.setOrderDate(new Date());
       order.setStatusPayment("Pending");
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


    public Order get(int orderId, int userId){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("orderId", orderId);
        parameters.put("userId",userId);
        List<Order> result = super.findWithNamedQuery("Order.findByIdAndUser",parameters);

        if(!result.isEmpty()){
            return result.get(0);
        }
        return null;
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
