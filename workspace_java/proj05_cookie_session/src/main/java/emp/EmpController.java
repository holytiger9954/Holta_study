package emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/emp")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 너무 폐쇄적인 공간이라 로그인 안하면 안보여주는 곳
		
		// 요청의 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		HttpSession session = request.getSession();
		EmpDTO empDTO = (EmpDTO)session.getAttribute("resultDTO");
		if(empDTO == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		// 로그인 확인 했으니
		// 할 일 하면 됨
		
		// 예를 들어
		// emp 목록을 조회해서
		// 각 dto를 list에 차곡차곡 담아서
		// 받아온 list를
		// 목록 표시용 jsp로 보내고
		// 예쁘게 표시한다
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
