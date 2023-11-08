package dao;

import entity.User;

import java.util.List;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User>  {
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
