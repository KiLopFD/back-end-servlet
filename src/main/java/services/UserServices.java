package services;

import common.HashGenerator;
import dao.UserDAO;
import entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * isLogin: true | false
 * userAccount: User
 */
public class UserServices {
    private final UserDAO userDAO = new UserDAO();
    private final MailServices mailServices = new MailServices();


    public UserServices() {
    }

    public boolean signUp (HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        String phone = (String) request.getParameter("phone");
        String username = (String) request.getParameter("username");
        System.out.println(email + " " + password +" " + phone +" "+ username);
        if (email != null && password != null && username != null && phone != null && !email.isEmpty() && !password.isEmpty() && !phone.isEmpty() && !username.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setPhoneNumber(phone);
            user.setUsername(username);
            user.setFullName("");
            user.setRole("endUser");
            user.setAddress("");
            this.userDAO.create(user);
            request.getSession().setAttribute("userAccount", user);
            request.getSession().setAttribute("isLogin", true);
            this.mailServices.sendMailToUser(user.getFullName(), username, email);
            return true;
        }
        return false;
    }
    public boolean checkLoginUsername(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = new HashMap<>();
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            String encryptedPassword = HashGenerator.generateMD5(password);
            params.put("username",username);
            params.put("password",encryptedPassword);
        }


        List<User> listUsers = userDAO.findWithNamedQuery("User.checkLogin",params);
        if(listUsers.size() == 1){
            System.out.println("Đăng nhập thành công");
            request.getSession().setAttribute("isLogin", true);
            request.getSession().setAttribute("userAccount", listUsers.get(0));
            return true;
        }
        return false;
    }
}
