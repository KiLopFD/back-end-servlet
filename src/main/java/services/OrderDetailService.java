package services;

import dao.OrderdetailDAO;
import dao.ProductDAO;
import dao.UserDAO;
import entity.Product;
import entity.User;


public class OrderDetailService {
    private static OrderdetailDAO orderdetailDAO;
    public  OrderDetailService(){
        orderdetailDAO = new OrderdetailDAO();
    }
    public void addOrderDetail(Product product)
    {

    }
    boolean checkUserPurchasedProduct(){
        User user = new UserDAO().get(10);
        Product product = new ProductDAO().get(4);
        boolean check = orderdetailDAO.hasUserPurchasedProduct(user,product);

        return check;

    }
}
