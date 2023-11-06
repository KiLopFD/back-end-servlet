package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "product", schema = "public", catalog = "backend-servlet")
@NamedQueries({
        @NamedQuery(name="Product.findAll", query = "SELECT u FROM Product u ORDER BY u.id")
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
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    public Timestamp getDatePublic() {
        return datePublic;
    }

    public void setDatePublic(Timestamp datePublic) {
        this.datePublic = datePublic;
    }

    @Basic
    @Column(name = "date_public", nullable = false)
    private Timestamp datePublic;

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

    public Product(int productId, String productName, String description, Timestamp datePublic, BigDecimal price, String urlImg, Category category) {
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
}
