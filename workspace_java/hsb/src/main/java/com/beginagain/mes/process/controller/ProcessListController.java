package com.beginagain.mes.process.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/process/list")
public class ProcessListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("processList", DemoDataFactory.processes());
        request.getRequestDispatcher("/WEB-INF/views/process/processList.jsp").forward(request, response);
    }
}
