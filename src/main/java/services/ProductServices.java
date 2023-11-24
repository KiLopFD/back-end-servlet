package services;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Product;
import entity.User;

import java.util.List;

/**
 * Handling all the product function
 */
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

    /**
     *
     * @param user
     * @return A list of products that has been purchased by a user
     */
    public List<Product> findPaidProductsByUser(User user){
        List<Product> listProductByUser =  productDAO.findPaidProductsByUser(user);
        return  listProductByUser;
    }

    /**
     *
     * @return A list of exist products
     */
    public List<Product> listAllProduct (){
        return productDAO.listAll();
    }
}
