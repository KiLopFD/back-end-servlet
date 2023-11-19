package dao;

import entity.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest {
    public CategoryDAO categoryDAO;
    @BeforeEach
    void setUp() throws Exception {
         categoryDAO = new CategoryDAO();
    }

    @AfterEach
    void tearDown() {
        categoryDAO = null;
    }

    @Test
    void create() throws ParseException, IOException {
        Category category = new Category();
        category.setCategoryName("Redmi");

        Category newCategory = categoryDAO.create(category);
        assertEquals(category.getCategoryName(), newCategory.getCategoryName());
    }

    @Test
    void update() {
    }

    @Test
    void get() {
        try{

            Category category =  categoryDAO.get(7);
            assertNotNull(category);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    @Test
    void delete() {
    }

    @Test
    void listAll() {
    }

    @Test
    void count() {
    }


}