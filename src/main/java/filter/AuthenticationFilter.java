package filter;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import common.Utility;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("AuthenticationFilter ---1-------");

//        http://localhost:8080/filter_demo_war_exploded/login

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String domain = req.getContextPath();
        String action = req.getServletPath();
        Boolean authen = (Boolean) req.getSession().getAttribute("isLogin");
//        System.out.println(domain);
        if (authen == null) {
            authen = false;
            req.getSession().setAttribute("isLogin", false);
        }


        String requestURI = ((HttpServletRequest) req).getRequestURI();;
        if (requestURI.endsWith(".jpg") || requestURI.endsWith("png")) {
            // If it's an image request, let it pass through
            System.out.println("Access allow for image: " + requestURI);

            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            // If it's not an image request, you can redirect or handle it as needed
            System.out.println("Access denied. Only images are allowed.");
        }


        if ("".equals(action) || "/".equals(action) || "/login".equals(action) || "/sign-up".equals(action)) {
            System.out.println("Filter on: " + action);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("Filter on: " + action);
            if (authen) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            resp.sendRedirect(domain + "/login");
        }
//        System.out.println("AuthenticationFilter ---2-------");
    }

    public void checkAuthentication(HttpServletRequest request, HttpServletResponse response) {

    }


}