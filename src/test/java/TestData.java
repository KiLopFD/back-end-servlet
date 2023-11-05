import models.CategoriesEntity;
import models.ProductsEntity;
import utils.HibernateUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TestData {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        List<ProductsEntity> productsEntities = gson.fromJson(new FileReader("D:\\Users\\Inteliji\\back-end-servlet\\src\\test\\java\\data\\phones.json"), new TypeToken<List<ProductsEntity>>() {}.getType());
        System.out.println(productsEntities);
        //
        List<CategoriesEntity> categoryEntities = gson.fromJson(new FileReader("D:\\Users\\Inteliji\\back-end-servlet\\src\\test\\java\\data\\categories.json"), new TypeToken<List<CategoriesEntity>>() {}.getType());

        for (CategoriesEntity item: categoryEntities
        ) {
            HibernateUtils hibernateUtils = new HibernateUtils(item);
            hibernateUtils.saveEntity();
        }

        for (ProductsEntity item : productsEntities
             ) {
            HibernateUtils hibernateUtils = new HibernateUtils(item);
            hibernateUtils.saveEntity();
        }
    }

    public static void createData() {
        CategoriesEntity categoriesIphone = new CategoriesEntity();
        categoriesIphone.setCategoryName("iphone");
        CategoriesEntity categoriesSamsung = new CategoriesEntity();
        categoriesSamsung.setCategoryName("samsung");
        //
        HibernateUtils hibernateUtils = new HibernateUtils(categoriesIphone);
        hibernateUtils.saveEntity();
        hibernateUtils = new HibernateUtils(categoriesSamsung);


    }
}
