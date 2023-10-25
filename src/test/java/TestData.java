import Models.UsersEntity;
import Utils.HibernateUtils;
import Utils.Serializers.UserSerializer;
import com.google.gson.Gson;

public class TestData {
    public static void main(String[] args) {
//        UsersEntity usersEntity = new UsersEntity();
//        usersEntity.setAddress("Tphcm");
//        usersEntity.setEmail("hello3@gmail.com");
//        usersEntity.setFullName("Nguyen Van A");
//        usersEntity.setPhoneNumber("124556687");
//        usersEntity.setPassword("hell3oword");
//        usersEntity.setUsername("dev3");
////        usersEntity.setUserId(1);
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

        UsersEntity usersEntity = new UsersEntity();
        HibernateUtils hibernateUtils = new HibernateUtils(usersEntity);
        usersEntity = (UsersEntity)hibernateUtils.getEntityById(1);
        System.out.println((UsersEntity)hibernateUtils.getEntityById(1));
        Gson json = new Gson();
        System.out.println(usersEntity.getFullName()+" "+ usersEntity.getEmail());
    }
}
