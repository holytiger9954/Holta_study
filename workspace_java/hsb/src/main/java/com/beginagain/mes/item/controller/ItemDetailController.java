package com.beginagain.mes.item.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/item/detail")
public class ItemDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("itemId");
        int id = idStr == null || idStr.isBlank() ? 1 : Integer.parseInt(idStr);
        Map<String,Object> row = DemoDataFactory.findById(DemoDataFactory.items(), "itemId", id);
        if (row == null) {
            response.sendRedirect(request.getContextPath() + "/item/list");
            return;
        }
        request.setAttribute("item", row);
        if ("bom".equals("item")) {
            request.setAttribute("bomDetailList", DemoDataFactory.bomDetails());
        }
        request.getRequestDispatcher("/WEB-INF/views/item/itemDetail.jsp").forward(request, response);
    }
}
