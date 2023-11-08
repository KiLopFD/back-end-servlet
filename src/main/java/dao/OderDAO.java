package dao;

import entity.Order;

import java.util.List;

public class OderDAO extends JpaDAO<Order> implements GenericDAO<Order>{
    @Override
    public Order get(Object id) {
        return super.find(Order.class, id);
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
