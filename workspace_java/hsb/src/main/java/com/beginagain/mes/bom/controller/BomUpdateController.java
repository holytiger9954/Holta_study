package com.beginagain.mes.bom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/bom/update")
public class BomUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("bomId");
        response.sendRedirect(request.getContextPath() + "/bom/detail?bomId=" + (id == null ? "1" : id));
    }
}
