import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.ProductDAO;
import entity.Category;
import entity.Product;
import dao.JpaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestData {
    public static void main(String[] args) throws FileNotFoundException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StorePhone");
        EntityManager em = emf.createEntityManager();
        Gson gson = new Gson();

        List<Product> products = gson.fromJson(new FileReader("C:\\Study\\Web Programming\\project-version2\\back-end-servlet\\src\\test\\java\\data\\phones.json"), new TypeToken<List<Product>>() {}.getType());

//        }

        for (Product item : products) {
           item.setDatePublic( new Date());
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();

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
