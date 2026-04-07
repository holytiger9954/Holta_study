package todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.service.TodoService;

@WebServlet("/todo/delete")
public class TodoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/todo/delete doPost 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		try {

			String strTodoId = request.getParameter("todo_id");

			if (strTodoId == null || strTodoId.trim().equals("")) {
				response.sendRedirect(request.getContextPath() + "/todo");
				return;
			}

			int todo_id = Integer.parseInt(strTodoId);

			TodoService todoService = new TodoService();
			todoService.removeTodo(todo_id);

			response.sendRedirect(request.getContextPath() + "/todo");

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("삭제 중 오류 발생");
		}

	}

}
