package services;

import dao.OrderdetailDAO;
import entity.Orderdetail;

import java.util.List;

public class OrderDetailServices {
    private OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
//    public boolean Add(Orderdetail ordetail, Order ord)
//    {
//        try {
//            Set<Orderdetail> list = ord.getListOrderDetails();
//            list.add(ordetail);
//            return true;
//        }
//        catch (Exception e) {
//            return false;
//        }
//    }
    public boolean Del(int id)
    {
        try {
            orderdetailDAO.delete((id));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<Orderdetail> ListAll()
    {
        return orderdetailDAO.listAll();
    }

    public  Orderdetail find(int Orderdetail_id)
    {
        return  orderdetailDAO.get(Orderdetail_id);
    }
}
