package services;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Product;

import java.util.List;

public class ProductServices {
    private static ProductDAO productDAO;
    private CategoryDAO categoryDAO;

    public ProductServices() {
        productDAO = new ProductDAO();
    }
    //    public HttpServletRequest listProducts() throws ServletException, IOException {
//        return listProducts(null);
//    }

//    public HttpServletRequest listProducts(String message) throws ServletException, IOException {
//        List<Product> listProducts = productDAO.listAll();
//        if (message == null) {
//            request.setAttribute("message", "Không có dữ liệu");
//        }
//        else{
//            request.setAttribute(message, listProducts);
//        }
//        return request;
//    }
    public List<Product> listAllProduct (){
        return productDAO.listAll();
    }
}
