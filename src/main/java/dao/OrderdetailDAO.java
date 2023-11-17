package dao;

import entity.Orderdetail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderdetailDAO extends JpaDAO<Orderdetail> implements GenericDAO<Orderdetail> {
    @Override
    public Orderdetail get(Object id) {
        return super.find(Orderdetail.class, id);
    }

    @Override
    public  Orderdetail create(Orderdetail ordetail){ return super.create(ordetail); }

    @Override
    public void delete(Object id) {
        super.delete(Orderdetail.class, id);
    }

    @Override
    public List<Orderdetail> listAll() {
        return super.findWithNamedQuery("Orderdetail.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Orderdetail.countAll");
    }
}
