package services;

import dao.CartDAO;
import entity.Cart;
import entity.Product;
import entity.User;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 */
public class CartService {
    private CartDAO cartDAO;

    public CartService() {
        cartDAO = new CartDAO();
    }

    public Cart createCart(User user, Product prod) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProducts(prod);
        cart.setQuantity(1);
        return cartDAO.create(cart);
    }

    public void addItem(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            createCart(user, product);
        else {
            boolean found = false;
            for (Cart cart : res)
                if (cart.getProducts().equals(product)) {
                    cart.setQuantity(cart.getQuantity() + 1);
                    cartDAO.update(cart);
                    found = true;
                    return;
                }
            if(!found)
                createCart(user, product);
        }
    }

    public boolean updateItemQuantity(User user, Product product, int quantity) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return false;
        else
            for (Cart cart: res)
                if(cart.getProducts().equals(product)) {
                    cart.setQuantity(quantity);
                    cartDAO.update(cart);
                    return true;
                }
        return false;
    }

    public boolean removeItem(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return false;
        else
            for (Cart cart: res)
                if(cart.getProducts().equals(product)) {
                    cartDAO.delete(cart.getCartId());
                    return true;
                }
        return false;
    }
    public int getQuantityOfItem(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return 0;
        else
            for (Cart cart: res)
                if(cart.getProducts().equals(product)) {
                    return cart.getQuantity();
                }
        return 0;
    }
    public BigDecimal getTotalPriceOfItem(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return new BigDecimal(0);
        else
            for (Cart cart: res)
                if(cart.getProducts().equals(product)) {
                    return product.getPrice().multiply( new BigDecimal(cart.getQuantity()) );
                }
        return new BigDecimal(0);
    }


    public int getTotalQuantity(User user) {
        int totalQuantity = 0;
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return 0;
        else
            for (Cart cart: res)
                totalQuantity += cart.getQuantity();
        return totalQuantity;
    }


    public BigDecimal getTotalAmount(User user) {
        BigDecimal total = BigDecimal.valueOf(0);
        BigDecimal sum = BigDecimal.valueOf(0);
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return new BigDecimal(0);
        else
            for (Cart cart: res)
            {
                total = sum.add(cart.getProducts().getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())));
                sum = total;
            }
        return total;
    }

    public void clear(User user) {
        BigDecimal total = BigDecimal.valueOf(0);
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return;
        else
            for (Cart cart: res)
                cartDAO.delete(cart.getCartId());
    }


}
