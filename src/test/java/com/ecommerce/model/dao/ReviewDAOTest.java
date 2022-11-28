package com.ecommerce.model.dao;

import com.ecommerce.model.entity.Customer;
import com.ecommerce.model.entity.Product;
import com.ecommerce.model.entity.Review;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReviewDAOTest {

    private static ReviewDAO reviewDao;

    @BeforeAll
    static void setUpBeforeClass() {
        reviewDao = new ReviewDAO();
    }

    @AfterAll
    static void tearDownAfterClass() {
        reviewDao.close();
    }

    @Test
    final void testCreateReview() {
        Review review = new Review();

        Product product = new Product();
        product.setProductId(1);
        Customer customer = new Customer();
        customer.setCustomerId(5);

        review.setProduct(product);
        review.setCustomer(customer);

        review.setHeadline("Excellent product!");
        review.setRating(5);
        review.setComment("A comprehensive product for best outfit");

        Review savedReview = reviewDao.create(review);

        Assertions.assertTrue(savedReview.getReviewId() > 0);
    }

    @Test
    final void testGet() {
        Review review = reviewDao.get(1);

        Assertions.assertNotNull(review);
    }

    @Test
    final void testUpdateReview() {
        Review review = reviewDao.get(1);
        review.setHeadline("Excellent product");
        Review updatedReview = reviewDao.update(review);

        Assertions.assertEquals(review.getHeadline(), updatedReview.getHeadline());
    }

    @Test
    final void testDeleteReview() {
        reviewDao.delete(2);
        Review review = reviewDao.get(2);

        Assertions.assertNull(review);
    }

    @Test
    final void testListAll() {
        List<Review> listReview = reviewDao.listAll();
        listReview.forEach(r -> System.out.println(r.getReviewId() + " - " + r.getProduct().getTitle() + " - "
                + r.getCustomer().getFullName() + " - " + r.getHeadline() + " - " + r.getRating()));

        Assertions.assertTrue(listReview.size() > 0);
    }

    @Test
    final void testCount() {
        long totalReviews = reviewDao.count();
        System.out.println("Total Reviews: " + totalReviews);

        Assertions.assertTrue(totalReviews > 0);
    }
    
}
