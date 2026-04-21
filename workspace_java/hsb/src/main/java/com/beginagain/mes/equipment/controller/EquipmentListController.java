package com.beginagain.mes.equipment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/equipment/list")
public class EquipmentListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("equipmentList", DemoDataFactory.equipments());
        request.getRequestDispatcher("/WEB-INF/views/equipment/equipmentList.jsp").forward(request, response);
    }
}
