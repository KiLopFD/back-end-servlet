package dao;

import entity.Review;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {
    @Override
    public Review create(Review review){
        review.setReviewDate( new Date());
        return super.create(review);
    }
    @Override
    public Review get(Object id) {
        return super.find(Review.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Review.class, id);
    }

    @Override
    public List<Review> listAll() {
        return super.findWithNamedQuery("Review.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Review.countAll");
    }
}
