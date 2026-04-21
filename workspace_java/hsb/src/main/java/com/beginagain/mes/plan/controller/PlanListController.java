package com.beginagain.mes.plan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/plan/list")
public class PlanListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("planList", DemoDataFactory.plans());
        request.getRequestDispatcher("/WEB-INF/views/plan/planList.jsp").forward(request, response);
    }
}
