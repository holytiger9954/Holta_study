package com.beginagain.mes.item.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.demo.DemoDataFactory;

@WebServlet("/item/list")
public class ItemListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("itemList", DemoDataFactory.items());
        request.getRequestDispatcher("/WEB-INF/views/item/itemList.jsp").forward(request, response);
    }
}
