package com.beginagain.mes.bom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/bomDetail/insert")
public class BomDetailInsertController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bomId = request.getParameter("bomId");
        response.sendRedirect(request.getContextPath() + "/bom/detail?bomId=" + (bomId == null ? "1" : bomId));
    }
}
