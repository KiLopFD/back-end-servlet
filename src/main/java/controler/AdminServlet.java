package controler;

import common.Utility;
import dao.ProductDAO;
import entity.Category;
import entity.Product;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CategoryServices;
import services.ProductServices;
import services.UserServices;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin"})
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String domain = req.getContextPath();

        try {
            String page = req.getParameter("page");
            Boolean isLogin = (Boolean) req.getSession().getAttribute("isLogin");
            User userAccount = (User) req.getSession().getAttribute("userAccount");


            if (page != null) {
                if (page.equals("sign-up")) {
                    req.getSession().setAttribute("adminPage", "./pages/admin/sign_up.jsp");
                    resp.sendRedirect(domain + "/admin");
                    return;
                } else if (page.equals("login")) {
                    req.getSession().setAttribute("adminPage", "./pages/admin/login.jsp");
                    resp.sendRedirect(domain + "/admin");
                    return;
                } else if (page.equals("product")) {
                    String action = req.getParameter("action");
                    String productAction = req.getParameter("productAction");
                    if (action != null && action.equals("delete")){
                        Integer idProduct = Integer.parseInt(req.getParameter("idProduct"));
                        ProductDAO productDAO = new ProductDAO();
                        productDAO.delete(idProduct);
                        resp.sendRedirect(domain+"/admin");
                        return;
                    }
                    if (productAction!=null && !productAction.equals("")){
                        ProductServices productServices = new ProductServices();
                        if (productServices.actionProduct(req, resp)) {
                            req.getSession().setAttribute("notice", "success");
                            resp.sendRedirect(domain+"/admin");
                            System.out.println("Action success");
                            return;
                        }
                        else{
                            req.getSession().setAttribute("notice", "danger");
                            resp.sendRedirect(domain+"/admin");
                            System.out.println("Action fail");

                            return;
                        }
                    }

                    CategoryServices categoryServices = new CategoryServices();
                    ProductDAO productDAO = new ProductDAO();
                    List<Product> productList = productDAO.listAll();
                    List<Category> categoryList = categoryServices.listAllCategory();
                    req.setAttribute("categoryList", categoryList);
                    req.setAttribute("productList", productList);
                    req.setAttribute("showPage", "product");
                }
            }
            if (isLogin && userAccount.getRole().equals("admin")) {
                // Render section product into first time.
                // Dont set method with query param when submitting form.
                if (req.getAttribute("productList") == null || req.getAttribute("categoryList") == null || req.getAttribute("showPage") == null) {
                    resp.sendRedirect(domain+"/admin?page=product");
                    return;
                }
                Utility.forwardToPage("./pages/admin/dashboard.jsp", req, resp);
                return;
            }
            String adminPage = (String) req.getSession().getAttribute("adminPage");
            if (adminPage != null) {

                Utility.forwardToPage(adminPage, req, resp);
                return;
            }
            resp.sendRedirect(domain + "/admin?page=login");
        }
        catch (Exception e){
            req.getSession().setAttribute("notice", "danger");
            resp.sendRedirect(domain + "/admin?page=login");
        }

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

            } else if (options.equals("login")) {
                UserServices userServices = new UserServices();
                if (userServices.checkLoginUsername(req, resp)) {
                    req.getSession().setAttribute("notice", "success");
                    resp.sendRedirect(domain + "/admin");
                    return;
                } else {
                    req.getSession().setAttribute("notice", "danger");
                    Utility.forwardToPage("./pages/admin/login.jsp", req, resp);
                    return;
                }
            }
        }
        resp.sendRedirect(domain + "/admin");
    }
}
