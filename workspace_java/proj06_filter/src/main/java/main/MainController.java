package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("/main doGet 실행");
		
		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("login");
		
		if(login != null) {
			// 로그인 한 사람만 실행
			request.setAttribute("passCode", "1234");
			request.setAttribute("암구호", "짜장면");
			
			request.getRequestDispatcher("/WEB-INF/view/secret.jsp").forward(request, response);			
		} else {
			// 안한 사람은 로그인 페이지로 이동
			response.sendRedirect("login.jsp");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
