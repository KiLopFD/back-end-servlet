package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Category;
import entity.Product;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.List;

public class ProductDaoTest extends JpaDAO<Product>{
    static Gson gson = new Gson();
    static List<Product> products;

    static {
        try {
            products = gson.fromJson(new FileReader("C:\\Work_Space\\Web_Tech\\Inteliji\\back-end-servlet\\src\\test\\java\\data\\phones.json"), new TypeToken<List<Product>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void create() {
        for (Product product : products) {
            product.setDatePublic(new Date());
            super.create(product);
        }
    }
}
