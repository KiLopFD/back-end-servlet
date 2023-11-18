package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Category;
import entity.Product;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CategoryDAOTest extends JpaDAO<Category> {
    static Gson gson = new Gson();
    static List<Category> categories;

    static {
        try {
            categories = gson.fromJson(new FileReader("C:\\Work_Space\\Web_Tech\\Inteliji\\back-end-servlet\\src\\test\\java\\data\\categories.json"), new TypeToken<List<Category>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void create() {
        for (Category category : categories) {
            super.create(category);
        }
    }

}
