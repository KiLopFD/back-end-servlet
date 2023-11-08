package entity;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Basic
    @Column(name = "detail_time", nullable = false)
    private Timestamp detailTime;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productOfOrderDetail;



    public Orderdetail() {
    }

    public Orderdetail(int order_detail_id, int quantity, BigDecimal price, Timestamp detailTime, Product productOfOrderDetail, Order orderOfOrderDetail) {
        this.order_detail_id = order_detail_id;
        this.quantity = quantity;
        this.price = price;
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

    public Product getProductOfOrderDetail() {
        return productOfOrderDetail;
    }

    public void setProductOfOrderDetail(Product productOfOrderDetail) {
        this.productOfOrderDetail = productOfOrderDetail;
    }

}
