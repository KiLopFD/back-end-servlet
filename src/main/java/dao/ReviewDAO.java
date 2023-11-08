package dao;

import entity.Review;

import java.util.List;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {
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
