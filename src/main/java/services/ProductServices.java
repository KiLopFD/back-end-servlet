package services;

import com.oracle.wls.shaded.org.apache.bcel.generic.FALOAD;
import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ProductServices {
    private ProductDAO productDAO;

    public ProductServices() {
        productDAO = new ProductDAO();
    }

    public boolean listAllProducts(HttpServletRequest request,
                                   HttpServletResponse response,
                                   String attributeName) {
        try {
            request.setAttribute(attributeName, productDAO.listAll());
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}


