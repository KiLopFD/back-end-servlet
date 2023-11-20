package services;

import dao.CategoryDAO;
import entity.Category;

import java.util.List;

public class CategoryService {
    private static CategoryDAO categoryDAO;

    public CategoryService() {
        categoryDAO = new CategoryDAO();
    }
    public List<Category> listAllCategory() {
        return categoryDAO.listAll();
    }
    public Category findNameCategory(String nameCategory){
        try{
            return categoryDAO.findByName(nameCategory);
        }
        catch (Exception ex){
            System.out.println("Khong tim thay Category"+ex);
            return null;
        }
    }
    public boolean createCategory(String nameCategory){
            if(findNameCategory(nameCategory) == null){
                Category category = new Category();
                category.setCategoryName(nameCategory);
                categoryDAO.create(category);
                return true;
            }
            return false;
    }

    public boolean updateCategory(int categoryId, String nameCategory){

        if (categoryDAO.get(categoryId) != null){
            Category category = new Category();
            category.setCategoryName(nameCategory);
            categoryDAO.update(category);
            return true;
        }
        return false;
    }
     public boolean deleteCategory(int categoryId){
        if(categoryDAO.get(categoryId) != null){
            Category category =categoryDAO.get(categoryId);
            categoryDAO.delete(category);
            return true;
        }
        return false;
     }

}
