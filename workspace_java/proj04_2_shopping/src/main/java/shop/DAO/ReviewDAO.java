package shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.DTO.ReviewDTO;
import shop.util.DBUtil;

public class ReviewDAO {

    // 리뷰 등록
    public int insert(ReviewDTO dto) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "INSERT INTO reviews ( "
                    + "    review_no, product_no, user_no, review_content, rating, created_at, updated_at "
                    + ") VALUES ( "
                    + "    seq_reviews_no.nextval, ?, ?, ?, ?, sysdate, sysdate "
                    + ")";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getProductNo());
            ps.setInt(2, dto.getUserNo());
            ps.setString(3, dto.getReviewContent());
            ps.setInt(4, dto.getRating());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, conn);
        }

        return result;
    }

    // 특정 상품 리뷰 전체 조회
    public List<ReviewDTO> selectAllByProductNo(int productNo) {
        List<ReviewDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "SELECT * "
                    + "FROM reviews "
                    + "WHERE product_no = ? "
                    + "ORDER BY review_no DESC";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, productNo);

            rs = ps.executeQuery();

            while (rs.next()) {
                ReviewDTO dto = new ReviewDTO();
                dto.setReviewNo(rs.getInt("review_no"));
                dto.setProductNo(rs.getInt("product_no"));
                dto.setUserNo(rs.getInt("user_no"));
                dto.setReviewContent(rs.getString("review_content"));
                dto.setRating(rs.getInt("rating"));
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

    // 리뷰 1건 조회
    public ReviewDTO selectOne(int reviewNo) {
        ReviewDTO dto = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM reviews WHERE review_no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reviewNo);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto = new ReviewDTO();
                dto.setReviewNo(rs.getInt("review_no"));
                dto.setProductNo(rs.getInt("product_no"));
                dto.setUserNo(rs.getInt("user_no"));
                dto.setReviewContent(rs.getString("review_content"));
                dto.setRating(rs.getInt("rating"));
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

    // 특정 회원이 특정 상품에 작성한 리뷰 조회
    public ReviewDTO selectByProductNoAndUserNo(int productNo, int userNo) {
        ReviewDTO dto = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM reviews WHERE product_no = ? AND user_no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, productNo);
            ps.setInt(2, userNo);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto = new ReviewDTO();
                dto.setReviewNo(rs.getInt("review_no"));
                dto.setProductNo(rs.getInt("product_no"));
                dto.setUserNo(rs.getInt("user_no"));
                dto.setReviewContent(rs.getString("review_content"));
                dto.setRating(rs.getInt("rating"));
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

    // 리뷰 수정
    public int update(ReviewDTO dto) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "UPDATE reviews "
                    + "SET review_content = ?, "
                    + "    rating = ?, "
                    + "    updated_at = sysdate "
                    + "WHERE review_no = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getReviewContent());
            ps.setInt(2, dto.getRating());
            ps.setInt(3, dto.getReviewNo());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, conn);
        }

        return result;
    }

    // 리뷰 삭제
    public int delete(int reviewNo) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "DELETE FROM reviews WHERE review_no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reviewNo);

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, conn);
        }

        return result;
    }

    // 특정 상품의 리뷰 개수
    public int countByProductNo(int productNo) {
        int count = 0;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT COUNT(*) cnt FROM reviews WHERE product_no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, productNo);

            rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt("cnt");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }

        return count;
    }

    // 특정 상품 평균 별점
    public double avgRatingByProductNo(int productNo) {
        double avg = 0;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT NVL(AVG(rating), 0) avg_rating FROM reviews WHERE product_no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, productNo);

            rs = ps.executeQuery();

            if (rs.next()) {
                avg = rs.getDouble("avg_rating");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }

        return avg;
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
