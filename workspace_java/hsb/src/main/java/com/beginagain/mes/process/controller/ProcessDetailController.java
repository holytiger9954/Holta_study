package com.beginagain.mes.process.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/process/detail")
public class ProcessDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("processId");
        int id = idStr == null || idStr.isBlank() ? 1 : Integer.parseInt(idStr);
        Map<String,Object> row = DemoDataFactory.findById(DemoDataFactory.processes(), "processId", id);
        if (row == null) {
            response.sendRedirect(request.getContextPath() + "/process/list");
            return;
        }
        request.setAttribute("process", row);
        if ("bom".equals("process")) {
            request.setAttribute("bomDetailList", DemoDataFactory.bomDetails());
        }
        request.getRequestDispatcher("/WEB-INF/views/process/processDetail.jsp").forward(request, response);
    }
}
