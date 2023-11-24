package services;

import dao.OrderdetailDAO;
import dao.ProductDAO;
import dao.UserDAO;
import entity.Product;
import entity.User;

/**
 * Handling all the orderdetail function
 */
public class OrderDetailService {
    private static OrderdetailDAO orderdetailDAO;
    public  OrderDetailService(){
        orderdetailDAO = new OrderdetailDAO();
    }
}
