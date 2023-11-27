package controler;

import common.Utility;
import entity.Order;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.OrderServices;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet({"/payment"})
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "";
        User user = (User) req.getSession().getAttribute("userAccount");
        if (action != null) {
            if (action.equals("wallet")) {
                url = "./pages/payment/wallet.jsp";
            }
            else if (action.equals("history")) {
                OrderServices orderServices = new OrderServices();
                BigDecimal totalPricePending = orderServices.totalPricePending(user);
                String pay = req.getParameter("pay");
                BigDecimal currentWallet = (BigDecimal) req.getSession().getAttribute("money");

                if (pay != null && pay.equals("y")) {
                    if (currentWallet.compareTo(totalPricePending) == 1) {
                        req.getSession().setAttribute("money", currentWallet.subtract(totalPricePending));
                        orderServices.payForPendingItems(user);
                        totalPricePending = orderServices.totalPricePending(user);
                    }
                }
                List<Order> orders = orderServices.listOrderByUser(user);
                req.setAttribute("totalPricePending", totalPricePending);
                req.setAttribute("orders", orders);
                System.out.println(currentWallet);
                url = "./pages/payment/history.jsp";
            }
        }
        Utility.forwardToPage(url, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        User user = (User) req.getSession().getAttribute("userAccount");

        String url = "";

        if (action != null) {
            if (action.equals("wallet")) {
                url = "./pages/payment/wallet.jsp";
                BigDecimal moneyBefore = (BigDecimal) req.getSession().getAttribute("money");
                BigDecimal money = new BigDecimal(req.getParameter("money"));
                if (money != null) {
                    if (moneyBefore.compareTo(new BigDecimal(0)) == 1) {
                        money = money.add(moneyBefore);
                    }
                    req.getSession().setAttribute("money", money);
                }
            }

        }
        Utility.forwardToPage(url, req, resp);
    }
}
