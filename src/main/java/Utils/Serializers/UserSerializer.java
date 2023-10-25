package Utils.Serializers;

import Models.UsersEntity;
import Utils.HibernateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;

public class UserSerializer extends HibernateUtils  {
    public UserSerializer(UsersEntity object) {
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
