package shop.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.ReviewService;

@WebServlet("/review/delete")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService reviewService = new ReviewService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String reviewNoStr = request.getParameter("reviewNo");
		String productNoStr = request.getParameter("productNo");

		int reviewNo = 0;
		int productNo = 0;

		try {
			reviewNo = Integer.parseInt(reviewNoStr);
			productNo = Integer.parseInt(productNoStr);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/product/list");
			return;
		}

		reviewService.removeReview(reviewNo);

		response.sendRedirect(request.getContextPath() + "/product/detail?productNo=" + productNo);
	}
}