package dao;

import entity.Order;
import entity.Product;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Product> listAll() {
        return super.findWithNamedQuery("Product.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Product.countAll");
    }

    public Product findByName(String prodName) {
        Map<String, Object> map = new HashMap<String, Object>();
        prodName = "%" + prodName + "%";
        map.put("name", prodName);
        List<Product> result = super.findWithNamedQuery("Product.findByName", map);
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }
}
