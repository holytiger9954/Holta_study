package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/modify")
public class TodoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/todo/modify doGet 실행");

		// 요청의 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		try {
			
			// "todo_id" 받아서 출력하기
			String todo_id = request.getParameter("todo_id");
			System.out.println("todo_id: " + todo_id);
			
			int nTodo_id = Integer.parseInt(todo_id);
			
			// nTodo_id를 service --> DAO 까지 보내기
			TodoService todoService = new TodoService();
			TodoDTO todoDTO = todoService.getTodo(nTodo_id);
			
			System.out.println(todoDTO);
			
			String dueStr = "";
			if (todoDTO.getDuedate() != null) {
			    dueStr = todoDTO.getDuedate().toString();
			}
			
			PrintWriter out = response.getWriter();
			out.write("<form method=post action='" + request.getContextPath() + "/todo/modify'>");
			out.write("<br><input type='hidden' name='todo_id' value='" + todoDTO.getTodo_id() + "'>");
			out.write("<br>todo_id: " + todoDTO.getTodo_id());
			out.write("<br>duedate: <input type=date name=duedate value='" + dueStr + "'>");
			out.write("<br>done: <select type=select name=done>");
			if (todoDTO.getDone() == 0) {
				out.write("<option value='0' selected>X</option>");
				out.write("<option value='1'>O</option>");
			} else {
				out.write("<option value='0'>X</option>");
				out.write("<option value='1' selected>O</option>");
			}
			out.write("</select>");
			out.write("<br>content: <input type=text name=content value='" + todoDTO.getContent() + "'>");
			out.write("<br>ctime: " + todoDTO.getCtime());
			out.write("<br><input type=submit value=수정완료>");
			out.write("</form>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/todo/modify doPost 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		try {
			String strTodoId = request.getParameter("todo_id");
			String strDuedate = request.getParameter("duedate");
			String strDone = request.getParameter("done");
			String content = request.getParameter("content");

			int todo_id = Integer.parseInt(strTodoId);
			int done = Integer.parseInt(strDone);

			TodoService todoService = new TodoService();

			// 기존 데이터 먼저 조회
			TodoDTO originDTO = todoService.getTodo(todo_id);

			Date duedate = originDTO.getDuedate();  // 기본은 기존값 유지
			if (strDuedate != null && !strDuedate.trim().equals("")) {
			    duedate = Date.valueOf(strDuedate); // 새 날짜 들어오면 그걸로 변경
			}

			TodoDTO todoDTO = new TodoDTO();
			todoDTO.setTodo_id(todo_id);
			todoDTO.setDuedate(duedate);
			todoDTO.setDone(done);
			todoDTO.setContent(content);

			todoService.modifyTodo(todoDTO);

			response.sendRedirect(request.getContextPath() + "/todo/detail?todo_id=" + todo_id);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
