package com.beginagain.mes.emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("empList", DemoDataFactory.employees());
        request.getRequestDispatcher("/WEB-INF/views/emp/empList.jsp").forward(request, response);
    }
}
