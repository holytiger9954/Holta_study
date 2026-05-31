package kr.or.human4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        Integer loginEmpno = null;
        if(session != null) {
            loginEmpno = (Integer) session.getAttribute("loginEmpno");
        }

        if(loginEmpno == null) {
            resp.sendRedirect(req.getContextPath() + "/loginForm");
            return;
        }
        System.out.println("필터 진입");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}