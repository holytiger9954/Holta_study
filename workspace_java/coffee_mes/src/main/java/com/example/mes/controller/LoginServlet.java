package com.example.mes.controller;

import com.example.mes.model.User;
import com.example.mes.util.DemoAuthStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        User user = DemoAuthStore.authenticate(userId, password);
        if (user == null) {
            req.setAttribute("errorMessage", "아이디 또는 비밀번호를 확인해주세요.");
            doGet(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("loginUser", user);

        if ("ADMIN".equals(user.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
        } else {
            resp.sendRedirect(req.getContextPath() + "/worker/dashboard");
        }
    }
}
