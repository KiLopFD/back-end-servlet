package dao;

import common.HashGenerator;
import entity.Order;
import entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User>  {


    public User create(User user){
        String encryptedPassword = HashGenerator.generateMD5(user.getPassword());
        user.setPassword(encryptedPassword);
        return super.create(user);
    }
    @Override
    public User update(User user){
        return super.update(user);
    }
    @Override
    public User get(Object id) {
        return super.find(User.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(User.class, id);
    }

    public boolean checkLogin(String userName,String password){
        Map<String, Object> params = new HashMap<>();
        String encryptedPassword = HashGenerator.generateMD5(password);
        params.put("username",userName);
        params.put("password",encryptedPassword);

        List<User> listUsers = super.findWithNamedQuery("User.checkLogin",params);
        if(listUsers.size() == 1){
            System.out.println("Đăng nhập thành công");
            return true;
        }
        return false;
    }
    @Override
    public List<User> listAll() {
        return super.findWithNamedQuery("User.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("User.countAll");
    }
    public User findByUserName(String userName){
        List<User> listUsers = super.findWithNamedQuery("User.findByUserName","username",userName);
        if(listUsers != null && listUsers.size()>0){
            return listUsers.get(0);
        }
        return  null;
     }

    public User findByEmail(String email){
        List<User> listUsers = super.findWithNamedQuery("User.findByEmail","email",email);
        if(listUsers != null && listUsers.size()>0){
            return listUsers.get(0);
        }
        return  null;
    }

}
