package com.beginagain.mes.plan.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/plan/updateForm")
public class PlanUpdateFormController extends HttpServlet {
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
        request.setAttribute("itemList", DemoDataFactory.items());
        request.setAttribute("processList", DemoDataFactory.processes());
        request.setAttribute("equipmentList", DemoDataFactory.equipments());
        request.setAttribute("planList", DemoDataFactory.plans());
        request.setAttribute("workOrderList", DemoDataFactory.workOrders());
        request.getRequestDispatcher("/WEB-INF/views/plan/planUpdate.jsp").forward(request, response);
    }
}
