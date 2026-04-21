package com.beginagain.mes.workorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/workOrder/update")
public class WorkOrderUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("workOrderId");
        response.sendRedirect(request.getContextPath() + "/workOrder/detail?workOrderId=" + (id == null ? "1" : id));
    }
}
