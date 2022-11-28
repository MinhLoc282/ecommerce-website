package com.ecommerce.controller.common.filter;

import com.ecommerce.model.dao.CategoryDAO;
import com.ecommerce.model.entity.Category;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "CommonFilter", value = "/*")
public class CommonFilter extends HttpFilter implements Filter {

    private final CategoryDAO categoryDAO;

    public CommonFilter() {
        categoryDAO = new CategoryDAO();
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if (!path.startsWith("/admin/")) {
            List<Category> listCategory = categoryDAO.listAll();
            request.setAttribute("listCategory", listCategory);
        }

        chain.doFilter(request, response);
    }

}
