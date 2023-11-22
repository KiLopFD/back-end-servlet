package services;

import entity.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartService {
    private final Map<Product, Integer> cart = new HashMap<>();

    public void addItem(Product product) {
        if (cart.containsKey(product)) {
            Integer quantity = cart.get(product) + 1;
            cart.put(product, quantity);
        } else {
            cart.put(product, 1);
        }
    }

    public void removeItem(Product product) {
        cart.remove(product);
    }

    public int getTotalQuantityByLine(Product product) {
        return cart.get(product);
    }

    public BigDecimal getTotalByLineItem(Product product) {
        Integer quantity = cart.get(product);
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public int getTotalQuantity() {
        int total = 0;
        Iterator<Product> iterator = cart.keySet().iterator();

        while (iterator.hasNext()) {
            Product next = iterator.next();
            int quantity = getTotalQuantityByLine(next);
            total += quantity;
        }
        return total;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal total = BigDecimal.valueOf(0);
        Iterator<Product> iterator = cart.keySet().iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            BigDecimal subTotal = getTotalByLineItem(product);
            total = total.add(subTotal);
        }
        return total;

    }

    public void updateCart(int[] productId, int[] quantities) {
        for (int i = 0; i < productId.length; i++) {
            Product key = new Product(productId[i]);
            Integer value = quantities[i];
            cart.put(key, value);
        }
    }

    public void clear() {
        cart.clear();
    }

    public int getTotalItems() {
        return cart.size();
    }

    public Map<Product, Integer> getItems() {
        return this.cart;
    }
}
