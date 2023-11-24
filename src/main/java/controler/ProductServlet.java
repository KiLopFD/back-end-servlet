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
        ProductServices productServices = new ProductServices();
        // Main domain of servlet app.
        String domain = req.getContextPath();
        // param to decide kind of actions:
        String sortProducts = req.getParameter("sort");
        String action = req.getParameter("action");
        System.out.println(action);
        if (action != null)
            System.out.println(action.split("-")[action.split("-").length-1]);
        if (action != null && action.contains("add-item")) {
            CartServices cartServices = new CartServices();
            User user = (User) req.getSession().getAttribute("userAccount");
            Integer productId =  Integer.parseInt(action.split("-")[action.split("-").length-1]);
            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.get(productId);
            cartServices.addItem(user, product);
            cartServices.clear(user);
            System.out.println(cartServices.getTotalQuantity(user));
        }

        if (sortProducts == null){
            try {
                if (productServices.listAllProducts(req, resp, "listProducts")) {
                    Utility.forwardToPage("./pages/product.jsp", req, resp);
                } else {
                    resp.sendRedirect(domain + '/');
                }
            } catch (Exception error) {
                resp.sendRedirect(domain + '/');
            }
        }


    }
}
