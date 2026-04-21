package com.beginagain.mes.auth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.beginagain.mes.common.consts.RoleConst;
import com.beginagain.mes.emp.model.dto.EmpDto;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String empNo = request.getParameter("empNo");
        String empPwd = request.getParameter("empPwd");

        if (empNo == null || empPwd == null || empNo.isBlank() || empPwd.isBlank()) {
            request.setAttribute("errorMsg", "사원번호와 비밀번호를 입력해주세요.");
            request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
            return;
        }

        EmpDto loginUser = new EmpDto();
        loginUser.setEmpNo(empNo);
        loginUser.setEmpName("백지원");
        loginUser.setEmpId(1);
        loginUser.setPwChangeRequired("N");

        if ("worker".equalsIgnoreCase(empNo)) {
            loginUser.setRoleName(RoleConst.WORKER);
            loginUser.setEmpName("현장작업자");
        } else if ("manager".equalsIgnoreCase(empNo)) {
            loginUser.setRoleName(RoleConst.MANAGER);
            loginUser.setEmpName("현장관리자");
        } else {
            loginUser.setRoleName(RoleConst.ADMIN);
            loginUser.setEmpName("MES 관리자");
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginUser", loginUser);
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
