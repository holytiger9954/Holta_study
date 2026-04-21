package com.beginagain.mes.plan.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/plan/detail")
public class PlanDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("planId");
        int id = idStr == null || idStr.isBlank() ? 1 : Integer.parseInt(idStr);
        Map<String,Object> row = DemoDataFactory.findById(DemoDataFactory.plans(), "planId", id);
        if (row == null) {
            response.sendRedirect(request.getContextPath() + "/plan/list");
            return;
        }
        request.setAttribute("plan", row);
        if ("bom".equals("plan")) {
            request.setAttribute("bomDetailList", DemoDataFactory.bomDetails());
        }
        request.getRequestDispatcher("/WEB-INF/views/plan/planDetail.jsp").forward(request, response);
    }
}
