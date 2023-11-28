package controler;

import common.Utility;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UserServices;

import java.io.IOException;
@WebServlet({"/admin"})
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        Boolean isLogin = (Boolean) req.getSession().getAttribute("isLogin");
        User userAccount;
        try {
            userAccount = (User) req.getSession().getAttribute("userAccount");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String domain = req.getContextPath();

        if (isLogin && userAccount.getRole().equals("admin")){
            Utility.forwardToPage("./pages/admin/dashboard.jsp", req, resp);
            return;
        }
        if (page != null) {
            if (page.equals("sign-up")) {
                Utility.forwardToPage("./pages/admin/sign_up.jsp", req, resp);
                return;
            } else if (page.equals("login")) {
                Utility.forwardToPage("./pages/admin/login.jsp", req, resp);
                return;
            }
        }

        resp.sendRedirect(domain+"/admin?page=login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domain = req.getContextPath();
        String options = req.getParameter("options");
        System.out.println("Options: " + options);
        if (options != null) {
            if (options.equals("sign-up")) {
                req.setAttribute("role", "admin");
                UserServices userServices = new UserServices();
                try {
                    if (userServices.signUp(req, resp)) {
                        req.getSession().setAttribute("notice", "success");
                        resp.sendRedirect(domain + "/admin");
                        return;
                    } else {
                        req.getSession().setAttribute("notice", "danger");
                        Utility.forwardToPage("./pages/admin/sign_up.jsp", req, resp);
                        return;
                    }
                } catch (Exception e) {
                    req.getSession().setAttribute("notice", "danger");
                    Utility.forwardToPage("./pages/admin/sign_up.jsp", req, resp);
                    return;
                }

            }
            else if (options.equals("login")){
                UserServices userServices = new UserServices();
                if (userServices.checkLoginUsername(req, resp)){
                    req.getSession().setAttribute("notice", "success");
                    resp.sendRedirect(domain+"/admin");
                    return;
                }
                else {
                    req.getSession().setAttribute("notice", "danger");
                    Utility.forwardToPage("./pages/admin/login.jsp", req, resp);
                    return;
                }
            }
        }
        resp.sendRedirect(domain+"/admin");
    }
}
