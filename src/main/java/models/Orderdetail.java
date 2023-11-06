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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Orderdetail that = (Orderdetail) object;

        if (orderDetailId != that.orderDetailId) return false;
        if (quantity != that.quantity) return false;
//        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
//        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderDetailId;
//        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
//        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }



    public Product getProductsByProductId() {
        return product;
    }

    public void setProductsByProductId(Product productsByProductId) {
        this.product = productsByProductId;
    }
}
