package services;

import common.HashGenerator;
import dao.UserDAO;
import entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServices {
    private UserDAO userDAO;

    public boolean signUp (HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        
        return false;
    }

    public boolean checkLogin(String userName,String password){
        Map<String, Object> params = new HashMap<>();
        String encryptedPassword = HashGenerator.generateMD5(password);
        params.put("username",userName);
        params.put("password",encryptedPassword);

        List<User> listUsers = userDAO.findWithNamedQuery("User.checkLogin",params);
        if(listUsers.size() == 1){
            System.out.println("Đăng nhập thành công");
            return true;
        }
        return false;
    }
}
