package com.ecommerce.controller.shop.payment;

import com.ecommerce.service.PaymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReviewPaymentServlet", value = "/review_payment")
public class ReviewPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PaymentService paymentService = new PaymentService(request, response);
        paymentService.reviewPayment();
    }

}
