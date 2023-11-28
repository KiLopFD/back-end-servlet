package controler;

import common.Utility;
import dao.ProductDAO;
import entity.Product;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.execution.Util;
import services.CartServices;
import services.ProductServices;

import java.io.IOException;

@WebServlet({"/product"})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Main domain of servlet app.
        String domain = req.getContextPath();
        try {
            ProductServices productServices = new ProductServices();
            CartServices cartServices = new CartServices();
            // After authentication:
            User user = (User) req.getSession().getAttribute("userAccount");

            // param to decide kind of actions:
            String sortProducts = req.getParameter("sort");
            // sort Products
            if (sortProducts == null) {
                req.setAttribute("sort", "all");
                sortProducts = "all";
            }
            String action = req.getParameter("action");
            // Action: add or detail
            if (action != null)
                System.out.println("/product with action: " + action.split("-")[action.split("-").length - 1]);
            if (action != null) {
                Integer productId = Integer.parseInt(action.split("-")[action.split("-").length - 1]);
                ProductDAO productDAO = new ProductDAO();
                Product product = productDAO.get(productId);
                if (action.contains("add-item")) {
                    cartServices.addItem(user, product);
                    req.getSession().setAttribute("quantityCart", cartServices.getTotalQuantity(user));
                    req.getSession().setAttribute("notice", "success");
                    resp.sendRedirect(domain + "/product");
                    return;
                } else if (action.contains("detail")) {
                    req.getSession().setAttribute("detailItem", product);
                    resp.sendRedirect(domain + "/detail-item");
                    return;
                }
            }
            // to sort
            if (sortProducts.equals("all")) {
                if (productServices.listAllProducts(req, resp, "listProducts")) {
                    req.setAttribute("sort", sortProducts); // Update to save current state
                    Utility.forwardToPage("./pages/product.jsp", req, resp);
                } else {
                    resp.sendRedirect(domain + "/product");
                }
            }
        } catch (Exception e) {
            req.getSession().setAttribute("notice", "danger");
            resp.sendRedirect(domain+"/");
        }


    }
}
