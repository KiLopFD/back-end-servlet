package controler;

import common.Utility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.execution.Util;
import services.ProductServices;

import java.io.IOException;

@WebServlet({"/product"})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductServices productServices = new ProductServices();
        String domain = req.getContextPath();
        try {
            if (productServices.listAllProducts(req, resp, "listProducts")) {
                Utility.forwardToPage("./pages/product.jsp", req, resp);
            }
            else {
                resp.sendRedirect(domain+'/');
            }
        } catch (Exception error) {
            resp.sendRedirect(domain+'/');
        }
    }
}
