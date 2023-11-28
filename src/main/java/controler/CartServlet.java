package controler;

import common.Utility;
import dao.CartDAO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domain = req.getContextPath();

        Boolean authen = (Boolean) req.getSession().getAttribute("isLogin");
        String action = req.getParameter("actionCart");

        User user = (User) req.getSession().getAttribute("userAccount"); // after authen
        CartServices cartServices = new CartServices(); // cart service
        try {
            if (action != null){
                if (action.equals("checkOutAll")){
                    BigDecimal myWallet = new BigDecimal(String.valueOf(req.getSession().getAttribute("money")));
                    if (cartServices.getTotalAmount(user).compareTo(myWallet) == -1) {
                        req.getSession().setAttribute("money", myWallet.subtract(cartServices.getTotalAmount(user)));
                        cartServices.checkoutall(user, "paid");
                    }
                    else {
                        cartServices.checkoutall(user, "pending");
                    }
                    resp.sendRedirect(domain+"/cart");
                    return;
                }
                else if(action.equals("update")) {
                    Integer productId = Integer.parseInt(req.getParameter("pkProduct"));
                    ProductDAO productDAO = new ProductDAO();
                    Product product = productDAO.get(productId);
                    Integer quantity = Integer.parseInt(req.getParameter("quantity"));
                    if (product != null && quantity > 0)
                        cartServices.updateItemQuantity(user, product, quantity);
                    resp.sendRedirect(domain+"/cart");
                    return;
                }
                else if (action.equals("remove")) {
                    Integer productId = Integer.parseInt(req.getParameter("pkProduct"));
                    ProductDAO productDAO = new ProductDAO();
                    Product product = productDAO.get(productId);
                    cartServices.removeItem(user, product);
                    resp.sendRedirect(domain+"/cart");
                    return;
                }
                else if (action.equals("checkOutIdx")) {
                    System.out.println(req.getParameter("Idx"));
                    String checkExist = req.getParameter("Idx");
                    if (checkExist != null && checkExist != "None") {
                        String[] idxes = (req.getParameter("Idx").split("-"));
                        List<Integer> listIdx = new ArrayList<Integer>();
                        List<BigDecimal> priceItems = new ArrayList<BigDecimal>();
                        CartDAO cartDAO = new CartDAO();
                        for (String idx: idxes) {
                            priceItems.add(cartServices.getTotalPriceOfItem(user, cartDAO.get(Integer.valueOf(idx)).getProduct()));
                            listIdx.add(Integer.valueOf(idx));
                        }
                        System.out.println(listIdx);
                        BigDecimal totalPriceIdx = BigDecimal.valueOf(0);
                        BigDecimal tmp = BigDecimal.valueOf(0);
                        for (BigDecimal price : priceItems) {
                            totalPriceIdx = tmp.add(price);
                            tmp = totalPriceIdx;
                        }
                        BigDecimal myWallet = new BigDecimal(String.valueOf(req.getSession().getAttribute("money")));
                        if (totalPriceIdx.compareTo(myWallet) == -1) {
                            req.getSession().setAttribute("money", myWallet.subtract(totalPriceIdx));
                            cartServices.checkoutidx(user, listIdx,"paid");
                        }
                        else {
                            cartServices.checkoutidx(user, listIdx,"pending");
                        }
                        resp.sendRedirect(domain+"/cart");
                        return;
                    }
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
            System.out.println(error);
            resp.sendRedirect(domain + "/"); // Back to home if error.
        }

    }
}
