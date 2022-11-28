package com.ecommerce.controller.admin.product;

import com.ecommerce.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateProductServlet", value = "/admin/update_product")
@MultipartConfig(fileSizeThreshold = 1024 * 10, // 10 KB
        maxFileSize = 1024 * 300, // 300 KB
        maxRequestSize = 1024 * 1024 // 1 MB
)
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductService productService = new ProductService(request, response);
        productService.updateProduct();
    }

}
