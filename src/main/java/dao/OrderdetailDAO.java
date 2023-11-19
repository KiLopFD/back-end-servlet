package dao;

import entity.Orderdetail;
import entity.Product;
import entity.User;

import java.util.List;

public class OrderdetailDAO extends JpaDAO<Orderdetail> implements GenericDAO<Orderdetail> {
    @Override
    public Orderdetail get(Object id) {
        return super.find(Orderdetail.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Orderdetail.class, id);

    }


    @Override
    public List<Orderdetail> listAll() {
        return super.findWithNamedQuery("Orderdetail.findAll");
    }
//    public List<Product> findPaidProductsByUser(User user){
//        return super.findWithNamedQuery("Orderdetail.findPaidProductsByUser", "user", user);
//    }



    @Override
    public long count() {
        return super.countWithNamedQuery("Orderdetail.countAll");
    }
}
