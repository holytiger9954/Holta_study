package com.beginagain.mes.equipment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/equipment/insertForm")
public class EquipmentInsertFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("itemList", DemoDataFactory.items());
        request.setAttribute("processList", DemoDataFactory.processes());
        request.setAttribute("equipmentList", DemoDataFactory.equipments());
        request.setAttribute("planList", DemoDataFactory.plans());
        request.setAttribute("workOrderList", DemoDataFactory.workOrders());
        request.getRequestDispatcher("/WEB-INF/views/equipment/equipmentInsert.jsp").forward(request, response);
    }
}
