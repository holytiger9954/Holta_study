package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청의 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		// false의 경우
		// 기존에 세션이 없으면 null
		// 새로 만들지 않아 다시 접속해도 null
		// 예전게 있으면 그걸 가져옴
		HttpSession session = request.getSession(false);

		if (session == null) {
			response.getWriter().print("서버 켜진 이후에<br>");
			response.getWriter().print("여기로 처음 방문<br>");
			response.getWriter().print("로그인 안했음<br>");

		} else {
			response.getWriter().print("처음 방문은 아닌 것<br>");

//			(boolean)session.getAttribute("login");
			Boolean login = (Boolean) session.getAttribute("login");
			Integer level = (Integer) session.getAttribute("level");
			if (login == null || login != true) {
				// 로그인 안함
				response.getWriter().print("세션은 있지만<br>");
				response.getWriter().print("로그인 안함<br>");

			} else {
				response.getWriter().println("매우 사적이어서 로그인 해야함");
				response.getWriter().println("<br>");
				response.getWriter().println("userId: " + session.getAttribute("userId"));
				response.getWriter().println("<br>");
				
				// level이 1인 경우에만
				if((level <= 1)) {
					response.getWriter().println("아이고 관리자님 반갑습니다");					
				}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
