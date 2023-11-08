package common;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Utility {
    public static void forwardToPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(page).forward(request, response);
    }

    public static void forwardToPage(String page, String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("message", message);
        request.getRequestDispatcher(page).forward(request, response);
    }

}
