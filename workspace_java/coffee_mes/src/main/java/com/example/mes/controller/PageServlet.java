package com.example.mes.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        "/admin/dashboard", "/worker/dashboard",
        "/base-info", "/materials", "/work-orders", "/production", "/reports"
})
public class PageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = uri.substring(contextPath.length());

        switch (path) {
            case "/admin/dashboard":
                forward(req, resp, "/WEB-INF/views/admin-dashboard.jsp");
                break;
            case "/worker/dashboard":
                forward(req, resp, "/WEB-INF/views/worker-dashboard.jsp");
                break;
            case "/base-info":
                forward(req, resp, "/WEB-INF/views/base-info.jsp");
                break;
            case "/materials":
                forward(req, resp, "/WEB-INF/views/materials.jsp");
                break;
            case "/work-orders":
                forward(req, resp, "/WEB-INF/views/work-orders.jsp");
                break;
            case "/production":
                forward(req, resp, "/WEB-INF/views/production.jsp");
                break;
            case "/reports":
                forward(req, resp, "/WEB-INF/views/reports.jsp");
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, String viewPath) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
}
