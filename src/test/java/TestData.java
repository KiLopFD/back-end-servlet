import Models.CategoriesEntity;
import Models.UsersEntity;
import Utils.HibernateUtils;
import Utils.Serializers.UserSerializer;
import com.google.gson.Gson;

public class TestData {
    public static void main(String[] args) {
        UsersEntity usersEntity = new UsersEntity();
//        usersEntity.setAddress("Tphcm");
//        usersEntity.setEmail("hello@gmail.com");
//        usersEntity.setFullName("Nguyen Van A");
//        usersEntity.setPhoneNumber("124556687");
//        usersEntity.setPassword("helloword");
//        usersEntity.setUsername("dev1");
//        usersEntity.setUserId(1);
//
//        HibernateUtils hibernateUtils = new HibernateUtils(usersEntity);
//        hibernateUtils.saveEntity();
//        UsersEntity entity = (UsersEntity) hibernateUtils.getEntityById(usersEntity.getUserId());
//
//        // Print retrieved cat details
//        System.out.println("Retrieved Data: ID=" + entity.getUserId() +
//                ", Name=" + entity.getFullName()+
//                ", Email=" + entity.getEmail() +
//                ", Phone=" + entity.getPhoneNumber());

//        UsersEntity usersEntity = new UsersEntity();
//        HibernateUtils hibernateUtils = new HibernateUtils(usersEntity);
//        usersEntity = (UsersEntity)hibernateUtils.getEntityById(1);
//        hibernateUtils.getEntityById(1);
//        System.out.println((UsersEntity)hibernateUtils.getEntityById(1));
//        Gson json = new Gson();
//        System.out.println(json.toJson((UsersEntity)hibernateUtils.getEntityById(1)));


        CategoriesEntity categoriesEntity = new CategoriesEntity();
        categoriesEntity.setCategoryName("iphone");
        HibernateUtils hibernateUtils = new HibernateUtils(categoriesEntity);
        hibernateUtils.saveEntity();
        System.out.println((CategoriesEntity)hibernateUtils.getEntityById(1));
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
