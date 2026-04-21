package com.beginagain.mes.plan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/plan/update")
public class PlanUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("planId");
        response.sendRedirect(request.getContextPath() + "/plan/detail?planId=" + (id == null ? "1" : id));
    }
}
