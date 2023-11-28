package filter;


import common.Utility;
import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CartServices;

import java.io.IOException;
import java.math.BigDecimal;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ImageFilter imageFilter = new ImageFilter();
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String domain = req.getContextPath();
        String action = req.getServletPath();
        Boolean authen = (Boolean) req.getSession().getAttribute("isLogin");
        BigDecimal money = (BigDecimal) req.getSession().getAttribute("money");
        // Filter authentication before sending to servlet
        if (authen == null) {
            authen = false;
            req.getSession().setAttribute("isLogin", false);
        }
        // Filter money before sending to servlet
        if (money == null) {
            req.getSession().setAttribute("money", new BigDecimal(0));
        }

        // Set Domain to Scroll Page:
        req.getSession().setAttribute("subDomain", req.getServletPath());

        // Set Notice For All Pages:
        String notice = (String) req.getSession().getAttribute("notice");
        Integer countNotice = (Integer) req.getSession().getAttribute("countNotice");

        if (countNotice == null){
            countNotice = 0;
            req.getSession().setAttribute("countNotice", countNotice);
        }

        if (countNotice == 1) {
            req.getSession().setAttribute("notice", "no notice");
            req.getSession().setAttribute("countNotice", 0);
        }
        if (notice == null){
            req.getSession().setAttribute("notice", "no notice");
        }
        else if (notice.equals("success") || notice.equals("danger")){
            req.getSession().setAttribute("countNotice", 1);
        }

        // Filter Images
        String requestURI = req.getRequestURI();;
        if (requestURI.contains("/assets/")){
            imageFilter.doFilter(servletRequest, servletResponse, filterChain);
        }


        String page = req.getParameter("page");

        if (("/admin".equals(action) )||"".equals(action) || "/".equals(action) || "/login".equals(action) || "/sign-up".equals(action)) {
            if (authen) {
                if (action.equals("") || action.equals("/")){
                    User user = (User) (req.getSession().getAttribute("userAccount"));
                    CartServices cartServices = new CartServices();
                    Integer quantityCart = cartServices.getTotalQuantity(user);
                    if (quantityCart != null) {
                        req.getSession().setAttribute("quantityCart", quantityCart); // all pages track user
                    }
                    else {
                        req.getSession().setAttribute("quantityCart", 0);
                    }
                }
                // allow page: dashboard, product dash board
                else if (action.equals("/admin")){
                    User userAccount = (User) req.getSession().getAttribute("userAccount");
                    String role = userAccount.getRole();
                    if (role!= null && role.equals("admin")){
                        filterChain.doFilter(servletRequest, servletResponse);
                        return;
                    }
                }

            }
            // If not authen in admin site => allow to sign-up, login
            if (page == "sign-up" || page == "login") {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            //
            System.out.println("Filter on: " + action);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {

            if (authen) {
                if (action.equals("/cart")) {
                    User user = (User) req.getSession().getAttribute("userAccount");
                    CartServices cartServices = new CartServices();
                    Integer quantityCart = cartServices.getTotalQuantity(user);
                    if (quantityCart != null) {
                        req.getSession().setAttribute("quantityCart", quantityCart); // all pages track
                    }
                    else {
                        req.getSession().setAttribute("quantityCart", 0); // all pages track
                    }
                }
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if ("/admin".equals(action)){
                resp.sendRedirect(domain+"/admin?page=login");
                return;
            }
            resp.sendRedirect(domain + "/login");
        }
    }



}