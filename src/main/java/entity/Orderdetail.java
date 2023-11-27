package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "order_detail", schema = "public", catalog = "backend-servlet")
@NamedQueries({
        @NamedQuery(name = "Orderdetail.findAll", query = "SELECT od FROM Orderdetail od"),
        @NamedQuery(name = "Orderdetail.countAll", query = "SELECT COUNT(*) FROM Orderdetail od")
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

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "detail_time", nullable = false)
    private Date detailTime;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productOfOrderDetail;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;



    public Orderdetail() {
    }

    public Orderdetail(int order_detail_id, int quantity, BigDecimal price, Timestamp detailTime, Product productOfOrderDetail, Order orderOfOrderDetail) {
        this.order_detail_id = order_detail_id;
        this.quantity = quantity;
        this.totalPrice = price;
        this.detailTime = detailTime;
        this.productOfOrderDetail = productOfOrderDetail;
    }


    public int getOrderDetailId() {
        return order_detail_id;
    }

    public void setOrderDetailId(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
    public void setTotalPrice() {
        this.totalPrice = productOfOrderDetail.getPrice().multiply(BigDecimal.valueOf(quantity));
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