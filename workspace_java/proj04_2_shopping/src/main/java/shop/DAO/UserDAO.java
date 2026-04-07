package shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shop.DTO.UserDTO;
import shop.util.DBUtil;

public class UserDAO {

    // 회원가입
    public int insert(UserDTO dto) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "INSERT INTO users ( "
                    + "    user_no, user_id, user_pw, user_name, user_tel, "
                    + "    user_addr, user_role, created_at, updated_at "
                    + ") VALUES ( "
                    + "    seq_users_no.nextval, ?, ?, ?, ?, ?, ?, sysdate, sysdate "
                    + ")";

            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getUserId());
            ps.setString(2, dto.getUserPw());
            ps.setString(3, dto.getUserName());
            ps.setString(4, dto.getUserTel());
            ps.setString(5, dto.getUserAddr());
            ps.setString(6, dto.getUserRole());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, conn);
        }

        return result;
    }

    // 로그인
    public UserDTO login(String userId, String userPw) {
        UserDTO dto = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "SELECT * "
                    + "FROM users "
                    + "WHERE user_id = ? AND user_pw = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, userPw);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto = new UserDTO();
                dto.setUserNo(rs.getInt("user_no"));
                dto.setUserId(rs.getString("user_id"));
                dto.setUserPw(rs.getString("user_pw"));
                dto.setUserName(rs.getString("user_name"));
                dto.setUserTel(rs.getString("user_tel"));
                dto.setUserAddr(rs.getString("user_addr"));
                dto.setUserRole(rs.getString("user_role"));
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

    // 회원번호로 한 명 조회
    public UserDTO selectOne(int userNo) {
        UserDTO dto = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM users WHERE user_no = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userNo);

            rs = ps.executeQuery();

            if (rs.next()) {
                dto = new UserDTO();
                dto.setUserNo(rs.getInt("user_no"));
                dto.setUserId(rs.getString("user_id"));
                dto.setUserPw(rs.getString("user_pw"));
                dto.setUserName(rs.getString("user_name"));
                dto.setUserTel(rs.getString("user_tel"));
                dto.setUserAddr(rs.getString("user_addr"));
                dto.setUserRole(rs.getString("user_role"));
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

    // 회원정보 수정
    public int update(UserDTO dto) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = ""
                    + "UPDATE users "
                    + "SET user_pw = ?, "
                    + "    user_name = ?, "
                    + "    user_tel = ?, "
                    + "    user_addr = ?, "
                    + "    updated_at = sysdate "
                    + "WHERE user_no = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getUserPw());
            ps.setString(2, dto.getUserName());
            ps.setString(3, dto.getUserTel());
            ps.setString(4, dto.getUserAddr());
            ps.setInt(5, dto.getUserNo());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, ps, conn);
        }

        return result;
    }

    // 회원탈퇴
    public int delete(int userNo) {
        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "DELETE FROM users WHERE user_no = ?";
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

    // 아이디 중복 체크
    public boolean existsByUserId(String userId) {
        boolean exists = false;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT COUNT(*) cnt FROM users WHERE user_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);

            rs = ps.executeQuery();

            if (rs.next()) {
                exists = rs.getInt("cnt") > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }

        return exists;
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