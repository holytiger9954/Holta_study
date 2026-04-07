package emp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import emp.DTO.EmpDTO;

public class EmpDAO {

	private Connection getConn() {
		Connection conn = null;
		try {
			// JNDI 방식
			// context.xml에 있는 DB 정보로 커넥션 풀을 가져온다
			Context ctx = new InitialContext();
			// DataSource : 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// DB 접속(그런데 이제 커넥션 풀로)
			conn = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List selectOneEmp(int empno) {
		List<EmpDTO> list = new ArrayList();

		try (Connection conn = getConn();
				PreparedStatement ps = conn.prepareStatement(
						"select * from emp where empno = ?"
				);) {
			ps.setInt(1, empno);

			try (ResultSet rs = ps.executeQuery();) {
				// 결과 활용
				while (rs.next()) {
					String ename = rs.getString("ename");
					// java.sql.Date
					Date hiredate = rs.getDate("hiredate");
					System.out.print("empno: " + empno);
					System.out.println(", ename: " + ename);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List selectAllEmp(EmpDTO empDTO) {
		List<EmpDTO> list = new ArrayList();

		try (	Connection conn = getConn();
//				PreparedStatement ps = conn.prepareStatement(
//						"SELECT * FROM ("
//						+ "	SELECT rownum as rnum, e.* FROM ("
//						+ "		SELECT emp.* FROM emp"
//						+ "		ORDER BY hiredate"
//						+ "	) e"
//						+ ")"
//						+ "WHERE rnum >= ? AND rnum <= ?"
//				);
				
				PreparedStatement ps = new LoggableStatement(
						conn, 
						"SELECT * FROM ("
						+ "	SELECT rownum as rnum, e.* FROM ("
						+ "		SELECT emp.* FROM emp"
						+ "		ORDER BY hiredate"
						+ "	) e"
						+ ")"
						+ "WHERE rnum >= ? AND rnum <= ?");
		) {
			ps.setInt(1, empDTO.getStart());
			ps.setInt(2, empDTO.getEnd());

			System.out.println(  ((LoggableStatement)ps).getQueryString()    );
			
			try (ResultSet rs = ps.executeQuery();) {
				// 결과 활용
				while (rs.next()) {
					EmpDTO dto = new EmpDTO();
					
					int empno = rs.getInt("empno");
//					System.out.println("empno: " + empno);
					dto.setEmpno(empno);
					
					dto.setEname( rs.getString("ename") );
					dto.setJob( rs.getString("job") );
					dto.setSal( rs.getInt("sal") );
					dto.setMgr( rs.getInt("mgr") );
					dto.setHiredate( rs.getDate("hiredate") );
					dto.setComm( rs.getInt("comm") );
					System.out.println(rs.getInt("comm"));
					dto.setDeptno( rs.getInt("deptno") );
					
					list.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("DAO list.size:"+ list.size());
		return list;
	}
	public int selectEmpTotal() {
		int totalCount = 0;
		
		try (	Connection conn = getConn();

				PreparedStatement ps = new LoggableStatement(
						conn, 
						"SELECT count(*) cnt FROM emp");
				) {
			
			System.out.println(  ((LoggableStatement)ps).getQueryString()    );
			
			try (ResultSet rs = ps.executeQuery();) {
				// 결과 활용
				if (rs.next()) {
					totalCount = rs.getInt("cnt");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}

}
