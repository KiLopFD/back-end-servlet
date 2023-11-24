package services;

import dao.CategoryDAO;
import entity.Category;

import java.util.List;

/**
 * Handling all the category function
 */
public class CategoryServices {
    private static CategoryDAO categoryDAO;

    public CategoryServices() {
        categoryDAO = new CategoryDAO();
    }

    /**
     *
     * @return A list of categories
     */
    public List<Category> listAllCategory() {
        return categoryDAO.listAll();
    }

    /**
     *
     * @param nameCategory
     * @return Find an exist category
     */
    public Category findNameCategory(String nameCategory){
        try{
            return categoryDAO.findByName(nameCategory);
        }
        catch (Exception ex){
            System.out.println("Khong tim thay Category"+ex);
            return null;
        }
    }

    /**
     *
     * @param nameCategory
     * @return Create a category
     */
    public boolean createCategory(String nameCategory){
            if(findNameCategory(nameCategory) == null){
                Category category = new Category();
                category.setCategoryName(nameCategory);
                categoryDAO.create(category);
                return true;
            }
            return false;
    }

    /**
     *
     * @param categoryId
     * @param nameCategory
     * @return Update a category
     */
    public boolean updateCategory(int categoryId, String nameCategory){

        if (categoryDAO.get(categoryId) != null){
            Category category = new Category();
            category.setCategoryName(nameCategory);
            categoryDAO.update(category);
            return true;
        }
        return false;
    }

    /**
     *
     * @param categoryId
     * @return Delete a category
     */
    public boolean deleteCategory(int categoryId){
        if(categoryDAO.get(categoryId) != null){
            Category category =categoryDAO.get(categoryId);
            categoryDAO.delete(category);
            return true;
        }
        return false;
     }

}
