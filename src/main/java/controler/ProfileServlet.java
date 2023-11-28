package controler;

import common.Utility;
import dao.UserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UserServices;

import java.io.IOException;
@WebServlet({"/profile"})
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domain = req.getContextPath();
        try {
            User user = (User) req.getSession().getAttribute("userAccount");
            UserDAO userDAO = new UserDAO();
            String action = req.getParameter("action");

            if (action != null) {
                if (action.equals("update")) {
                    String email = req.getParameter("email");
                    String fullName = req.getParameter("fullName");
                    String password = req.getParameter("password");
                    String phone = req.getParameter("phone");
                    String address = req.getParameter("address");
                    if (email != null && !email.isEmpty() && !email.isBlank() ) {
                        user.setEmail(email);
                    }
                    if (fullName != null && !fullName.isEmpty() && !fullName.isBlank() ) {
                        user.setFullName(fullName);
                    }
                    if ((password != null) && !password.isEmpty() && !password.isBlank() && (password != user.getPassword())) {
                        user.setPassword(password);
                    }
                    if (phone != null && !phone.isEmpty() && !phone.isBlank() ) {
                        user.setPhoneNumber(phone);
                    }
                    if (address != null && !address.isEmpty() && !address.isBlank() ) {
                        user.setAddress(address);
                    }
                    user = userDAO.update(user);
                    req.getSession().setAttribute("userAccount", user);
                    req.getSession().setAttribute("notice", "success");
                    resp.sendRedirect(domain+"/profile");
                    return;
                }

            }
            Utility.forwardToPage("./pages/profile.jsp", req, resp);
        }
        catch (Exception e) {
            req.getSession().setAttribute("notice", "danger");
            resp.sendRedirect(domain + "/");
        }

    }
}
