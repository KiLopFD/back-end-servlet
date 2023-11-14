package dao;

import entity.Product;
import entity.Review;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewDAOTest {
    private static ReviewDAO reviewDAO;

    @BeforeEach
    void setUp() throws Exception{
        reviewDAO = new ReviewDAO();
    }

    @AfterEach
    void tearDown() throws Exception {
        reviewDAO.close();
    }

    @Test
    void create() {
        Review review = new Review();
        Product product = new ProductDAO().get(3);
        User user = new UserDAO().get(1);
        review.setReviewDate(new Date());
        review.setProductReview(product);
        review.setUserReview(user);
        review.setRating(2);
        review.setComment("Điện thoại trung quốc");

        Review newReview = reviewDAO.create(review);
        assertTrue(newReview.getReviewId() > 0);
    }

    @Test
    void get() {
        Review review = new ReviewDAO().get(1);
        System.out.println(review.getComment());
        assertNotNull(review);

    }

    @Test
    void delete() {
        int id = 2;
        reviewDAO.delete(id);

        Review review = reviewDAO.get(id);

        assertNull(review);
    }

    @Test
    void listAll() {
        List<Review> listReviews = reviewDAO.listAll();
        for(Review review : listReviews){
            System.out.println(review.getUserReview()+"---"+review.getProductReview()+"---"+review.getComment());
        }
        assertTrue(!listReviews.isEmpty());
    }

    @Test
    void count() {
        long totalReviews = reviewDAO.count();
        System.out.println(totalReviews);
        assertTrue(totalReviews >0);
    }
    @Test
    void update(){
        Review review = reviewDAO.get(1);
        review.setComment("Chán");
        Review updatedReview = new ReviewDAO().update(review);
        assertEquals(review.getComment(),updatedReview.getComment());
    }
}