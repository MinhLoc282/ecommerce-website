package com.ecommerce.controller.admin.review;

import com.ecommerce.service.ReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateReviewServlet", value = "/admin/update_review")
public class UpdateReviewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReviewService reviewService = new ReviewService(request, response);
        reviewService.updateReview();
    }

}
