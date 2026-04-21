package com.beginagain.mes.auth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.emp.model.dto.EmpDto;

@WebServlet("/changePassword")
public class ChangePasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/auth/changePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            EmpDto loginUser = (EmpDto) session.getAttribute("loginUser");
            if (loginUser != null) {
                loginUser.setPwChangeRequired("N");
                session.setAttribute("loginUser", loginUser);
            }
        }
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
