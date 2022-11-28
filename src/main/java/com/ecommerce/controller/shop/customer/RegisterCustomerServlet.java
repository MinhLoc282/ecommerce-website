package com.ecommerce.controller.shop.customer;

import com.ecommerce.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterCustomerServlet", value = "/register_customer")
public class RegisterCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerService customerService = new CustomerService(request, response);
        customerService.registerCustomer();
    }

}
