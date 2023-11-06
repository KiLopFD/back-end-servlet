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
    @Column(name = "url_img", nullable = false)
    private String urlImg;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


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

    public Product() {
    }



    public Product(String productName, String description, BigDecimal price, String urlImg) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.urlImg = urlImg;
    }

    public Product(String productName, String description, BigDecimal price, String urlImg, Category category) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.urlImg = urlImg;
        this.category = category;
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



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Product that = (Product) object;

        if (productId != that.productId) return false;
//        if (stockQuantity != that.stockQuantity) return false;
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
//        result = 31 * result + stockQuantity;
//        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }




    public Category getCategoriesByCategoryId() {
        return category;
    }

    public void setCategoriesByCategoryId(Category categoriesByCategoryId) {
        this.category = categoriesByCategoryId;
    }




    @Override
    public String toString() {
        return "ProductsEntity{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", urlImg='" + urlImg + '\'' +
                ", categoriesByCategoryId=" + category +
                '}';
    }
}
