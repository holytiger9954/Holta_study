package shop.controller.user;

import java.io.IOException;

import shop.DTO.UserDTO;
import shop.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/user/mypage")
public class MyPageController extends HttpServlet {
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

		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		request.setAttribute("user", user);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp");
		rd.forward(request, response);
	}
}