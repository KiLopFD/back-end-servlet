import dao.ProductDAO;
import entity.Category;
import entity.Product;
import dao.JpaDAO;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class TestData {
    public static void main(String[] args) throws FileNotFoundException {
//        Gson gson = new Gson();
//        List<Product> productsEntities = gson.fromJson(new FileReader("C:\\Work_Space\\Web_Tech\\Inteliji\\back-end-servlet\\src\\test\\java\\data\\phones.json"), new TypeToken<List<Product>>() {}.getType());
//        System.out.println(productsEntities);
//        //
//        List<Category> categoryEntities = gson.fromJson(new FileReader("C:\\Work_Space\\Web_Tech\\Inteliji\\back-end-servlet\\src\\test\\java\\data\\categories.json"), new TypeToken<List<Category>>() {}.getType());
//
//        for (Category item: categoryEntities
//        ) {
//            JpaDAO hibernateUtils = new JpaDAO(item);
//            hibernateUtils.saveEntity();
//        }
//
//        for (Product item : productsEntities
//             ) {
//            JpaDAO hibernateUtils = new JpaDAO(item);
//            hibernateUtils.saveEntity();
//        }
        Category category = new Category();
        category.setCategoryName("Samsung");
        JpaDAO<Category> jpaDAO = new JpaDAO();
        jpaDAO.create(category);

        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product.setCategory(jpaDAO.find(Category.class, 1));
        product.setProductName("Iphone X");
        product.setUrlImg("");
        product.setPrice(BigDecimal.valueOf(50000000));
        product.setDescription("");
        product.setDatePublic(Timestamp.valueOf("2022-04-04 04:12:35"));
        productDAO.create(product);
        System.out.println(productDAO.listAll());
    }

    public static void createData() {
//        Category categoriesIphone = new Category();
//        categoriesIphone.setCategoryName("iphone");
//        Category categoriesSamsung = new Category();
//        categoriesSamsung.setCategoryName("samsung");
//        //
//        JpaDAO hibernateUtils = new JpaDAO(categoriesIphone);
//        hibernateUtils.saveEntity();
//        hibernateUtils = new JpaDAO(categoriesSamsung);


    }
}
