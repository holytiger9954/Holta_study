package shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import shop.DTO.OrderItemDTO;
import shop.util.DBUtil;


public class OrderItemDAO {

    public int insert(OrderItemDTO dto) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "INSERT INTO order_items ( "
                    + "    order_item_no, order_no, product_no, order_price, order_qty "
                    + ") VALUES ( "
                    + "    seq_order_items_no.nextval, ?, ?, ?, ? "
                    + ")";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getOrderNo());
            ps.setInt(2, dto.getProductNo());
            ps.setInt(3, dto.getOrderPrice());
            ps.setInt(4, dto.getOrderQty());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps, conn);
        }

        return result;
    }

    private void close(PreparedStatement ps, Connection conn) {
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