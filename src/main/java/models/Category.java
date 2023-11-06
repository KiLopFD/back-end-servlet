package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "categories", schema = "public", catalog = "backend-servlet")
public class Category implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;
    public Category() {
    }
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }



    @OneToMany(mappedBy = "category")
    private Collection<Product> listProduct;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Category that = (Category) object;

        if (categoryId != that.categoryId) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    public Collection<Product> getProductsByCategoryId() {
        return listProduct;
    }

    public void setProductsByCategoryId(Collection<Product> productsByCategoryId) {
        this.listProduct = productsByCategoryId;
    }

    @Override
    public String toString() {
        return "CategoriesEntity{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
