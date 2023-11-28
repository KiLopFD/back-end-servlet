package services;

import com.oracle.wls.shaded.org.apache.bcel.generic.FALOAD;
import dao.CartDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductServices {
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;

    public ProductServices() {
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
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
    public boolean actionProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            String productName = request.getParameter("productName");
            String description = request.getParameter("description");
            //
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String stringDate =  request.getParameter("datePublic");
            System.out.println(stringDate);
            Date datePublic = null;
            if (stringDate != null && !stringDate.isEmpty() && !stringDate.isBlank()) {
                Date oldFormat = dateFormat.parse(stringDate);
                dateFormat.applyPattern("yyyy-MM-dd");
                String newDateString = dateFormat.format(oldFormat);
                datePublic = dateFormat.parse(newDateString);
            }

            //
            BigDecimal price = null;
            String stringPrice = request.getParameter("price").trim();
            if (stringPrice != null && !stringPrice.isBlank() && !stringPrice.isEmpty()){
                price = new BigDecimal(stringPrice);
            }
            //
            String urlImg = request.getParameter("urlImg");
            String idProduct = request.getParameter("idProduct");
            String productAction = request.getParameter("productAction");
            //
            CategoryServices categoryServices = new CategoryServices();
            String cate = request.getParameter("category");
            Category category = categoryServices.findNameCategory(cate);
            if (category == null && cate!= null && !cate.isBlank() && !cate.isEmpty()){
                Category newCate = new Category();
                newCate.setCategoryName(cate);
                category = categoryDAO.create(newCate);
            }

            if (productAction != null) {
                if (productAction.equals("add-product")) {
                    /**
                     * @note blank: white space, empty: ''.
                     */
                    if (productName != null && !productName.isBlank() && !productName.isEmpty() &&
                            description != null && !description.isBlank() && !description.isEmpty() &&
                            datePublic != null &&
                            price != null &&
                            urlImg != null && !urlImg.isBlank() && !urlImg.isEmpty() &&
                            category != null
                    ) {
                        Product product = new Product();
                        product.setProductName(productName);
                        product.setDescription(description);
                        product.setPrice(price);
                        product.setDatePublic(datePublic);
                        product.setUrlImg(urlImg);
                        product.setCategory(category);
                        productDAO.create(product);
                        return true;
                    } else {
                        return false;
                    }
                } else if (productAction.equals("update-product")) {
                    if (idProduct == null || idProduct.isEmpty() || idProduct.isBlank()) {
                        return false;
                    } else {
                        Product oldProduct = null;
                        try {
                            oldProduct = productDAO.get(Integer.parseInt(idProduct));
                        }
                        catch (Exception e){
                            request.getSession().setAttribute("notice", "danger");
                            request.getSession().setAttribute("msgNotice", "No Id Found To Update");
                            return false;
                        }
                        if (productName != null && !productName.isBlank() && !productName.isEmpty() && !productName.equals(oldProduct.getProductName())) {
                            oldProduct.setProductName(productName);
                        }
                        if (description != null && !description.isBlank() && !description.isEmpty() && !description.equals(oldProduct.getDescription())) {
                            oldProduct.setDescription(description);
                        }
                        if (datePublic != null && datePublic.compareTo(oldProduct.getDatePublic()) != 0) {
                            oldProduct.setDatePublic(datePublic);
                        }
                        if (price != null && (price.compareTo(oldProduct.getPrice()) != 0)) {
                            oldProduct.setPrice(price);
                        }
                        if (urlImg != null && !urlImg.isBlank() && !urlImg.isEmpty() && !urlImg.equals(oldProduct.getUrlImg())) {
                            oldProduct.setUrlImg("urlImg");
                        }
                        if (category != null && oldProduct != null) {
                            oldProduct.setCategory(category);
                        }
                        if (oldProduct == null){
                            request.getSession().setAttribute("notice", "danger");
                            request.getSession().setAttribute("msgNotice", "No Id Found To Update");
                            return false;
                        }else {
                            productDAO.update(oldProduct);
                        }
                    }
                    return false;
                } else if (productAction.equals("delete-product")) {
                    if (idProduct == null || idProduct.isEmpty() || idProduct.isBlank()) {
                        return false;
                    } else {
                        try {
                            productDAO.delete(Integer.parseInt(idProduct));
                        }
                        catch (Exception e){
                            request.getSession().setAttribute("notice", "danger");
                            request.getSession().setAttribute("msgNotice", "No Id Found To Delete");
                            return false;
                        }
                    }
                }
            }
            return false;

        } catch (Error e) {
            System.out.println(e);
            request.getSession().setAttribute("notice", "danger");
            request.getSession().setAttribute("msgNotice", "Error When Acting Change Data Product");
            return false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}

