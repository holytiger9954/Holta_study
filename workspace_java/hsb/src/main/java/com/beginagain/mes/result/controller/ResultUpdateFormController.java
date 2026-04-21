package com.beginagain.mes.result.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/result/updateForm")
public class ResultUpdateFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("resultId");
        int id = idStr == null || idStr.isBlank() ? 1 : Integer.parseInt(idStr);
        Map<String,Object> row = DemoDataFactory.findById(DemoDataFactory.results(), "resultId", id);
        if (row == null) {
            response.sendRedirect(request.getContextPath() + "/result/list");
            return;
        }
        request.setAttribute("result", row);
        request.setAttribute("itemList", DemoDataFactory.items());
        request.setAttribute("processList", DemoDataFactory.processes());
        request.setAttribute("equipmentList", DemoDataFactory.equipments());
        request.setAttribute("planList", DemoDataFactory.plans());
        request.setAttribute("workOrderList", DemoDataFactory.workOrders());
        request.getRequestDispatcher("/WEB-INF/views/result/resultUpdate.jsp").forward(request, response);
    }
}
