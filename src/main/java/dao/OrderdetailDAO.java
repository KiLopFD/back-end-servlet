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

    public  boolean  hasUserPurchasedProduct(User user,Product product){
        List<Orderdetail> result = findWithNamedQuery(
                "Orderdetail.hasUserPurchasedProduct",
                new String[]{"user", "product"},
                new Object[]{user, product}
        );
        return !result.isEmpty();
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
