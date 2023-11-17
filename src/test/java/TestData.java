import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.*;
import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import services.OrderDetailServices;
import services.OrderServices;
import services.ProductServices;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestData {
    public static void main(String[] args) throws FileNotFoundException {
        OrderServices a = new OrderServices();
        a.DelOrder(2);

//        Order order = new Order();
//        User user = new UserDAO().get(1);
//
//        Orderdetail orderdetail = new Orderdetail();
//
//        Product product = new ProductDAO().get(2);
//        orderdetail.setProductOfOrderDetail(product);
//        orderdetail.setQuantity(1);
//        orderdetail.setDetailTime( new Date());
//        orderdetail.setTotalPrice(BigDecimal.valueOf(1000));
//
//        a.AddOrder(user);
//        a.AddOrderDet(a.ListAllByUser(user).get(0).getOrderId(), user, orderdetail);

//        OrderDetailServices b = new OrderDetailServices();
//        Orderdetail ord = new Orderdetail();
//        ProductDAO prod = new ProductDAO();
//        ord.setQuantity(2);
//        ord.setTotalPrice(new BigDecimal(12));
//        ord.setProductOfOrderDetail(prod.get(2));
//        ord.setDetailTime(new Date());
//        UserDAO aasd = new UserDAO();
//        OrderDAO bassd = new OrderDAO();
//        if(a.RemOrderList(1, aasd.get(1), 0))
//        {
//            System.out.println("in");
//        }
//        else
//            System.out.println("out");
//        System.out.println(b.find(3));
//        Set<Orderdetail> test = a.ListAllOrderDetails(1);
//        for(Orderdetail as: test)
//            System.out.println(as.getProductOfOrderDetail().getProductName());
//        ProductServices a = new ProductServices();
//        CategoryDAO cat = new CategoryDAO();
//        if ( a.AddProduct("test", "hoho", new BigDecimal(135.69), "cc", cat.get(1) ) )
//        {
//            System.out.println("in");
//        }
//        else
//            System.out.println("out");

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StorePhone");
//        EntityManager em = emf.createEntityManager();
//        Gson gson = new Gson();
//
//        List<Product> products = gson.fromJson(new FileReader("./src/test/java/data/phones.json"), new TypeToken<List<Product>>() {}.getType());
//        List<Category> categories = gson.fromJson(new FileReader("./src/test/java/data/categories.json"), new TypeToken<List<Category>>() {}.getType());
//        for (Category item : categories) {
//            em.getTransaction().begin();
//            em.persist(item);
//            em.getTransaction().commit();
//        }
//
//        for (Product item : products) {
//           item.setDatePublic( new Date());
//            em.getTransaction().begin();
//            em.persist(item);
//            em.getTransaction().commit();
//        }
//        em.close();
//        emf.close();

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
