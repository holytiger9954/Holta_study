package shop.controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DTO.UserDTO;
import shop.service.OrderService;

@WebServlet("/order/add")
public class OrderAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		boolean result = orderService.placeOrder(loginUser.getUserNo());

		if (result) {
			response.sendRedirect(request.getContextPath() + "/order/success");
		} else {
			response.sendRedirect(request.getContextPath() + "/cart/list");
		}
	}
}