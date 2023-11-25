package controler;

import common.Utility;
import dao.ProductDAO;
import entity.Cart;
import entity.Product;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CartServices;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean authen = (Boolean) req.getSession().getAttribute("isLogin");
        String action = req.getParameter("actionCart");

        User user = (User) req.getSession().getAttribute("userAccount"); // after authen
        CartServices cartServices = new CartServices(); // cart service
        String domain = req.getContextPath();
        try {
            if (action != null){
                if (action.equals("checkOutAll")){
                    cartServices.checkoutall(user);
                }
                else if(action.equals("update")) {
                    Integer productId = Integer.parseInt(req.getParameter("pkProduct"));
                    ProductDAO productDAO = new ProductDAO();
                    Product product = productDAO.get(productId);
                    Integer quantity = Integer.parseInt(req.getParameter("quantity"));
                    if (product != null && quantity > 0)
                        cartServices.updateItemQuantity(user, product, quantity);
                }
            }

            // Update after checkout if no checkout render all exist cart
            List<Cart> carts = cartServices.listAllbyUser(user);
            Integer quantityCart = cartServices.getTotalQuantity(user);
            BigDecimal totalAmount = cartServices.getTotalAmount(user);
            req.setAttribute("totalAmount", totalAmount);
            req.getSession().setAttribute("quantityCart", quantityCart); // all pages track
            req.setAttribute("listCarts", carts); // only page cart show figures.
            // render page with req, resp corresponding.
            Utility.forwardToPage("./pages/cart.jsp", req, resp);
        }
        catch (Exception error) {
            resp.sendRedirect(domain + "/"); // Back to home if error.
        }

    }
}
