package com.beginagain.mes.routing.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/routing/detail")
public class RoutingDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("routingId");
        int id = idStr == null || idStr.isBlank() ? 1 : Integer.parseInt(idStr);
        Map<String,Object> row = DemoDataFactory.findById(DemoDataFactory.routings(), "routingId", id);
        if (row == null) {
            response.sendRedirect(request.getContextPath() + "/routing/list");
            return;
        }
        request.setAttribute("routing", row);
        if ("bom".equals("routing")) {
            request.setAttribute("bomDetailList", DemoDataFactory.bomDetails());
        }
        request.getRequestDispatcher("/WEB-INF/views/routing/routingDetail.jsp").forward(request, response);
    }
}
