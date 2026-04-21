package com.beginagain.mes.result.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/result/list")
public class ResultListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("resultList", DemoDataFactory.results());
        request.getRequestDispatcher("/WEB-INF/views/result/resultList.jsp").forward(request, response);
    }
}
