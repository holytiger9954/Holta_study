package com.beginagain.mes.routing.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/routing/list")
public class RoutingListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("routingList", DemoDataFactory.routings());
        request.getRequestDispatcher("/WEB-INF/views/routing/routingList.jsp").forward(request, response);
    }
}
