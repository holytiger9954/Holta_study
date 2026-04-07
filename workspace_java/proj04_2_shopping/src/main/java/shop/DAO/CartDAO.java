package shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.DTO.CartDTO;
import shop.DTO.CartViewDTO;
import shop.util.DBUtil;

public class CartDAO {

	// 장바구니 추가 전 중복 확인
	public CartDTO selectByUserNoAndProductNo(int userNo, int productNo) {
		CartDTO dto = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "SELECT * FROM cart WHERE user_no = ? AND product_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, productNo);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new CartDTO();
				dto.setCartNo(rs.getInt("cart_no"));
				dto.setUserNo(rs.getInt("user_no"));
				dto.setProductNo(rs.getInt("product_no"));
				dto.setCartQty(rs.getInt("cart_qty"));
				dto.setAddedAt(rs.getTimestamp("added_at"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}

		return dto;
	}

	// 장바구니 새로 추가
	public int insert(CartDTO dto) {
		int result = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "" + "INSERT INTO cart ( " + "    cart_no, user_no, product_no, cart_qty, added_at "
					+ ") VALUES ( " + "    seq_cart_no.nextval, ?, ?, ?, sysdate " + ")";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getUserNo());
			ps.setInt(2, dto.getProductNo());
			ps.setInt(3, dto.getCartQty());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, ps, conn);
		}

		return result;
	}

	// 기존 장바구니 수량 증가
	public int increaseQty(int cartNo, int qty) {
		int result = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "UPDATE cart SET cart_qty = cart_qty + ? WHERE cart_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qty);
			ps.setInt(2, cartNo);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, ps, conn);
		}

		return result;
	}

	// 회원 장바구니 전체 조회
	public List<CartDTO> selectAllByUserNo(int userNo) {
		List<CartDTO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "SELECT * FROM cart WHERE user_no = ? ORDER BY cart_no DESC";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userNo);

			rs = ps.executeQuery();

			while (rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setCartNo(rs.getInt("cart_no"));
				dto.setUserNo(rs.getInt("user_no"));
				dto.setProductNo(rs.getInt("product_no"));
				dto.setCartQty(rs.getInt("cart_qty"));
				dto.setAddedAt(rs.getTimestamp("added_at"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}

		return list;
	}

	// 장바구니 1건 조회
	public CartDTO selectOne(int cartNo) {
		CartDTO dto = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "SELECT * FROM cart WHERE cart_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cartNo);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new CartDTO();
				dto.setCartNo(rs.getInt("cart_no"));
				dto.setUserNo(rs.getInt("user_no"));
				dto.setProductNo(rs.getInt("product_no"));
				dto.setCartQty(rs.getInt("cart_qty"));
				dto.setAddedAt(rs.getTimestamp("added_at"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}

		return dto;
	}

	// 장바구니 수량 수정
	public int updateQty(int cartNo, int cartQty) {
		int result = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "UPDATE cart SET cart_qty = ? WHERE cart_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cartQty);
			ps.setInt(2, cartNo);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, ps, conn);
		}

		return result;
	}

	// 장바구니 삭제
	public int delete(int cartNo) {
		int result = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "DELETE FROM cart WHERE cart_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cartNo);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, ps, conn);
		}

		return result;
	}

	// 회원 장바구니 전체 삭제
	public int deleteAllByUserNo(int userNo) {
		int result = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "DELETE FROM cart WHERE user_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userNo);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, ps, conn);
		}

		return result;
	}

	// 장바구니 목록
	public List<CartViewDTO> selectCartViewByUserNo(int userNo) {
		List<CartViewDTO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "" + "SELECT " + "    c.cart_no, " + "    c.user_no, " + "    c.product_no, "
					+ "    p.product_name, " + "    p.product_price, " + "    c.cart_qty, "
					+ "    (p.product_price * c.cart_qty) AS total_price, " + "    c.added_at " + "FROM cart c "
					+ "JOIN products p ON c.product_no = p.product_no " + "WHERE c.user_no = ? "
					+ "ORDER BY c.cart_no DESC";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, userNo);

			rs = ps.executeQuery();

			while (rs.next()) {
				CartViewDTO dto = new CartViewDTO();

				dto.setCartNo(rs.getInt("cart_no"));
				dto.setUserNo(rs.getInt("user_no"));
				dto.setProductNo(rs.getInt("product_no"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductPrice(rs.getInt("product_price"));
				dto.setCartQty(rs.getInt("cart_qty"));
				dto.setTotalPrice(rs.getInt("total_price"));
				dto.setAddedAt(rs.getTimestamp("added_at"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}

		return list;
	}

	// 자원 정리 메소드화
	private void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}