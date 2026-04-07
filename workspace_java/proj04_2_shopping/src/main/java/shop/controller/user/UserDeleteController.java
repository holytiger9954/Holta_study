package shop.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DTO.UserDTO;
import shop.service.UserService;

@WebServlet("/user/delete")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		boolean result = userService.removeUser(loginUser.getUserNo());

		if (result) {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/user/login");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/mypage");
		}
	}
}