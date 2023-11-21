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
        if (((HttpServletRequest) servletRequest).getRequestURI().endsWith(".png")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }


        if ("".equals(action) || "/".equals(action) || "/login".equals(action) || "/sign-up".equals(action)) {
            System.out.println("Filter on: " + action);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("Filter on: " + action);
            if (authen) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            resp.sendRedirect(domain + "/login");
        }
//        System.out.println("AuthenticationFilter ---2-------");
    }

    public void checkAuthentication(HttpServletRequest request, HttpServletResponse response) {

    }


}