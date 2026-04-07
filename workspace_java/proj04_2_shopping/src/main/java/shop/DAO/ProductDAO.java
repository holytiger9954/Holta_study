package shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.DTO.ProductDTO;
import shop.util.DBUtil;

public class ProductDAO {

    // 상품 전체 조회
    public List<ProductDTO> selectAll() {
        List<ProductDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM products ORDER BY product_no DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setProductNo(rs.getInt("product_no"));
                dto.setProductName(rs.getString("product_name"));
                dto.setProductPrice(rs.getInt("product_price"));
                dto.setProductContent(rs.getString("product_content"));
                dto.setStockQty(rs.getInt("stock_qty"));
                dto.setSellerUserNo(rs.getInt("seller_user_no"));
                dto.setCreatedAt(rs.getTimestamp("created_at"));
                dto.setUpdatedAt(rs.getTimestamp("updated_at"));

                list.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }

        return list;
    }

    // 상품 1개 조회
    public ProductDTO selectOne(int productNo) {
        ProductDTO dto = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM products WHERE product_no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, productNo);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto = new ProductDTO();
                dto.setProductNo(rs.getInt("product_no"));
                dto.setProductName(rs.getString("product_name"));
                dto.setProductPrice(rs.getInt("product_price"));
                dto.setProductContent(rs.getString("product_content"));
                dto.setStockQty(rs.getInt("stock_qty"));
                dto.setSellerUserNo(rs.getInt("seller_user_no"));
                dto.setCreatedAt(rs.getTimestamp("created_at"));
                dto.setUpdatedAt(rs.getTimestamp("updated_at"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }

        return dto;
    }

    // 상품 등록
    public int insert(ProductDTO dto) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "INSERT INTO products ( "
                    + " product_no, product_name, product_price, product_content, "
                    + " stock_qty, seller_user_no, created_at, updated_at "
                    + ") VALUES ( "
                    + " seq_products_no.nextval, ?, ?, ?, ?, ?, sysdate, sysdate "
                    + ")";

            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getProductName());
            ps.setInt(2, dto.getProductPrice());
            ps.setString(3, dto.getProductContent());
            ps.setInt(4, dto.getStockQty());
            ps.setInt(5, dto.getSellerUserNo());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, conn);
        }

        return result;
    }

    // 상품 수정
    public int update(ProductDTO dto) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "UPDATE products "
                    + "SET product_name = ?, "
                    + "    product_price = ?, "
                    + "    product_content = ?, "
                    + "    stock_qty = ?, "
                    + "    updated_at = sysdate "
                    + "WHERE product_no = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getProductName());
            ps.setInt(2, dto.getProductPrice());
            ps.setString(3, dto.getProductContent());
            ps.setInt(4, dto.getStockQty());
            ps.setInt(5, dto.getProductNo());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, conn);
        }

        return result;
    }

    // 상품 삭제
    public int delete(int productNo) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "DELETE FROM products WHERE product_no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, productNo);

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, conn);
        }

        return result;
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
