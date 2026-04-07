package todo.service;

import java.util.List;

import todo.DAO.TodoDAO;
import todo.DTO.TodoDTO;

public class TodoService {

	public List getList() {
		// TodoDAO의 selectAll을 호출하고
		// 그 List를 return 해주세요

		TodoDAO todoDAO = new TodoDAO();
		List list = todoDAO.selectAll();

		return list;
	}

	public TodoDTO getTodo(int todo_id) {
		TodoDAO todoDAO = new TodoDAO();
		TodoDTO todoDTO = todoDAO.selectOne(todo_id);
		return todoDTO;
	}

	public int addTodo(TodoDTO todoDTO) {
		TodoDAO todoDAO = new TodoDAO();
		int result = todoDAO.insertTodo(todoDTO);
		return result;
	}

	public int modifyTodo(TodoDTO todoDTO) {
		TodoDAO todoDAO = new TodoDAO();
		int result = todoDAO.updateTodo(todoDTO);
		return result;
	}

	public int removeTodo(int todo_id) {
		TodoDAO todoDAO = new TodoDAO();
		int result = todoDAO.deleteTodo(todo_id);
		return result;
	}
}
