package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category", schema = "public", catalog = "backend-servlet")
@NamedQueries({
        @NamedQuery(name="Category.findAll", query = "SELECT c FROM Category c"),
        @NamedQuery(name="Category.countAll", query="SELECT COUNT(*) FROM Category c"),
        @NamedQuery(name= "Category.findByName", query = "SELECT c FROM Category c WHERE c.categoryName = :name")
})
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

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }



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


}