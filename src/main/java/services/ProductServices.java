package services;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductServices {
    private ProductDAO productDAO = new ProductDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    @PersistenceContext
    private EntityManager em;

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

    //TODO: ADD, REMOVE, SEARCH
    public List<Product> AllProd()
    {
        return productDAO.listAll();
    }
    public Boolean AddProduct(String name, String desc, BigDecimal price, String img_url, Category category) {
        Product prod = new Product();
        prod.setProductName(name);
        prod.setDescription(desc);
        prod.setDatePublic(new Date());
        prod.setPrice(price);
        prod.setUrlImg(img_url);
        prod.setCategory(category);

        Product test = productDAO.create(prod);
        if(test == null)
            return false;
        return true;
    }

    public Boolean AddProduct(Product prod) {
        Product test = productDAO.create(prod);
        if(test == null)
            return false;
        return true;
    }

    public Product SearchProd(String name)
    {
        return productDAO.findByName(name);
    }

    public Product SearchProd(int id)
    {
        return productDAO.get(id);
    }

    public boolean RemPro(Object Prodid)
    {
        try {
            productDAO.delete(Prodid);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
