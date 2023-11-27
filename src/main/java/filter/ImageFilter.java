package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter({"/assets/*", "/phono-demo.myshopify.com/cdn/shop/files/*"})
public class ImageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String domain = req.getContextPath();
        String action = req.getServletPath();
        // Filter images before sending to servlet
        String requestURI = req.getRequestURI();;
        if ((requestURI.endsWith(".jpg") || requestURI.endsWith(".png")) && requestURI.contains("/assets/images/")) {
            // If it's an image request, let it pass through
            System.out.println("Access allow for asset image: " + requestURI);
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else if (requestURI.endsWith(".jpg") || requestURI.endsWith(".png")) {
            System.out.println("Access allow for url image: " + requestURI);
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            System.out.println("Access deny for image: " + requestURI);
        }
    }
}
