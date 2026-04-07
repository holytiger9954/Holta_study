package shop.controller.user;

import java.io.IOException;

import shop.DTO.UserDTO;
import shop.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/join")
public class UserJoinController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/join.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");
        String userTel = request.getParameter("userTel");
        String userAddr = request.getParameter("userAddr");

        UserDTO dto = new UserDTO();
        dto.setUserId(userId);
        dto.setUserPw(userPw);
        dto.setUserName(userName);
        dto.setUserTel(userTel);
        dto.setUserAddr(userAddr);
        dto.setUserRole("USER");

        boolean result = userService.join(dto);

        if (result) {
            response.sendRedirect(request.getContextPath() + "/user/login");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/join");
        }
    }
}