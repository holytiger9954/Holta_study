package com.example.mes.controller;

import com.example.mes.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*", "/worker/*", "/base-info", "/materials", "/work-orders", "/production", "/reports"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("loginUser");
        String uri = req.getRequestURI();

        if (uri.contains("/admin/") && !"ADMIN".equals(user.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/worker/dashboard");
            return;
        }

        if (uri.contains("/worker/") && !"WORKER".equals(user.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
            return;
        }

        chain.doFilter(request, response);
    }
}
