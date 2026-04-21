package com.beginagain.mes.routing.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/routing/update")
public class RoutingUpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("routingId");
        response.sendRedirect(request.getContextPath() + "/routing/detail?routingId=" + (id == null ? "1" : id));
    }
}
