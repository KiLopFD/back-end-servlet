package models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "reviews", schema = "public", catalog = "backend-servlet")
public class Review implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id")
    private int reviewId;
    @Basic
    @Column(name = "rating")
    private int rating;
    @Basic
    @Column(name = "review_date", nullable = false)
    private Timestamp reviewDate;
    @Basic
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productsByProductId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userReview;

    public Review() {
    }

    public Review(int reviewId, int rating, Timestamp reviewDate, String comment, Product productsByProductId, User userReview) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.comment = comment;
        this.productsByProductId = productsByProductId;
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

    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Product productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    public User getUserReview() {
        return userReview;
    }

    public void setUserReview(User userReview) {
        this.userReview = userReview;
    }
}
