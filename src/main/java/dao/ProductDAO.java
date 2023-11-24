package dao;

import entity.Order;
import entity.Product;
import entity.User;

import java.util.List;

public class ProductDAO extends JpaDAO<Product> implements GenericDAO<Product> {
    public ProductDAO() {

    }

    @Override
    public Product create(Product product) {
        return super.create(product);
    }

    @Override
    public Product update(Product product) {
        return super.update(product);
    }

    @Override
    public Product get(Object productId) {
        return super.find(Product.class, productId);
    }

    @Override
    public void delete(Object productId) {
        super.delete(Product.class, productId);
    }
    public List<Product> findPaidProductsByUser(User user){
        List<Product > listPaidProductsByUser = super.findWithNamedQuery("Product.findPaidProductsByUser","user",user);
        return listPaidProductsByUser;
    }

    @Override
    public List<Product> listAll() {
        return super.findWithNamedQuery("Product.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Product.countAll");
    }
}
