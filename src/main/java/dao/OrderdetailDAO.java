package dao;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import entity.Order;
import entity.Orderdetail;
import entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderdetailDAO extends JpaDAO<Orderdetail> implements GenericDAO<Orderdetail> {

    public Orderdetail get(Object id) {
        return super.find(Orderdetail.class, id);
    }

    @Override
    public Orderdetail create(Orderdetail ordetail){ return super.create(ordetail); }


    public void delete(Object id) {
        super.delete(Orderdetail.class, id);
    }


    public List<Orderdetail> listAll() {
        return super.findWithNamedQuery("Orderdetail.findAll");
    }


    public long count() {
        return super.countWithNamedQuery("Orderdetail.countAll");
    }
}
