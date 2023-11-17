package dao;

import entity.Order;
import entity.Review;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Review findByUserAndProduct(Integer userId, Integer productId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("productId", productId);

        List<Review> result = super.findWithNamedQuery("Review.findByUserAndProduct", parameters);

        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
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
