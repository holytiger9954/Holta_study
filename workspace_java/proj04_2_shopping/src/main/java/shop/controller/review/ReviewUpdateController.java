package shop.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DTO.ReviewDTO;
import shop.service.ReviewService;

@WebServlet("/review/update")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService reviewService = new ReviewService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String reviewNoStr = request.getParameter("reviewNo");
		String productNoStr = request.getParameter("productNo");
		String reviewContent = request.getParameter("reviewContent");
		String ratingStr = request.getParameter("rating");

		int reviewNo = 0;
		int productNo = 0;
		int rating = 0;

		try {
			reviewNo = Integer.parseInt(reviewNoStr);
			productNo = Integer.parseInt(productNoStr);
			rating = Integer.parseInt(ratingStr);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/product/list");
			return;
		}

		ReviewDTO dto = new ReviewDTO();
		dto.setReviewNo(reviewNo);
		dto.setReviewContent(reviewContent);
		dto.setRating(rating);

		reviewService.modifyReview(dto);

		response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo);
	}
}