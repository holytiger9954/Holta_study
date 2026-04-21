package com.beginagain.mes.bom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/bom/list")
public class BomListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("bomList", DemoDataFactory.boms());
        request.getRequestDispatcher("/WEB-INF/views/bom/bomList.jsp").forward(request, response);
    }
}
