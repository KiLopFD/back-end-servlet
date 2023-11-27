package controler;

import common.Utility;
import dao.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.MailServices;
import services.ProductServices;

import java.io.IOException;
// chuỗi "": trang chủ.
@WebServlet(value = {""})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domain = req.getContextPath();
        String action = req.getParameter("action");
        ProductDAO productDAO = new ProductDAO();

        if (action != null){
            if (action.equals("logout")) {
                req.getSession().removeAttribute("isLogin");
                req.getSession().removeAttribute("userAccount");
                resp.sendRedirect(domain + "/");
                return;
            }
            else if (action.equals("contact")) {
                MailServices mailServices = new MailServices();

                String email = req.getParameter("floating_email");
                String lastName = req.getParameter("floating_last_name");
                String firstName = req.getParameter("floating_first_name");
                String fullName = firstName + " " + lastName;
                mailServices.sendContact(fullName, email);
                resp.sendRedirect(domain+"/");
                return;

            }
        }
        // Set data to show for home page:
        req.setAttribute("listProducts", productDAO.listAll().subList(0, 5));

        Utility.forwardToPage("./index.jsp",req, resp);
    }

}
