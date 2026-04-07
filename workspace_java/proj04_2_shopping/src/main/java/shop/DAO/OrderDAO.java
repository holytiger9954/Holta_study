package shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.DTO.OrderDTO;
import shop.util.DBUtil;

public class OrderDAO {

	// 주문번호 시퀀스 미리 가져오기
	public int getNextOrderNo() {
		int orderNo = 0;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "SELECT SEQ_ORDERS_NO.NEXTVAL AS order_no FROM dual";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				orderNo = rs.getInt("order_no");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}

		return orderNo;
	}

	// 주문 등록
	public int insert(OrderDTO dto) {
		int result = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "" + "INSERT INTO orders ( " + "    order_no, user_no, total_price, order_status, created_at "
					+ ") VALUES ( " + "    ?, ?, ?, ?, sysdate " + ")";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getOrderNo());
			ps.setInt(2, dto.getUserNo());
			ps.setInt(3, dto.getTotalPrice());
			ps.setString(4, dto.getOrderStatus());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, ps, conn);
		}

		return result;
	}

	public boolean hasOrderedProduct(int userNo, int productNo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "" + "SELECT COUNT(*) cnt " + "FROM orders o "
					+ "JOIN order_items oi ON o.order_no = oi.order_no " + "WHERE o.user_no = ? "
					+ "  AND oi.product_no = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, productNo);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt("cnt") > 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}

		return result;
	}

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