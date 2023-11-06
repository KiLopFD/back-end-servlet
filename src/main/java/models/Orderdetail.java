package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "orderdetail", schema = "public", catalog = "backend-servlet")
public class Orderdetail implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_detail_id")
    private int orderDetailId;

    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Basic
    @Column(name = "detail_time", nullable = false)
    private Timestamp detailTime;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Orderdetail() {
    }

    public Orderdetail(int orderDetailId, int quantity, BigDecimal price, Timestamp detailTime, Product product, Order order) {
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;
        this.price = price;
        this.detailTime = detailTime;
        this.product = product;
        this.order = order;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Timestamp getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(Timestamp detailTime) {
        this.detailTime = detailTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
