package services;

import dao.ProductDAO;
import dao.UserDAO;
import entity.Product;
import entity.Review;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {
    private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        reviewService = new ReviewService();
    }

    @AfterEach
    void tearDown() {
        reviewService = null;
    }

    @Test
    void createReview() {
        User user = new UserDAO().get(10);
        Product product = new ProductDAO().get(4);

        boolean check= reviewService.createReview(user,product,"Hay",5);
        if(check){
            System.out.println("Tạo thành công review");
        }else{
            System.out.println("Ko tạo thành công review");
        }
    }
}