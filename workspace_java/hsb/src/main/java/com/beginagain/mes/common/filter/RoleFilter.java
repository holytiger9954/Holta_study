package com.beginagain.mes.common.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import com.beginagain.mes.common.util.RoleUtil;
import com.beginagain.mes.emp.model.dto.EmpDto;

@WebFilter("/*")
public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String cp = req.getContextPath();
        String uri = req.getRequestURI();

        if (uri.startsWith(cp + "/resources/")
                || uri.equals(cp + "/login")
                || uri.equals(cp + "/logout")
                || uri.equals(cp + "/changePassword")
                || uri.equals(cp + "/accessDenied")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        EmpDto loginUser = session == null ? null : (EmpDto) session.getAttribute("loginUser");
        if (loginUser == null) {
            chain.doFilter(request, response);
            return;
        }

        if (uri.startsWith(cp + "/emp/") && !RoleUtil.isAdmin(loginUser)) {
            resp.sendRedirect(cp + "/accessDenied");
            return;
        }

        boolean adminOrManagerOnly = uri.startsWith(cp + "/item/insert")
                || uri.startsWith(cp + "/item/update")
                || uri.startsWith(cp + "/item/delete")
                || uri.startsWith(cp + "/equipment/insert")
                || uri.startsWith(cp + "/equipment/update")
                || uri.startsWith(cp + "/equipment/delete")
                || uri.startsWith(cp + "/process/insert")
                || uri.startsWith(cp + "/process/update")
                || uri.startsWith(cp + "/process/delete")
                || uri.startsWith(cp + "/bom/insert")
                || uri.startsWith(cp + "/bom/update")
                || uri.startsWith(cp + "/bom/delete")
                || uri.startsWith(cp + "/bomDetail/insert")
                || uri.startsWith(cp + "/bomDetail/delete")
                || uri.startsWith(cp + "/routing/insert")
                || uri.startsWith(cp + "/routing/update")
                || uri.startsWith(cp + "/routing/delete")
                || uri.startsWith(cp + "/plan/insert")
                || uri.startsWith(cp + "/plan/update")
                || uri.startsWith(cp + "/workOrder/insert")
                || uri.startsWith(cp + "/workOrder/update");

        if (adminOrManagerOnly && !RoleUtil.isAdminOrManager(loginUser)) {
            resp.sendRedirect(cp + "/accessDenied");
            return;
        }

        chain.doFilter(request, response);
    }
}
