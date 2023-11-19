package services;

import entity.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {
    public CategoryService categoryService;
    @BeforeEach
    void setUp() {
            categoryService = new CategoryService();
    }

    @AfterEach
    void tearDown() {
        categoryService = null;
    }

    @Test
    void listAllCategory() {
        List<Category> categoryList = categoryService.listAllCategory();
        for(Category category : categoryList){
            System.out.println(category.getCategoryName());
        }
        assertFalse(categoryList.isEmpty());
    }

    @Test
    void findNameCategory() {
        String name = "Samsung";
        Category category = categoryService.findNameCategory(name);
        System.out.println(category.getCategoryName());
        assertNotNull(category);

    }

    @Test
    void createCategory() {
        String name = "Xiaomi";
        boolean check = categoryService.createCategory(name);
        if(check){
            System.out.println("Create successfully");
        }else {
            System.out.println("Name already exist in list");
        }
//        Category category = categoryService.findNameCategory(name);
//        System.out.println(category.getCategoryName());
//        assertNotNull(category);
    }

    @Test
    void updateCategory() {
        String name = "Lenovo";
        boolean check = categoryService.updateCategory(2,name);
        if(check){
            System.out.println("Cap nhat thanh cong");
        }else {
            System.out.println("Cap nhap ko thanh cong ");
        }

    }

    @Test
    void deleteCategory() {
    }
}