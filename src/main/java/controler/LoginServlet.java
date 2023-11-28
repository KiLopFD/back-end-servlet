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

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");
        UserServices userServices = new UserServices();
        String domain = req.getContextPath();

        try {
            if (userServices.checkLoginUsername(req, resp)) {
                System.out.println(req.getSession().getAttribute("userAccount"));
                System.out.println(req.getSession().getAttribute("isLogin"));

                System.out.println("Login Successfully");
                req.getSession().setAttribute("notice", "success");
                resp.sendRedirect(domain + "/");
            }
            else {
                System.out.println("Login Fail");
                req.getSession().setAttribute("notice", "danger");
                Utility.forwardToPage("./pages/login.jsp", req, resp);
            }
        }
        catch (Exception error) {
            req.getSession().setAttribute("notice", "danger");
            resp.sendRedirect(domain + "/");
        }
    }
}
