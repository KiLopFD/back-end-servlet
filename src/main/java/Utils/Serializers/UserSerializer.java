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

    public String save(){
        Gson responseJson = new Gson();
        try {
            super.saveEntity();
            return responseJson.toJson(super.object);
        }
        catch (Exception error)
        {
            return responseJson.toJson(error);
        }
    }

    public String get(int pk){
        Gson responseJson = new Gson();
        try {
            UsersEntity usersEntity = (UsersEntity) super.getEntityById(pk);
//            System.out.println(usersEntity);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "{ \"type\" : \"success\","
                                + "\"data\": {"
                                + "\"fullName\":" + usersEntity.getFullName() +"}"
                                + "}";
            return responseJson.toJson(jsonString);
        }
        catch (Exception error)
        {
            return responseJson.toJson(error);
        }
    }
}
