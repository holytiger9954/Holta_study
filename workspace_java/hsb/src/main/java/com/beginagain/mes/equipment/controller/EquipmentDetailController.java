package com.beginagain.mes.equipment.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/equipment/detail")
public class EquipmentDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("equipmentId");
        int id = idStr == null || idStr.isBlank() ? 1 : Integer.parseInt(idStr);
        Map<String,Object> row = DemoDataFactory.findById(DemoDataFactory.equipments(), "equipmentId", id);
        if (row == null) {
            response.sendRedirect(request.getContextPath() + "/equipment/list");
            return;
        }
        request.setAttribute("equipment", row);
        if ("bom".equals("equipment")) {
            request.setAttribute("bomDetailList", DemoDataFactory.bomDetails());
        }
        request.getRequestDispatcher("/WEB-INF/views/equipment/equipmentDetail.jsp").forward(request, response);
    }
}
