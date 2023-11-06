package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "order", schema = "public", catalog = "backend-servlet")
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


    public Order() {
    }

    public Order(int orderId, Timestamp orderDate, String statusPayment) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.statusPayment = statusPayment;
    }

    public Order(int orderId, Timestamp orderDate, String statusPayment, User infoUser) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.statusPayment = statusPayment;
        this.infoUser = infoUser;
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
}
