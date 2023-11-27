package controler;

import common.Utility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.UserServices;

import java.io.IOException;
@WebServlet({"/sign-up"})
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utility.forwardToPage("./pages/sign_up.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post Sign Up");
        HttpSession session = req.getSession();
        UserServices userServices = new UserServices();
        String domain = req.getContextPath();

        try {
            if (userServices.signUp(req, resp)) {
                System.out.println("Sign Up Successfully");
                req.getSession().setAttribute("notice", "success");
                resp.sendRedirect(domain + "/");

            } else {
                System.out.println("Sign Up Fail");
                req.getSession().setAttribute("notice", "danger");
                resp.sendRedirect(domain+"/sign-up");
            }
        } catch (Exception e) {
            System.out.println(e);
            resp.sendRedirect(domain + "/sign-up");
        }
    }
}
