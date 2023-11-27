package controler;

import common.Utility;
import entity.Product;
import entity.Review;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CartServices;
import services.ReviewServices;

import java.io.IOException;
import java.util.List;

@WebServlet({"/detail-item"})
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Main domain of servlet app.
        String domain = req.getContextPath();
        Product product = (Product) req.getSession().getAttribute("detailItem");
        // after check authentication
        User user = (User) req.getSession().getAttribute("userAccount");
        // action of user
        String action = req.getParameter("action");
        CartServices cartServices = new CartServices();
        ReviewServices reviewServices = new ReviewServices();

        if (product != null){
            if (action!= null) {
                if (action.equals("addCart")) {
                    cartServices.addItem(user, product);
                    Integer quantityCart = cartServices.getTotalQuantity(user);
                    req.getSession().setAttribute("quantityCart", quantityCart);
                }
                else if(action.equals("buyNow")) {
                    Integer quantity = cartServices.getQuantityOfItem(user, product);
                    if (quantity==0) {
                        cartServices.addItem(user, product);
                    }
                    Integer quantityCart = cartServices.getTotalQuantity(user);
                    req.getSession().setAttribute("quantityCart", quantityCart);
                    resp.sendRedirect(domain+"/cart");
                    return;
                }
                else if(action.equals("review")) {
                    String comment = req.getParameter("comment").trim();
                    Integer rating = Integer.parseInt(req.getParameter("rating").trim());
                    if (reviewServices.createReview(user, product, comment, rating)) {
                        resp.sendRedirect(domain+"/detail-item");
                        return;
                    }
                }
            }
            List<Review> reviews = reviewServices.listAllReviewOfProduct(product);
            req.setAttribute("reviews", reviews);

            Utility.forwardToPage("./pages/detail.jsp", req, resp);
        }
        else {
            // Back to home if not exist product detail
            resp.sendRedirect(domain + "/");
        }
    }
}
