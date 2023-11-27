package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "review", schema = "public", catalog = "backend-servlet")
@NamedQueries({
        @NamedQuery(name="Review.findAll", query = "SELECT r FROM Review r"),
        @NamedQuery(name="Review.countAll", query = "SELECT COUNT(*) FROM Review r"),
        @NamedQuery(name ="Review.findByProduct",query = "SELECT r from Review  r WHERE  r.productReview=:product"),
})
public class Review implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id")
    private int reviewId;
    @Basic
    @Column(name = "rating")
    private int rating;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "review_date", nullable = false)
    private Date reviewDate;
    @Basic
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product productReview;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userReview;

    public Review() {
    }
    public Review(int reviewId, int rating, Date reviewDate, String comment, Product productReview, User userReview) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.comment = comment;
        this.productReview = productReview;
        this.userReview = userReview;
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

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProductReview() {
        return productReview;
    }


    public void setProductReview(Product productReview) {
        this.productReview = productReview;
    }

    public User getUserReview() {
        return userReview;
    }

    public void setUserReview(User userReview) {
        this.userReview = userReview;
    }
}