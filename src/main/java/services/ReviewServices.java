package services;

import dao.ProductDAO;
import dao.ReviewDAO;
import entity.Product;
import entity.Review;
import entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Handling all the review function
 */
public class ReviewServices {
    private  ReviewDAO reviewDAO =new ReviewDAO();;

    public ReviewServices() {

    }

    /**
     *
     * @param user
     * @param product
     * @return Check a user has bought a product in order to allow review
     */
    public boolean checkUserHasBoughtProduct(User user,Product product){
        boolean check = false;
        List<Product> listProductsOfUser = new ProductDAO().findPaidProductsByUser(user);
        for(Product productItem : listProductsOfUser){
            if(product.equals(productItem)){
                check =true;
                break;
            }
        }
        return  check;
    }

    /**
     *
     * @param user
     * @param product
     * @param comment
     * @param rating
     * @return Create a new review
     */
    public boolean createReview(User user, Product product, String comment, int rating) {

        // Kiểm tra null cho User và Product
        if (user == null || product == null) {
            System.out.println("User hoặc Product không được để trống.");
            return false;
        }

        // Kiểm tra chuỗi rỗng cho comment
        if (comment == null || comment.isBlank()) {
            System.out.println("Comment không được để trống.");
            return false;
        }

        // Kiểm tra giá trị hợp lệ cho rating
        if (rating < 1 || rating > 5) {
            System.out.println("Rating phải nằm trong khoảng từ 1 đến 5.");
            return false;
        }
        boolean check = checkUserHasBoughtProduct(user,product);
        if(!check){
            System.out.println(user.getUsername()+" chưa mua sản phẩm 0"+product.getProductId());
            return false;
        }

        // Logic để tạo review
        try {
            Review review = new Review();
            review.setUserReview(user);
            review.setProductReview(product);
            review.setComment(comment);
            review.setRating(rating);

            reviewDAO.create(review);
            return true;
        } catch (Exception ex) {

            System.out.println(ex);
            return false;
        }
    }

    /**
     *
     * @param reviewId
     * @param comment
     * @param rating
     * @return Edit a review
     */
    public boolean editReview(int reviewId, String comment, int rating){
        if (comment == null || comment.isBlank()) {
            System.out.println("Comment không được để trống.");
            return false;
        }

        // Kiểm tra giá trị hợp lệ cho rating
        if (rating < 1 || rating > 5) {
            System.out.println("Rating phải nằm trong khoảng từ 1 đến 5.");
            return false;
        }
        try{
            Review review = reviewDAO.get(reviewId);
            review.setComment(comment);
            review.setRating(rating);
            review.setReviewDate(new Date());
            reviewDAO.update(review);

            return true;
        }
        catch (Exception ex){
            System.out.println(ex);
            return false;
        }
    }

    /**
     *
     * @param reviewId
     * @return Delete a review
     */
    public boolean deleteReview(int reviewId){
        try {
            Review review = reviewDAO.get(reviewId);
            reviewDAO.delete(reviewId);
            return true;
        }catch (Exception ex){
            System.out.println("Error:"+ex);
            return false;
        }
    }

    /**
     *
     * @return A list of all reviews
     */
    public List<Review> listAllReview(){
       return reviewDAO.listAll();
    }


    public List<Review> listAllReviewOfProduct(Product product){
        List<Review> reviewList = new ArrayList<Review>();
        if(product!= null){
            reviewList = reviewDAO.findReviewsByProduct(product);
        }
        return reviewList;
    }
}
