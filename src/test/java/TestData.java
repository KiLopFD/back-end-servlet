import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oracle.wls.shaded.org.apache.xpath.res.XPATHErrorResources_ru;
import dao.ProductDAO;
import entity.Category;
import entity.Product;
import dao.JpaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestData {
    @Test
    void listAllProduct() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.listAll();
        for (Product product : products) {
            System.out.println(product.getProductName());
        }
    }
}
