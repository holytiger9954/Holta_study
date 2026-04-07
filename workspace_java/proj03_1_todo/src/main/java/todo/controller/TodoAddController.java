package todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/add")
public class TodoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/todo/add doPost 실행");

		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// 파라메터 확보
		String content = request.getParameter("content");
		System.out.println("content: " + content);
		
		// DTO에 담기
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setContent(content);
		
		// service로 DTO를 보냄
		TodoService todoService = new TodoService();
		int result = todoService.addTodo(todoDTO);
		System.out.println("result: " + result);
		
		////////////////////////////////////////////
		
//		request.getRequestDispatcher("/todo").forward(request, response);
		
		response.sendRedirect("/proj03_1_todo/todo");

	}

}
