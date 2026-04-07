package shop.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DTO.UserDTO;
import shop.service.UserService;

@WebServlet("/user/update")
public class UserUpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        UserDTO user = userService.getUser(loginUser.getUserNo());
        request.setAttribute("user", user);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/update.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");
        String userTel = request.getParameter("userTel");
        String userAddr = request.getParameter("userAddr");

        UserDTO dto = new UserDTO();
        dto.setUserNo(loginUser.getUserNo());
        dto.setUserPw(userPw);
        dto.setUserName(userName);
        dto.setUserTel(userTel);
        dto.setUserAddr(userAddr);

        boolean result = userService.modifyUser(dto);

        if (result) {
            // 세션 정보도 최신화
            UserDTO updatedUser = userService.getUser(loginUser.getUserNo());
            request.getSession().setAttribute("loginUser", updatedUser);

            response.sendRedirect(request.getContextPath() + "/user/mypage");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/update");
        }
    }
}