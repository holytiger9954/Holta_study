package com.beginagain.mes.bom.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/bom/detail")
public class BomDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("bomId");
        int id = idStr == null || idStr.isBlank() ? 1 : Integer.parseInt(idStr);
        Map<String,Object> row = DemoDataFactory.findById(DemoDataFactory.boms(), "bomId", id);
        if (row == null) {
            response.sendRedirect(request.getContextPath() + "/bom/list");
            return;
        }
        request.setAttribute("bom", row);
        if ("bom".equals("bom")) {
            request.setAttribute("bomDetailList", DemoDataFactory.bomDetails());
        }
        request.getRequestDispatcher("/WEB-INF/views/bom/bomDetail.jsp").forward(request, response);
    }
}
