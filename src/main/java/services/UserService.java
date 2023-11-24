package services;

import dao.UserDAO;
import entity.User;

import java.util.List;

/**
 * Handling all the user function
 */
public class UserService {

    private static UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    /**
     *
     * @param username
     * @param password
     * @return Check login
     */
    public boolean checkLogin(String username, String password) {
        return userDAO.checkLogin(username, password);
    }

    /**
     *
     * @return List of all users
     */
    public List<User> listUser() {
        return userDAO.listAll();
    }

    /**
     *
     * @param userName
     * @param email
     * @return Check if a user exist
     */
    public boolean checkExistUser(String userName, String email) {
        boolean exist = false;
        User checkedByUserName = userDAO.findByUserName(userName);
        User checkedByEmail = userDAO.findByEmail(email);
        if (checkedByEmail != null || checkedByUserName != null) {
            exist = true;
        }
        return exist;
    }

    /**
     *
     * @param username
     * @param password
     * @param role
     * @param email
     * @param fullName
     * @param address
     * @param phoneNumber
     * @return Create a new user
     */
    public boolean create(String username, String password, String role, String email, String fullName, String address, String phoneNumber) {
        boolean checkExist = checkExistUser(username, email);
        MailService mailService = new MailService();
        CartService cartService = new CartService();
        if (!checkExist) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setRole(role);
            user.setFullName(fullName);
            user.setAddress(address);
            user.setPhoneNumber(phoneNumber);
            userDAO.create(user);

//            Send mail to user
            mailService.sendMailToUser(fullName,username,email);
            return true;
        } else {
            return false;
        }

    }

    /**
     *
     * @param id
     * @return Find user by ID
     */
    public User findByIdentity(int id) {
        return userDAO.get(id);

    }

    /**
     *
     * @param userName
     * @return Find user by name
     */
    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    /**
     *
     * @param email
     * @return Find user by email
     */
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    /**
     *
     * @param id
     * @return Delete a user
     */
    public boolean deleteUser(int id) {
        User user = userDAO.get(id);
        if (user == null) {
            return false;
        }
        userDAO.delete(id);
        return true;
    }

    /**
     *
     * @param fullName
     * @param password
     * @param address
     * @param phoneNumber
     * @return Update a user
     */
    public boolean updateUser(String fullName, String password, String address, String phoneNumber) {
        if (fullName != null && !fullName.isEmpty() && password != null && !password.isEmpty() && address != null && !address.isEmpty() && phoneNumber != null && !phoneNumber.isEmpty()) {
            User user = new User();
            user.setFullName(fullName);
            user.setPassword(password);
            user.setAddress(address);
            user.setPhoneNumber(phoneNumber);
            userDAO.update(user);
            return true;
        }
        return false;
    }

//    Update
//    public void updateInfo(Map<String, String> updates){
//        User user = new User();
//        for(Map.Entry<String,String> entry : updates.entrySet()){
//            switch (entry.getKey()){
//                case "address":
//                    user.setAddress(entry.getValue());
//                    break;
//                case "full_name":
//                    user.setFullName(entry.getValue());
//                    break;
//                case "password":
//                   user.setPassword(entry.getValue());
//                    break;
//                case "phone_number":
//                  user.setPhoneNumber(entry.getValue());
//                    break;
//                case "role":
//                   user.setRole(entry.getValue());
//                    break;
//            }
//        }
//        userDAO.update(user);
////        Cách sữ dụng
////        Map<String, String> updates = new HashMap<>();
////        updates.put("address", "New Address");
////        updates.put("phone_number", "987654321");
//    }


}
