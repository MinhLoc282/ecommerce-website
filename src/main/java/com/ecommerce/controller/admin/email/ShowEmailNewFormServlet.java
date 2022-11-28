package com.ecommerce.controller.admin.email;

import com.ecommerce.service.EmailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowEmailNewFormServlet", value = "/admin/new_email")
public class ShowEmailNewFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmailService emailService = new EmailService(request, response);
        emailService.showEmailNewForm();
    }

}
