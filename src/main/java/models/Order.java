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
//    @Basic
//    @Column(name = "user_id", insertable=false, updatable=false)
//    private Integer userId;
    @Basic
    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;
    @Basic
    @Column(name = "status", nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User usersByUserId;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

//    public Integer getUserId() {
//        return userId;
//    }

//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Order that = (Order) object;

        if (orderId != that.orderId) return false;
//        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
//        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }





    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
