package dao;

import common.HashGenerator;
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

    @Override
    public List<User> listAll() {
        return super.findWithNamedQuery("User.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("User.countAll");
    }


}
