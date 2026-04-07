package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/get")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청의 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");
		
		boolean isPopup = true;
		
		// 만약 쿠키가 하나도 없는 경우 null
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(Cookie c : cookies) {
				
				String name = c.getName();
				String value = c.getValue();
				
				System.out.printf("%s, %s\n", name, value);
				
				if("popup".equals(c.getName()) && "N".equals(c.getValue())) {
					isPopup = false;
				}
			}
			
		}
		
		if(isPopup) {
			response.getWriter().print("정보) 팝업이다");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
