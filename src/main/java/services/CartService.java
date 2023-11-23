package services;

import dao.CartDAO;
import entity.Cart;
import entity.Product;
import entity.User;

import java.math.BigDecimal;
import java.util.*;

public class CartService {
    private CartDAO cartDAO;

    public CartService() {
        cartDAO = new CartDAO();
    }

    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProducts(new HashSet<>()); // Khởi tạo với danh sách Product rỗng
        return cartDAO.create(cart);
    }

    public void addItem(Cart cart, Product product) {
        Map<Product, Integer> productQuantities = cart.getProductQuantities();

        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, productQuantities.get(product) + 1);
        } else {
            productQuantities.put(product, 1);
        }

        cart.setProductQuantities(productQuantities);
        cartDAO.update(cart);
    }

    //    Người dùng nhập số lượng
    public void updateItemQuantity(Cart cart, Product product, int quantity) {
        Map<Product, Integer> productQuantities = cart.getProductQuantities();
        if (quantity <= 0) {
            productQuantities.remove(product);
        } else {
            productQuantities.put(product, quantity);
        }

        cart.setProductQuantities(productQuantities);
        cartDAO.update(cart);
    }

    public void removeItem(Cart cart, Product product) {
        Map<Product, Integer> productQuantities = cart.getProductQuantities();
        productQuantities.remove(product);
        cart.setProductQuantities(productQuantities);
        cartDAO.update(cart);
    }
    public int getQuantityOfItem(Cart cart, Product product) {
        Map<Product, Integer> productQuantities = cart.getProductQuantities();
        return productQuantities.getOrDefault(product, 0); // Trả về số lượng của sản phẩm, hoặc 0 nếu không có sản phẩm trong giỏ hàng
    }
    public BigDecimal getTotalPriceOfItem(Cart cart, Product product) {
       int quantity = getQuantityOfItem(cart,product);
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }


    public int getTotalQuantity(Cart cart) {
        int totalQuantity = 0;
        Set<Product> products = cart.getProducts();

        for (Product product : products) {
            int quantity = getQuantityOfItem(cart, product);
            totalQuantity += quantity;
        }

        return totalQuantity;
    }


    public BigDecimal getTotalAmount(Cart cart) {
        BigDecimal total = BigDecimal.valueOf(0);
        Set<Product> productList = cart.getProducts();
        for (Product product : productList) {
            total = total.add(getTotalPriceOfItem(cart,product)); // Tính tổng giá tiền
        }
        return total;
    }
//Buggggg
//    public int getQuantityItemInCart(Cart cart) {
//        return cart.getProducts().size(); // Số lượng sản phẩm trong giỏ hàng
//    }
    public void clear(Cart cart) {
        // Xóa tất cả sản phẩm khỏi Set<Product>
        cart.setProducts(new HashSet<>());

        // Xóa tất cả các entry trong Map<Product, Integer>
        cart.setProductQuantities(new HashMap<>());

        // Cập nhật giỏ hàng trong cơ sở dữ liệu để phản ánh những thay đổi này
        cartDAO.update(cart);
    }


}
