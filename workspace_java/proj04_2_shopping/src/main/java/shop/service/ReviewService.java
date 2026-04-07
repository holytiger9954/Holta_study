package shop.service;

import java.util.List;

import shop.DAO.ReviewDAO;
import shop.DTO.ReviewDTO;

public class ReviewService {

	private ReviewDAO reviewDAO = new ReviewDAO();
	private OrderService orderService = new OrderService();

	// 특정 상품 리뷰 목록
	public List<ReviewDTO> getReviewList(int productNo) {
		if (productNo <= 0) {
			return null;
		}

		return reviewDAO.selectAllByProductNo(productNo);
	}

	// 리뷰 등록
	public boolean addReview(ReviewDTO dto) {
		if (dto == null) {
			return false;
		}

		if (dto.getProductNo() <= 0 || dto.getUserNo() <= 0) {
			return false;
		}

		if (dto.getReviewContent() == null || dto.getReviewContent().trim().equals("")) {
			return false;
		}

		if (dto.getRating() < 1 || dto.getRating() > 5) {
			return false;
		}

		// 주문한 사람만 리뷰 가능
		boolean hasOrdered = orderService.hasOrderedProduct(dto.getUserNo(), dto.getProductNo());
		if (!hasOrdered) {
			return false;
		}

		// 이미 작성한 리뷰가 있는지 확인
		ReviewDTO oldReview = reviewDAO.selectByProductNoAndUserNo(dto.getProductNo(), dto.getUserNo());
		if (oldReview != null) {
			return false;
		}

		int result = reviewDAO.insert(dto);
		return result > 0;
	}

	// 리뷰 수정
	public boolean modifyReview(ReviewDTO dto) {
		if (dto == null) {
			return false;
		}

		if (dto.getReviewNo() <= 0) {
			return false;
		}

		if (dto.getReviewContent() == null || dto.getReviewContent().trim().equals("")) {
			return false;
		}

		if (dto.getRating() < 1 || dto.getRating() > 5) {
			return false;
		}

		int result = reviewDAO.update(dto);
		return result > 0;
	}

	// 리뷰 삭제
	public boolean removeReview(int reviewNo) {
		if (reviewNo <= 0) {
			return false;
		}

		int result = reviewDAO.delete(reviewNo);
		return result > 0;
	}

	// 내가 이 상품에 쓴 리뷰 있는지
	public ReviewDTO getMyReview(int productNo, int userNo) {
		if (productNo <= 0 || userNo <= 0) {
			return null;
		}

		return reviewDAO.selectByProductNoAndUserNo(productNo, userNo);
	}

	// 리뷰 작성 가능 여부
	public boolean canWriteReview(int productNo, int userNo) {
		if (productNo <= 0 || userNo <= 0) {
			return false;
		}

		boolean hasOrdered = orderService.hasOrderedProduct(userNo, productNo);
		if (!hasOrdered) {
			return false;
		}

		ReviewDTO oldReview = reviewDAO.selectByProductNoAndUserNo(productNo, userNo);
		return oldReview == null;
	}
}