package shop.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.DTO.ProductDTO;
import shop.DTO.ReviewDTO;
import shop.DTO.UserDTO;
import shop.service.ProductService;
import shop.service.ReviewService;

@WebServlet("/product/detail")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();

	private ReviewService reviewService = new ReviewService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		String productNoStr = request.getParameter("productNo");

		int productNo = 0;

		try {
			productNo = Integer.parseInt(productNoStr);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/product/list");
			return;
		}

		ProductDTO product = productService.getProduct(productNo);

		if (product == null) {
			response.sendRedirect(request.getContextPath() + "/product/list");
			return;
		}

		// 1. 리뷰 목록 조회
		List<ReviewDTO> reviewList = reviewService.getReviewList(productNo);
		request.setAttribute("reviewList", reviewList);

		// 2. 로그인 사용자 기준 처리
		if (loginUser != null) {

			// 내가 이 상품에 리뷰 썼는지
			ReviewDTO myReview = reviewService.getMyReview(productNo, loginUser.getUserNo());

			// 리뷰 작성 가능 여부 (주문 여부 + 중복 체크)
			boolean canWriteReview = reviewService.canWriteReview(productNo, loginUser.getUserNo());

			request.setAttribute("myReview", myReview);
			request.setAttribute("canWriteReview", canWriteReview);
		}

		request.setAttribute("product", product);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/product/detail.jsp");
		rd.forward(request, response);
	}
}