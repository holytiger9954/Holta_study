package com.beginagain.mes.equipment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/equipment/update")
public class EquipmentUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("equipmentId");
        response.sendRedirect(request.getContextPath() + "/equipment/detail?equipmentId=" + (id == null ? "1" : id));
    }
}
