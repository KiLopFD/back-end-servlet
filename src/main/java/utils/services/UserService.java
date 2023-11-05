package utils.services;

import models.UsersEntity;
import utils.HibernateUtils;
import com.google.gson.Gson;

public class UserService extends HibernateUtils  {
    public UserService(UsersEntity object) {
        super(object);
    }

    public void save(){
        Gson responseJson = new Gson();
        try {
            super.saveEntity();
        }
        catch (Exception error)
        {
            System.out.println(error);
        }
    }

    public String getName(int pk){
//        Gson responseJson = new Gson();
        try {
            UsersEntity usersEntity = (UsersEntity) super.getEntityById(pk);
            return usersEntity.getFullName();
        }
        catch (Exception error)
        {
            return error.toString();
        }
    }
}
