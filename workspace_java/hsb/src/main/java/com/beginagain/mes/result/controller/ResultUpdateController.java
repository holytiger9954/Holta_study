package com.beginagain.mes.result.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/result/update")
public class ResultUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("resultId");
        response.sendRedirect(request.getContextPath() + "/result/detail?resultId=" + (id == null ? "1" : id));
    }
}
