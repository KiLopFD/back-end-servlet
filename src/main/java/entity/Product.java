package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "product", schema = "public", catalog = "backend-servlet")
@NamedQueries({
        @NamedQuery(name="Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name="Product.countAll", query = "SELECT COUNT(*) FROM Product p"),
        @NamedQuery(name = "Product.findPaidProductsByUser", query = "SELECT p FROM Product p JOIN Orderdetail od ON p.productId = od.productOfOrderDetail.productId JOIN Order o ON od.order.orderId = o.orderId WHERE o.statusPayment = 'paid' AND o.infoUser = :user"),
})
public class Product implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Basic
    @Column(name = "description",nullable = false, length = 16777215)
    private String description;



    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "date_public", nullable = false, length = 19)
    private Date datePublic;

    @Basic
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Basic
    @Column(name = "url_img", nullable = false)
    private String urlImg;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    public Product() {
    }
    public Product(int id){
        this.productId = id;
    }

    public Product(int productId, String productName, String description, Date datePublic, BigDecimal price, String urlImg, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.datePublic = datePublic;
        this.price = price;
        this.urlImg = urlImg;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDatePublic() {
        return datePublic;
    }

    public void setDatePublic(Date datePublic) {
        this.datePublic = datePublic;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductId() == product.getProductId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId());
    }
}