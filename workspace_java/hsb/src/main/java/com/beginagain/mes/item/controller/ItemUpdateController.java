package com.beginagain.mes.item.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/item/update")
public class ItemUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("itemId");
        response.sendRedirect(request.getContextPath() + "/item/detail?itemId=" + (id == null ? "1" : id));
    }
}
