

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/calc doGet 실행");
		
		String val1 = request.getParameter("val1");
		String val2 = request.getParameter("val2");
		
		int result = Integer.parseInt(val1) + Integer.parseInt(val2);
		response.getWriter().println("<h1>");
		response.getWriter().println(result);
		response.getWriter().println("</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/calc doPost 실행");
	}

}
