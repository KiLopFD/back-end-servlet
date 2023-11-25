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
public class CartServices {
    private CartDAO cartDAO;
    private OrderServices orderService;

    /**
     * Handling all the cart function
     */
    public CartServices() {
        cartDAO = new CartDAO();
        orderService = new OrderServices();
    }

    /**
     *
     * @param user
     * @param prod
     * @return Create a new cart for a user
     * @Warning May create duplications cause a user can have multiple of carts contain the same product
     */
    public Cart createCart(User user, Product prod) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(prod);
        cart.setQuantity(1);
        return cartDAO.create(cart);
    }

    /**
     *
     * @param user
     * @param product
     * @Function Create a new cart for a user but into consideration of merging carts that have the same product
     */
    public void addItem(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            createCart(user, product);
        else {
            boolean found = false;
            for (Cart cart : res)
                if (cart.getProduct().equals(product)) {
                    cart.setQuantity(cart.getQuantity() + 1);
                    cartDAO.update(cart);
                    found = true;
                    return;
                }
            if(!found)
                createCart(user, product);
        }
    }

    /**
     *
     * @param user
     * @param product
     * @param quantity
     * @return update the quantity of products in the user cart
     */
    public boolean updateItemQuantity(User user, Product product, int quantity) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return false;
        else
            for (Cart cart: res)
                if(cart.getProduct().equals(product)) {
                    cart.setQuantity(quantity);
                    cartDAO.update(cart);
                    return true;
                }
        return false;
    }

    /**
     *
     * @param user
     * @return A list of carts from a specific user
     */
    public List<Cart> listAllbyUser(User user)
    {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        return res;
    }

    /**
     *
     * @param user
     * @return Delete a cart
     */
    public boolean removeItems(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return false;
        else
            for (Cart cart: res)
                if(cart.getProduct().equals(product)) {
                    cartDAO.delete(cart.getCartId());
                    return true;
                }
        return false;
    }

    /**
     *
     * @param user
     * @param product
     * @return Remove 1 item product from the cart
     */
    public boolean removeItem(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return false;
        else
            for (Cart cart: res)
                if(cart.getProduct().equals(product)) {
                    int quantity = cart.getQuantity();
                    if(quantity - 1 <= 0)
                        cartDAO.delete(cart.getCartId());
                    else
                    {
                        cart.setQuantity(quantity - 1);
                        cartDAO.update(cart);
                    }
                    return true;
                }
        return false;
    }

    /**
     *
     * @param user
     * @param product
     * @return Get a quantity of products from a cart
     */
    public int getQuantityOfItem(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return 0;
        else
            for (Cart cart: res)
                if(cart.getProduct().equals(product)) {
                    return cart.getQuantity();
                }
        return 0;
    }

    /**
     *
     * @param user
     * @param product
     * @return Get total price of item products in a cart
     */
    public BigDecimal getTotalPriceOfItem(User user, Product product) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        if(res.isEmpty())
            return new BigDecimal(0);
        else
            for (Cart cart: res)
                if(cart.getProduct().equals(product)) {
                    return product.getPrice().multiply( new BigDecimal(cart.getQuantity()) );
                }
        return new BigDecimal(0);
    }

    /**
     *
     * @param user
     * @return Get Total Quantity of all item products from a user carts
     */
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

    /**
     *
     * @param user
     * @return Get total_price that a user have to pay for all carts
     */
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
                total = sum.add(cart.getProduct().getPrice().multiply(BigDecimal.valueOf(cart.getQuantity())));
                sum = total;
            }
        return total;
    }

    /**
     *
     * @param user
     * @Function Clear all carts from a user
     */
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

    /**
     *
     * @param user
     * @Function Check Out feature, Create an order based on all carts that a user have
     */
    public void checkoutall(User user)
    {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        List<Product> prods = new ArrayList<Product>();
        if(res.isEmpty())
            return;
        else
            for (Cart cart: res) {
                int len = cart.getQuantity();
                for(int i =0 ; i < len; i++)
                    prods.add(cart.getProduct());
            }
            clear(user);
            orderService.addOrder(prods, user);
    }

    /**
     *
     * @param user
     * @param idx
     * @Function Check Out feature, Create an order based on idx of carts that a user have
     */
    public void checkoutidx(User user, List<Integer> idx)
    {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        List<Cart> res =  cartDAO.findWithNamedQuery("Cart.GetbyUser", parameter);
        List<Product> prods = new ArrayList<Product>();
        int count = 0;
        Map<Integer, Integer> check_idx = new HashMap<Integer, Integer>();
        for(int i: idx)
            check_idx.put(i, i);

        if(res.isEmpty())
            return;
        else
            for (Cart cart: res) {
                if(check_idx.containsKey(count)) {
                    int len = cart.getQuantity();
                    for (int i = 0; i < len; i++)
                        prods.add(cart.getProduct());
                    cartDAO.delete(cart.getCartId());
                }
                count += 1;
            }
        orderService.addOrder(prods, user);
    }

}
