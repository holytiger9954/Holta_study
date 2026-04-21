package com.beginagain.mes.common.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import com.beginagain.mes.emp.model.dto.EmpDto;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String cp = req.getContextPath();
        String uri = req.getRequestURI();

        boolean isPublic = uri.startsWith(cp + "/resources/")
                || uri.equals(cp + "/login")
                || uri.equals(cp + "/logout")
                || uri.equals(cp + "/changePassword")
                || uri.equals(cp + "/accessDenied")
                || uri.equals(cp + "/")
                || uri.equals(cp + "/index.jsp");

        if (isPublic) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        EmpDto loginUser = session == null ? null : (EmpDto) session.getAttribute("loginUser");
        if (loginUser == null) {
            resp.sendRedirect(cp + "/login");
            return;
        }

        if ("Y".equals(loginUser.getPwChangeRequired()) && !uri.equals(cp + "/changePassword")) {
            resp.sendRedirect(cp + "/changePassword");
            return;
        }

        chain.doFilter(request, response);
    }
}
