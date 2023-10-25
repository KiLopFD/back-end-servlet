package Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "products", schema = "public", catalog = "backend-servlet")
public class ProductsEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Basic
    @Column(name = "description", nullable = false)
    private String description;

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Basic
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Basic
    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;
    @Basic
    @Column(name = "url_img", nullable = false)
    private String urlImg;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<OrderdetailsEntity> orderdetailsByProductId;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoriesEntity categoriesByCategoryId;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<ReviewsEntity> reviewsByProductId;

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

    public ProductsEntity() {
    }


    public ProductsEntity(String productName, String description, BigDecimal price, int stockQuantity, String urlImg) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.urlImg = urlImg;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
//
//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ProductsEntity that = (ProductsEntity) object;

        if (productId != that.productId) return false;
        if (stockQuantity != that.stockQuantity) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
//        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + stockQuantity;
//        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }

    public Collection<OrderdetailsEntity> getOrderdetailsByProductId() {
        return orderdetailsByProductId;
    }

    public void setOrderdetailsByProductId(Collection<OrderdetailsEntity> orderdetailsByProductId) {
        this.orderdetailsByProductId = orderdetailsByProductId;
    }

    public CategoriesEntity getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(CategoriesEntity categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    public Collection<ReviewsEntity> getReviewsByProductId() {
        return reviewsByProductId;
    }

    public void setReviewsByProductId(Collection<ReviewsEntity> reviewsByProductId) {
        this.reviewsByProductId = reviewsByProductId;
    }
}
