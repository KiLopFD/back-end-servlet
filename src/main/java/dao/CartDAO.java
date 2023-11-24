package dao;

import entity.Cart;
import entity.Product;
import entity.User;
import jakarta.mail.Session;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transaction;

import java.util.List;
import java.util.Map;

public class CartDAO extends JpaDAO<Cart> implements GenericDAO<Cart> {

    public Cart create(Cart cart){

        return super.create(cart);
    }
     public Cart update(Cart cart){
        return super.update(cart);
     }
    @Override
    public Cart get(Object id) {
        return super.find(Cart.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Cart.class, id);
    }

    @Override
    public List<Cart> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }



//    public Cart getCart(int cartId) {
//        Session session = null;
//        Transaction transaction = null;
//        Cart cart = null;
//
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            cart = session.get(Cart.class, cartId);
//            // Bất kỳ thao tác nào khác cần thiết...
//
//            transaction.commit();
//        } catch (RuntimeException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw e;
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return cart;
//    }


}
