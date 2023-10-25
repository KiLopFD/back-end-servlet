package Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "reviews", schema = "public", catalog = "backend-servlet")
public class ReviewsEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id")
    private int reviewId;


    //    @Basic
//    @Column(name = "product_id", insertable=false, updatable=false)
//    private Integer productId;
//    @Basic
//    @Column(name = "user_id", insertable=false, updatable=false)
//    private Integer userId;
    @Basic
    @Column(name = "rating")
    private int rating;

    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Basic
    @Column(name = "review_date", nullable = false)
    private Timestamp reviewDate;
    @Basic
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductsEntity productsByProductId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UsersEntity usersByUserId;


    public ReviewsEntity(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public ReviewsEntity() {
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ReviewsEntity that = (ReviewsEntity) object;

        if (reviewId != that.reviewId) return false;
        if (rating != that.rating) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewId;
        result = 31 * result + rating;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
