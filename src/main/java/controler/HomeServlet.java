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
        String name = "Nguyen Van A";
        req.setAttribute("name", name);

        System.out.println(req.getSession().getAttribute("isLogin"));

        Utility.forwardToPage("./index.jsp",req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
