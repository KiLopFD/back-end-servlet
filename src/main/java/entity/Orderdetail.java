package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "order_details", schema = "public", catalog = "backend-servlet")
@NamedQueries({
        @NamedQuery(name="Orderdetail.findAll", query = "SELECT od FROM Orderdetail od"),
        @NamedQuery(name="Orderdetail.countAll", query = "SELECT COUNT(*) FROM Orderdetail od")
})
public class Orderdetail implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_detail_id")
    private int order_detail_id;

    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Basic
    @Column(name = "detail_time", nullable = false)
    private Date detailTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product productOfOrderDetail;



    public Orderdetail() {
    }

    public Orderdetail(int order_detail_id, int quantity, BigDecimal price, Timestamp detailTime, Product productOfOrderDetail, Order orderOfOrderDetail) {
        this.order_detail_id = order_detail_id;
        this.quantity = quantity;
        this.totalPrice = price;
        this.detailTime = detailTime;
        this.productOfOrderDetail = productOfOrderDetail;
    }


    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(Date detailTime) {
        this.detailTime = detailTime;
    }

    public Product getProductOfOrderDetail() {
        return productOfOrderDetail;
    }

    public void setProductOfOrderDetail(Product productOfOrderDetail) {
        this.productOfOrderDetail = productOfOrderDetail;
    }

}
