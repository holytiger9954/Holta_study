package com.beginagain.mes.workorder.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/workOrder/updateForm")
public class WorkOrderUpdateFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("workOrderId");
        int id = idStr == null || idStr.isBlank() ? 1 : Integer.parseInt(idStr);
        Map<String,Object> row = DemoDataFactory.findById(DemoDataFactory.workOrders(), "workOrderId", id);
        if (row == null) {
            response.sendRedirect(request.getContextPath() + "/workOrder/list");
            return;
        }
        request.setAttribute("workOrder", row);
        request.setAttribute("itemList", DemoDataFactory.items());
        request.setAttribute("processList", DemoDataFactory.processes());
        request.setAttribute("equipmentList", DemoDataFactory.equipments());
        request.setAttribute("planList", DemoDataFactory.plans());
        request.setAttribute("workOrderList", DemoDataFactory.workOrders());
        request.getRequestDispatcher("/WEB-INF/views/workOrder/workOrderUpdate.jsp").forward(request, response);
    }
}
