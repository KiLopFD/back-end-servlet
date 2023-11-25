package controler;

import common.Utility;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ProductServices;

import java.io.IOException;
// chuỗi "": trang chủ.
@WebServlet(value = {""})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domain = req.getContextPath();
        String action = req.getParameter("action");
        if (action != null){
            if (action.equals("logout")) {
                req.getSession().removeAttribute("isLogin");
                req.getSession().removeAttribute("userAccount");
                resp.sendRedirect(domain + "/");
                return;
            }
        }

        Utility.forwardToPage("./index.jsp",req, resp);
    }

}
