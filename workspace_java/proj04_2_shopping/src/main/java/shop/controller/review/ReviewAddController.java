package shop.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DTO.ReviewDTO;
import shop.DTO.UserDTO;
import shop.service.ReviewService;

@WebServlet("/review/add")
public class ReviewAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService reviewService = new ReviewService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		String productNoStr = request.getParameter("productNo");
		String reviewContent = request.getParameter("reviewContent");
		String ratingStr = request.getParameter("rating");

		int productNo = 0;
		int rating = 0;

		try {
			productNo = Integer.parseInt(productNoStr);
			rating = Integer.parseInt(ratingStr);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/product/list");
			return;
		}

		ReviewDTO dto = new ReviewDTO();
		dto.setProductNo(productNo);
		dto.setUserNo(loginUser.getUserNo());
		dto.setReviewContent(reviewContent);
		dto.setRating(rating);

		boolean result = reviewService.addReview(dto);

		response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo);
	}
}