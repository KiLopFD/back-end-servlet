import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.ProductDAO;
import dao.UserDAO;
import entity.Category;
import entity.Product;
import dao.JpaDAO;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import services.ProductServices;
import services.UserService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestData {
    public static void main(String[] args) throws FileNotFoundException {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StorePhone");
//        EntityManager em = emf.createEntityManager();
//        Gson gson = new Gson();
//
//        List<Product> products = gson.fromJson(new FileReader(".src/test/java/data/phones.json"), new TypeToken<List<Product>>() {}.getType());
//
////        }
//
//        for (Product item : products) {
//           item.setDatePublic( new Date());
//            em.getTransaction().begin();
//            em.persist(item);
//            em.getTransaction().commit();
//        }
//        em.close();
//        emf.close();
        try{
            //          checkLogin();
            createUser();
//        deleteUser();
//        listProducts();
        }
        catch (Exception ex){
            System.out.println("UserName or Email already exist");
        }

    }
    public static void  createUser(){
        UserService userService = new UserService();

       boolean check =  userService.create("thanhduc2","12234","admin","tuyenquanghpkt2@gmail.com","Dinh Thanh Duc ","Ho chi Minh","0984839604");
        if(check){
            System.out.println("Register successfully");
        }
        else {
            System.out.println("Username or email already exist");
        }

    }
    public static void checkLogin(){
        UserService userService = new UserService();
        boolean check = userService.checkLogin("Iggy","1234");
        if(check){
            System.out.println("Login successfully");
        }
        else{
            System.out.println("The username or email is not correct");
        }
    }
    public static void deleteUser(){
        UserService userService = new UserService();
        boolean check = userService.deleteUser(1);
        if(check){
            System.out.println("Delete successfully");
        }
        else {
            System.out.println("User is not exist");
        }
    }
    public static void listProducts(){
        ProductServices productServices = new ProductServices();
        List<Product> listProducts = productServices.listAllProduct();
        for(Product product : listProducts){
            System.out.println(product.getProductName()+"---"+product.getPrice()+"---"+product.getCategory());
        }
    }


}
