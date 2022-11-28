package com.ecommerce.controller.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserLoginFilter", value = "/admin/*")
public class UserLoginFilter extends HttpFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("userEmail") != null;
        String loginURI = httpRequest.getContextPath() + "/admin/login";
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (loggedIn && (loginRequest || loginPage)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
            requestDispatcher.forward(request, response);

        } else if (loggedIn || loginRequest) {
            chain.doFilter(request, response);

        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
