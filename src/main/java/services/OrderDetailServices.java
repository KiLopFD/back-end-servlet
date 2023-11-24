package services;

import dao.OrderdetailDAO;

/**
 * Handling all the orderdetail function
 */
public class OrderDetailServices {
    private static OrderdetailDAO orderdetailDAO;
    public OrderDetailServices(){
        orderdetailDAO = new OrderdetailDAO();
    }
}
