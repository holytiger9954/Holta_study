package com.beginagain.mes.workorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/workOrder/list")
public class WorkOrderListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("workOrderList", DemoDataFactory.workOrders());
        request.getRequestDispatcher("/WEB-INF/views/workOrder/workOrderList.jsp").forward(request, response);
    }
}
