package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order", schema = "public", catalog = "backend-servlet")
@NamedQueries({
        @NamedQuery(name="Order.findAll", query = "SELECT o FROM Order o"),
        @NamedQuery(name="Order.countAll", query = "SELECT COUNT(*) FROM Order o")
})
public class Order implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private int orderId;

    @Basic
    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;
    @Basic
    @Column(name = "status_payment", nullable = false)
    private String statusPayment;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User infoUser;


    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Orderdetail> listOrderDetails;

    public Order() {
    }

    public Order(int orderId, Timestamp orderDate, String statusPayment, User infoUser, List<Order> listOrderDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.statusPayment = statusPayment;
        this.infoUser = infoUser;
//        this.listOrderDetails = listOrderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    public User getInfoUser() {
        return infoUser;
    }

    public void setInfoUser(User infoUser) {
        this.infoUser = infoUser;
    }

//    public List<Order> getListOrderDetails() {
//        return listOrderDetails;
//    }

//    public void setListOrderDetails(List<Order> listOrderDetails) {
//        this.listOrderDetails = listOrderDetails;
//    }
}
