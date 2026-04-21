package com.beginagain.mes.process.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/process/update")
public class ProcessUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("processId");
        response.sendRedirect(request.getContextPath() + "/process/detail?processId=" + (id == null ? "1" : id));
    }
}
