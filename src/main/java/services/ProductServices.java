package services;

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
    private CategoryDAO categoryDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public HttpServletRequest listProducts() throws ServletException, IOException {
        return listProducts(null);
    }

    public HttpServletRequest listProducts(String message) throws ServletException, IOException {
        List<Product> listProducts = productDAO.listAll();
        if (message == null) {
            request.setAttribute("message", "Không có dữ liệu");
        }
        else{
            request.setAttribute(message, listProducts);
        }
        return request;
    }
}
